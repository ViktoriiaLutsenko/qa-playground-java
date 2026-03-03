# E2E tests

End-to-end tests built with [Playwright](https://playwright.dev/docs/writing-tests). Tests cover smoke and regression scenarios for the Paligo CCMS application.

- [E2E tests](#e2e-tests)
  - [Prerequisites](#prerequisites)
  - [Use](#use)
    - [Install](#install)
    - [Environment variables](#environment-variables)
    - [Run from console (repo root)](#run-from-console-repo-root)
    - [Equivalent from e2e folder](#equivalent-from-e2e-folder)
    - [VS Code Playwright plugin](#vs-code-playwright-plugin)
    - [Selection rules](#selection-rules)
  - [Develop](#develop)
    - [Structure](#structure)
    - [Auth](#auth)
    - [Writing tests](#writing-tests)
    - [Selecting elements](#selecting-elements)
    - [Generating locators](#generating-locators)
  - [Debugging](#debugging)
    - [Local debugging](#local-debugging)
    - [Debugging on CI](#debugging-on-ci)
  - [Failing tests](#failing-tests)
    - [Test report](#test-report)
    - [Trace file](#trace-file)
    - [Common errors](#common-errors)
      - [Expectations failing shortly after navigation](#expectations-failing-shortly-after-navigation)
      - [Timeouts](#timeouts)
      - [Strict mode violation](#strict-mode-violation)

## Prerequisites

- Node.js 20, 22, or 24
- `pnpm` installed globally
- A running local Paligo instance (or access to the target environment)

## Use

### Install

From repo root:

```sh
pnpm install
```

### Environment variables

| Variable | Default | Description |
| --- | --- | --- |
| `TEST_USER_PASSWORD` | _(shared password)_ | Override the password for all test users (`admin`, `author`, `contributor`, `reviewer`) |
| `TEST_TIMEOUT_MULTIPLIER` | `1` | Scale all timeouts by this factor (e.g. `1.5` on slow machines) |

### Run from console (repo root)

Use repo-root commands as the default style:

| Command | Description |
| --- | --- |
| `pnpm --filter "e2e" test` | Run all E2E tests |
| `pnpm --filter "e2e" test --help` | Show all Playwright CLI options |
| `pnpm --filter "e2e" dev` | Open Playwright UI mode |
| `pnpm --filter "e2e" debug` | Run in Playwright debug mode |
| `pnpm --filter "e2e" record` | Open codegen recorder |

Common scenarios — use filename regex with `--retries=1` as the standard form:

All smoke:

```sh
pnpm --filter "e2e" test -- ".*\.smoke\.spec\.ts$" --retries=1
```

All regression:

```sh
pnpm --filter "e2e" test -- ".*\.regression\.spec\.ts$" --retries=1
```

Folder-specific smoke (example: `new-main-editor`):

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\.smoke\.spec\.ts$" --retries=1
```

Folder-specific regression (example: `new-main-editor`):

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\.regression\.spec\.ts$" --retries=1
```

Specific test file:

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/my-test.smoke.spec.ts" --retries=1
```

Several specific test files:

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/first.smoke.spec.ts" "src/tests/new-main-editor/second.smoke.spec.ts" --retries=1
```

Rerun only previously failed tests:

```sh
pnpm --filter "e2e" test -- --last-failed --retries=1
```

Parallelism defaults to `workers: 1` in Playwright config for local stability. Increase workers when needed (for example, `--workers=2` or `--workers=50%`).

### Equivalent from e2e folder

If your shell is already in `node-packages/e2e`, use:

All smoke:

```sh
pnpm run test -- ".*\.smoke\.spec\.ts$" --retries=1
```

All regression:

```sh
pnpm run test -- ".*\.regression\.spec\.ts$" --retries=1
```

Folder-specific smoke (example: `new-main-editor`):

```sh
pnpm run test -- "src/tests/new-main-editor/.*\.smoke\.spec\.ts$" --retries=1
```

Folder-specific regression (example: `new-main-editor`):

```sh
pnpm run test -- "src/tests/new-main-editor/.*\.regression\.spec\.ts$" --retries=1
```

Specific test file:

```sh
pnpm run test -- "src/tests/new-main-editor/my-test.smoke.spec.ts" --retries=1
```

Several specific test files:

```sh
pnpm run test -- "src/tests/new-main-editor/first.smoke.spec.ts" "src/tests/new-main-editor/second.smoke.spec.ts" --retries=1
```

Rerun only previously failed tests:

```sh
pnpm run test -- --last-failed --retries=1
```

### VS Code Playwright plugin

This repo recommends `ms-playwright.playwright` (see `node-packages/e2e/.vscode/extensions.json`).

Using the Testing panel:

1. Folder-specific smoke
   - Expand `e2e > src > tests > new-main-editor`
   - Run the `*.smoke.spec.ts` tests from that folder (Run or Debug)

2. All smoke
   - Use Testing panel filter: `smoke.spec.ts`
   - Run all filtered tests

3. All regression
   - Use Testing panel filter: `regression.spec.ts`
   - Run all filtered tests

4. Folder-specific regression
   - Expand target folder (for example `new-main-editor`)
   - Run the `*.regression.spec.ts` tests (Run or Debug)

### Selection rules

- Smoke and regression are naming conventions on test files, not separate suites or folder trees.
- Current convention under `src/tests`:
  - Smoke: `*.smoke.spec.ts`
  - Regression: `*.regression.spec.ts`
- CI also uses `--grep` (`smoke`/`regression`) in `bitbucket-pipelines.yml`, which is why both selector styles are documented.

## Develop

### Structure

Create new tests in `src/tests/**/*.spec.ts`. The `spec` suffix reflects behavior/specification-driven test naming.

### Auth

Tests expect users `admin`, `author`, `contributor`, and `reviewer` to exist and share one password. If your local password differs, set `TEST_USER_PASSWORD`:

```sh
TEST_USER_PASSWORD=MyCustomPassword pnpm --filter "e2e" test
```

Since most flows require authentication, a custom fixture uses persistent sessions (one per user type). You typically sign in once per day per user type.

```ts
import { expect, test } from '../lib/auth.fixture';

test('author and reviewer can sign in', async ({ author, reviewer }) => {});

test('admin can sign in and see the welcome text on the start page', async ({ admin }) => {
  await admin.page.goto('/');
  await expect(admin.page.getByText('welcome')).toBeVisible();
});
```

### Writing tests

- **Use web-first assertions.** Playwright automatically waits for the condition to be met, so prefer `toBeVisible()` over manually checking `isVisible()`:

  ```ts
  // ✅ Playwright retries until visible or timeout
  await expect(page.getByRole('button', { name: 'Save' })).toBeVisible();

  // ❌ Does not retry — returns immediately
  expect(await page.getByRole('button', { name: 'Save' }).isVisible()).toBe(true);
  ```

- **Keep tests isolated.** Each test should run independently with its own state. Avoid sharing mutable data between tests.

- **Test user-visible behaviour.** Assert things the end user actually sees — visible text, roles, labels — rather than DOM structure or CSS classes.

- **Use soft assertions** when you want to check multiple conditions without stopping on the first failure:

  ```ts
  await expect.soft(page.getByTestId('status')).toHaveText('Published');
  await expect.soft(page.getByRole('button', { name: 'Edit' })).toBeEnabled();
  ```

### Selecting elements

Prefer locators in this order, from most to least resilient:

1. `getByRole` — tests both semantics and accessibility
2. `getByLabel` — good for form inputs
3. `getByText` — for visible text content
4. `getByTestId` — use `data-testid` when no semantic locator fits
5. CSS/XPath — last resort; brittle against DOM changes

```ts
// ✅ Semantic and stable
page.getByRole('button', { name: 'Submit' });
page.getByLabel('Email address');

// ❌ Fragile — breaks if classes change
page.locator('button.btn-primary.submit-action');
```

When a locator matches multiple elements, narrow it with [chaining or filtering](https://playwright.dev/docs/locators#matching-inside-a-locator):

```ts
page.getByRole('listitem').filter({ hasText: 'My Document' }).getByRole('button', { name: 'Delete' });
```

Improving accessibility (ARIA roles, labels) often fixes both selector stability and test readability at the same time. Tip: use the [Chrome DevTools accessibility tree](https://developer.chrome.com/blog/full-accessibility-tree) to inspect roles and labels.

### Generating locators

Use the built-in codegen recorder to pick stable locators without guessing:

```sh
pnpm --filter "e2e" record
```

This opens a browser window and the Playwright Inspector. Click "Pick Locator", hover over any element and Playwright suggests the best locator for it. Copy it directly into your test.

## Debugging

### Local debugging

The [VS Code Playwright extension](https://marketplace.visualstudio.com/items?itemName=ms-playwright.playwright) (`ms-playwright.playwright`) is the recommended way to debug locally. Right-click the line next to a test and choose **Debug Test** to open a browser with a breakpoint set.

You can also run any test with the Playwright Inspector using the `debug` script:

```sh
pnpm --filter "e2e" debug
```

Or target a specific file and line:

```sh
pnpm --filter "e2e" test -- example.spec.ts:25 --debug
```

The Inspector lets you step through actions, inspect locators live, and view the actionability log.

### Debugging on CI

Use the Playwright [trace viewer](https://playwright.dev/docs/trace-viewer) for CI failures — it gives a full timeline with DOM snapshots, network requests, and console logs for each action.

Traces are generated automatically on the first retry of a failed test. To collect traces locally for any run:

```sh
pnpm --filter "e2e" test -- --trace on
```

Open the resulting trace directly from the HTML report, or view it with:

```sh
pnpm --filter "e2e" show-trace test-results/tests-something-chromium/trace.zip
```

Or drag-and-drop the `.zip` into https://trace.playwright.dev/.

## Failing tests

Tests can fail for many environment/content reasons. Common causes and fixes are below.

### Test report

After running tests, an HTML report is generated.

![Overview of HTML test report](./report-overview.png)

Click a test for screenshots, trace links, and failure details.

![Overview of HTML test report](./report-clicked.png)

If a test fails locally but passes in CI, try:

- Run against CI-like settings: `CI=true pnpm --filter "e2e" dev` (targets staging, not your PR environment)
- Ensure MFA is disabled for test accounts
- Use fresh content/DB if local data interferes

### Trace file

Traces are attached to failed tests and visible in the HTML report. See [Debugging on CI](#debugging-on-ci) for instructions on opening them.

### Common errors

#### Expectations failing shortly after navigation

If dev servers are running, tests may fail before frontend assets finish loading:

![](./assets-not-loaded.png)

Stop dev servers, rebuild assets, rerun tests, then restart servers when done.

#### Timeouts

[Timeouts](https://playwright.dev/docs/test-timeouts) happen when elements do not appear in time or the machine is slow.

You can increase defaults via `TEST_TIMEOUT_MULTIPLIER`:

```sh
TEST_TIMEOUT_MULTIPLIER=1.5 pnpm --filter "e2e" test
```

#### Strict mode violation

If multiple elements match an action, Playwright fails with [strict mode violation](https://playwright.dev/docs/locators#matching-one-of-the-two-alternative-locators).

Possible fixes:

- Make content more accessible
- Use a more precise locator ([visible-only matching](https://playwright.dev/docs/locators#matching-only-visible-elements) can help)
- If either target is acceptable, use [`locator.or()`](https://playwright.dev/docs/api/class-locator#locator-or)
