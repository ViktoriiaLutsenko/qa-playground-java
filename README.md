# E2E tests

End-to-end tests use [Playwright](https://playwright.dev/docs/writing-tests).

- [E2E tests](#e2e-tests)
  - [Use](#use)
    - [Install](#install)
    - [Run from console (repo root)](#run-from-console-repo-root)
    - [Equivalent from e2e folder](#equivalent-from-e2e-folder)
    - [VS Code Playwright plugin](#vs-code-playwright-plugin)
    - [Selection rules](#selection-rules)
  - [Develop](#develop)
    - [Structure](#structure)
    - [Auth](#auth)
    - [Selecting items](#selecting-items)
  - [Failing tests](#failing-tests)
    - [Test report](#test-report)
    - [Trace file](#trace-file)
    - [Common errors](#common-errors)
      - [Expectations failing shortly after navigation](#expectations-failing-shortly-after-navigation)
      - [Timeouts](#timeouts)
      - [Strict mode violation](#strict-mode-violation)

## Use

### Install

From repo root:

```sh
pnpm install
```

### Run from console (repo root)

Use repo-root commands as the default style:

| Command | Description |
| --- | --- |
| `pnpm --filter "e2e" test` | Run all E2E tests |
| `pnpm --filter "e2e" test --help` | Show all Playwright CLI options |
| `pnpm --filter "e2e" dev` | Open Playwright UI mode |
| `pnpm --filter "e2e" debug` | Run in Playwright debug mode |
| `pnpm --filter "e2e" record` | Open codegen recorder |

Quick copy/paste:

Use these as the preferred selectors (filename regex). `--grep` alternatives are listed in the scenarios below.

```sh
# Folder-specific smoke (new-main-editor)
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\\.smoke\\.spec\\.ts$"

# All smoke
pnpm --filter "e2e" test -- ".*\\.smoke\\.spec\\.ts$"

# All regression
pnpm --filter "e2e" test -- ".*\\.regression\\.spec\\.ts$"

# Folder-specific regression (new-main-editor)
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\\.regression\\.spec\\.ts$"
```

Four common scenarios (filename regex first, then a `--grep` alternative):

1. Folder-specific smoke (example: `new-main-editor`)

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\\.smoke\\.spec\\.ts$"
pnpm --filter "e2e" test -- "src/tests/new-main-editor" --grep "smoke"
```

2. All smoke

```sh
pnpm --filter "e2e" test -- ".*\\.smoke\\.spec\\.ts$"
pnpm --filter "e2e" test -- --grep "smoke"
```

3. All regression

```sh
pnpm --filter "e2e" test -- ".*\\.regression\\.spec\\.ts$"
pnpm --filter "e2e" test -- --grep "regression"
```

4. Folder-specific regression (example: `new-main-editor`)

```sh
pnpm --filter "e2e" test -- "src/tests/new-main-editor/.*\\.regression\\.spec\\.ts$"
pnpm --filter "e2e" test -- "src/tests/new-main-editor" --grep "regression"
```

Parallelism defaults to `workers: 1` in Playwright config for local stability. Increase workers when needed (for example, `--workers=2` or `--workers=50%`).

### Equivalent from e2e folder

If your shell is already in `node-packages/e2e`, use:

- Folder-specific smoke
  - Regex: `pnpm run test -- "src/tests/new-main-editor/.*\\.smoke\\.spec\\.ts$"`
  - Grep: `pnpm run test -- "src/tests/new-main-editor" --grep "smoke"`
- All smoke
  - Regex: `pnpm run test -- ".*\\.smoke\\.spec\\.ts$"`
  - Grep: `pnpm run test -- --grep "smoke"`
- All regression
  - Regex: `pnpm run test -- ".*\\.regression\\.spec\\.ts$"`
  - Grep: `pnpm run test -- --grep "regression"`
- Folder-specific regression
  - Regex: `pnpm run test -- "src/tests/new-main-editor/.*\\.regression\\.spec\\.ts$"`
  - Grep: `pnpm run test -- "src/tests/new-main-editor" --grep "regression"`

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

### Selecting items

Playwright has many [locator strategies](https://playwright.dev/docs/locators). When selectors are hard to keep stable, improving accessibility often makes tests both cleaner and more resilient.

Tip: [Chrome DevTools accessibility tree](https://developer.chrome.com/blog/full-accessibility-tree).

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

On failures, Playwright stores a [trace](https://playwright.dev/docs/trace-viewer-intro) visible in the HTML report.

Console example:

```log
attachment #3: trace (application/zip) ─────────────────────────────────────────────────────────
    test-results/tests-something-chromium/trace.zip
    Usage:
        npx playwright show-trace test-results/tests-something-chromium/trace.zip
```

You can open traces with:

```sh
pnpm --filter "e2e" show-trace test-results/tests-something-chromium/trace.zip
```

Or drag-and-drop into https://trace.playwright.dev/.

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
