---
copyright: 2025Paligo
subtitle: Test of Paligo output
title: WCAG 2.2 AA Test
---

<span id="section-idm23477654754059"></span>

# Introduction

DocBook is an XML-based markup language for technical documentation.
Below, we demonstrate its elements.

**Quick Overview**

DocBook supports structured documentation using semantic markup. It
allows authors to create books, articles, and manuals efficiently.

> "DocBook is an incredibly powerful tool for structured documentation."
>
> — John Doe

> [!IMPORTANT]
> DocBook is widely used for technical writing and software
> documentation.

Remark for the author.

<span id="UUID-6781592e-9870-06ac-fb12-8c0ee956db1b"></span>

# Inline Elements

Inline `code samples` are useful for documentation.

*Overline* is used for overlining.

Subscripts and superscripts are supported: H<sub>2</sub>O and
E=mc<sup>2</sup>.

File names should be written like this: `/etc/passwd`.

DocBook provides a variety of *inline elements* for formatting text:

~~Strikethrough emphasis~~ is used for mark what is removed.

<u>Underline emphasis</u> is used for underlining.

**Strong emphasis** is used for key points.

Guilabel is used for describing user interfaces.

Inline `literal` text is used for direct text representation.

A “quoted phrase” should be used when referring to external sources.

Replaceable text is indicated like this: \<username\>.

Hyperlinks can be added: [Official DocBook Site](http://docbook.org).

<span id="UUID-21468901-b869-67ac-1f03-418200d8031c"></span>

# Lists and Procedures

<div>

<div class="title">

Reuse-range to continue numbering

</div>

</div>

Ensure you have the necessary permissions to install packages and
execute commands.

1.  First of second list, fourth place in total

2.  Second of second list, fifth place in total

<div>

<div class="title">

Steps to Use DocBook

</div>

1.  Install a DocBook editor.

2.  Write content using XML.

3.  First in reused range, and third in total.

4.  Second in reused range, and fourth in total.

5.  Convert to HTML, PDF, or another format.

</div>

<div>

<div class="title">

Benefits of DocBook

</div>

- Structured and semantic markup

- Well-supported conversion to various formats

- Ideal for large technical documents

</div>

<span id="UUID-21468901-b869-67ac-1f03-418200d8031c_section-id22448234877166"></span>

## Procedures and Steps

<div id="UUID-21468901-b869-67ac-1f03-418200d8031c_itemizedlist-idm623477354114618">

<div class="title">

Checklist

</div>

- Checkbox 2

- Checkbox 3

- Checkbox 4

</div>

Checkbox 1

- Checkbox 1.1

- Checkbox 1.2

- Checkbox 1.3

1.  Install Required Packages

    Run the following command to install DocBook processing tools:

                        sudo apt-get install docbook docbook-xsl xsltproc fop
                        

    1.  Write a basic DocBook file and save it as `example.xml`.

    2.  Use the following command to generate a PDF:

                            xsltproc -o example.fo /usr/share/xml/docbook/stylesheet/nwalsh/fo/docbook.xsl example.xml
                            fop example.fo example.pdf
                            

2.  Check the generated file using a PDF viewer:

                        evince example.pdf
                        

    Stepalternatives 1

    Stepalternatives 2

    Stepalternatives 3

<span id="UUID-7a827101-7f48-e3d5-f70b-920abab7eff9"></span>

# hhhhh

| Normal Header, col=30% | Normal Header, col=70% |          |
|------------------------|------------------------|----------|
| Feature                | DocBook                | Markdown |
| foot 1                 | foot 1                 | foot 1   |
| Test 1                 | Value 1                |          |
| Complex Documentation  | ✔                      | ✖        |
| Easy to Learn          | ✖                      | ✔        |
| Test 3                 | Value 3                |          |
| Test 2                 | Value 2                |          |

DocBook vs Markdown

|     |
|-----|
|     |

| Rotated Header, col=30% | Rotated Header, col=70% |
|-------------------------|-------------------------|
| Test 1                  | Value 1                 |
| Test 2                  | Value 2                 |
| Test 3                  | Value 3                 |

|                         |                         |       |
|-------------------------|-------------------------|-------|
| Wheelbase               | inches/mm               | 34    |
| Dimension               | Unit                    | Value |
| Width without mirrors   | inches/mm               | 34    |
| Width with mirrors      | inches/mm               | 567   |
| Height                  | inches/mm               | 87    |
| Length                  | inches/mm               | 56    |
| Normal Header, col=auto | Normal Header, col=auto |       |

|  |  |
|----|----|
| Test 1 | Value 1 |
| Test 2 | Value 2 |
| Test 3: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur odio in nulla hendrerit rutrum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Phasellus sit amet metus tincidunt ante blandit tincidunt ut eget purus. Aliquam eget posuere ante, eu lobortis justo. Quisque facilisis pulvinar augue ut iaculis. Etiam malesuada risus orci, id facilisis mi laoreet volutpat. Duis vitae lorem a lectus placerat placerat a ac turpis. Aenean purus dui, molestie ut urna at, dictum luctus leo. | Value 3 |

| Rotated Header, col=auto | Rotated Header, col=auto |
|----|----|
| Test 1 | Value 1 |
| Test 2 | Value 2 |
| Test 3: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur odio in nulla hendrerit rutrum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Phasellus sit amet metus tincidunt ante blandit tincidunt ut eget purus. Aliquam eget posuere ante, eu lobortis justo. Quisque facilisis pulvinar augue ut iaculis. Etiam malesuada risus orci, id facilisis mi laoreet volutpat. Duis vitae lorem a lectus placerat placerat a ac turpis. Aenean purus dui, molestie ut urna at, dictum luctus leo. | Value 3 |

> [!NOTE]
> Comparing the last case (rotated+auto) with the second case
> (normal+auto) reveals that the automatic column width distribution is
> different: the rotated boxes in the header cell are accounted for in
> the colwidth calculations.

<span id="UUID-7a827101-7f48-e3d5-f70b-920abab7eff9_UUID-22e997fa-036e-f41d-87f1-ff7df38599e7"></span>

## Complex Tables in DocBook (portal-category)

Complex tables can include multi-column headers, row spans, and even
nested tables.

<table>
<caption>Sample Table</caption>
<thead>
<tr>
<th><p>a4</p></th>
<th><p>a3</p></th>
<th><p>a5</p></th>
<th colspan="2" style="text-align: center;"><p>Horizontal Span</p></th>
</tr>
</thead>
<tbody>
<tr>
<td><p>f1</p></td>
<td><p>f2</p></td>
<td><p>f3</p></td>
<td><p>f4</p></td>
<td><p>f5</p></td>
</tr>
<tr>
<td><p>b1</p></td>
<td><p>b2</p></td>
<td><p>b3</p></td>
<td><p>b4</p></td>
<td rowspan="2"><p>Vertical Span</p></td>
</tr>
<tr>
<td><p>c1</p></td>
<td colspan="2" rowspan="2" style="text-align: center;"><p>Span
Both</p></td>
<td><p>c4</p></td>
</tr>
<tr>
<td><p>d1</p></td>
<td><p>d4</p></td>
<td><p>d5</p></td>
</tr>
</tbody>
</table>

<table>
<caption>Employee Work Schedule</caption>
<thead>
<tr>
<th colspan="4"><p><strong>Weekly Employee Schedule</strong> </p></th>
</tr>
<tr>
<th><p><strong>Name</strong> </p></th>
<th><p><strong>Monday</strong> </p></th>
<th><p><strong>Tuesday</strong> </p></th>
<th><p><strong>Notes</strong> </p></th>
</tr>
</thead>
<tbody>
<tr>
<td colspan="4"><p>Schedule is subject to change.</p></td>
</tr>
<tr>
<td rowspan="2"><p>Alice</p></td>
<td><p>9 AM - 5 PM</p></td>
<td><p>Off</p></td>
<td rowspan="2"><p>Remote Work on Fridays</p></td>
</tr>
<tr>
<td><p>10 AM - 4 PM</p></td>
<td><p>9 AM - 3 PM</p></td>
</tr>
<tr>
<td><p>Bob</p></td>
<td colspan="2" style="text-align: center;"><p>10 AM - 6 PM</p></td>
<td><p>On-call Support</p></td>
</tr>
</tbody>
</table>

**Nested Table Example**

**Extra-responsive Table**

Below is an example of a nested table within another table.

| ID  | Name           | Department         | Role                         |
|-----|----------------|--------------------|------------------------------|
| 001 | Alice Johnson  | Engineering        | Software Engineer            |
| 002 | Bob Smith      | Engineering        | DevOps Engineer              |
| 003 | Charlie Davis  | Engineering        | Backend Developer            |
| 004 | Diana Lee      | Marketing          | SEO Specialist               |
| 005 | Edward Brown   | Marketing          | Content Strategist           |
| 006 | Fiona Wilson   | Marketing          | Social Media Manager         |
| 007 | George White   | Sales              | Account Manager              |
| 008 | Hannah Adams   | Sales              | Sales Executive              |
| 009 | Ian Thompson   | Sales              | Business Development Manager |
| 010 | Julia Martinez | Human Resources    | HR Manager                   |
| 011 | Kevin Harris   | Human Resources    | Recruiter                    |
| 012 | Linda Scott    | Finance            | Accountant                   |
| 013 | Michael Young  | Finance            | Financial Analyst            |
| 014 | Nancy King     | Legal              | Legal Advisor                |
| 015 | Oliver Baker   | Customer Support   | Support Specialist           |
| 016 | Paula Evans    | Customer Support   | Customer Success Manager     |
| 017 | Quincy Perez   | IT                 | System Administrator         |
| 018 | Rachel Carter  | IT                 | Network Engineer             |
| 019 | Steven Ramirez | Product Management | Product Manager              |
| 020 | Tina Robinson  | Product Management | UX Designer                  |

Company Employee Directory

<table>
<caption>Project Progress Report</caption>
<thead>
<tr>
<th><p>Project</p></th>
<th><p>Status</p></th>
<th><p>Details</p></th>
</tr>
</thead>
<tbody>
<tr>
<td><p>Alpha</p></td>
<td><p>In Progress</p></td>
<td><table>
<caption>Milestones</caption>
<thead>
<tr>
<th><p>Milestone</p></th>
<th><p>Completion</p></th>
</tr>
</thead>
<tbody>
<tr>
<td><p>Design</p></td>
<td><p>80%</p></td>
</tr>
<tr>
<td><p>Development</p></td>
<td><p>50%</p></td>
</tr>
</tbody>
</table></td>
</tr>
<tr>
<td><p>Beta</p></td>
<td><p>Completed</p></td>
<td><p>Final testing phase.</p></td>
</tr>
</tbody>
</table>

<span id="UUID-88cd76dc-c58b-ec5f-263e-bbfaeb239353"></span>

# Code

<div id="UUID-88cd76dc-c58b-ec5f-263e-bbfaeb239353_example-idm234775143348783"
class="example">

<div class="title">

Programlisting

</div>

``` python
            def hello_world():
                print("Hello, World!")

            hello_world()
```

![Example screenshot of a DocBook
document.](image/img-2ea36c5ba705bc3f77629ffbba0e59b6.png)

</div>

## Example of using font-size role in Program Listings

The programlisting element is used to include preformatted code in
DocBook. Below is an example of a simple Python script:

``` python
# Simple Python Program: Factorial Calculation def factorial(n): if n == 0: return 1 else: return n * factorial(n-1) # Example usage num = 5 print(f"Factorial of {num} is {factorial(num)}")
```

<span id="UUID-88cd76dc-c58b-ec5f-263e-bbfaeb239353_section-idm234775164632526"></span>

## Example handling Long Code Lines of using wrap-option role in Program Listings

Long lines in code can sometimes be problematic for readability. Below
is an example of a long code line inside a programlisting element.

``` python
# Example of a very long single-line Python statement query = "SELECT id, name, email, phone, address, city, state, country, zip_code FROM customers WHERE status = 'active' AND last_login >= '2024-01-01' ORDER BY last_login DESC LIMIT 100;"
```

<span id="UUID-88cd76dc-c58b-ec5f-263e-bbfaeb239353_UUID-f65cd8c1-81ed-4ec8-77b0-61fa32416941"></span>

## Swagger topic

<a href="https://petstore.swagger.io/v2/swagger.json"
class="swagger-ui">https://petstore.swagger.io/v2/swagger.json</a> 

Embedding Swagger

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7"></span>

# Accordions

<div id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_sidebar-idm23465235614683"
class="sidebar">

<div class="title">

Sidebar

</div>

Text inside sidebar

</div>

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_UUID-8e6706c5-d26e-19f1-86a1-9d0d8fb07ef5"></span>

## Linked Accordions

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_section-idp46912428488880342757946764"></span>

### Accordion 1

This is some test

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_section-idp4691242909520034275795700484"></span>

### Accordion 2

Som more text

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_UUID-7bea2b3c-c323-fcb4-9955-38043ec657bb"></span>

### Second level accordions

More text

<span id="UUID-26783de9-2d40-e111-b26d-cd7731417ef7_section-idp4691242847048034275825407929"></span>

#### Third level accordions

text

<span id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f"></span>

# Bridgeheads in Different Styles

**Major Topic**

This is a primary bridgehead that introduces a major section.

**Subsection Topic**

This is a secondary bridgehead introducing a subsection.

**Detailed Explanation**

This is a tertiary bridgehead providing additional detail.

**Minor Detail**

This is a quaternary bridgehead, offering a fine-grained detail within a
subsection.

<span id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f_UUID-5955ea24-09d0-e990-1d99-45e60cb9bedf"></span>

## Sidebars (notinsearch)

<div id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f_sidebar-idm234775282441868"
class="sidebar">

<div class="title">

This sidebar spans all columns using the role attribute value pagewide

</div>

Some text

</div>

<div id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f_sidebar-idm234774850830058"
class="sidebar">

<div class="title">

Using column-count and column-gap role in Sidebars

</div>

Sidebars in DocBook allow authors to highlight important information,
tips, or related content outside the main text flow.

**What is a Sidebar?**

A sidebar is a content box that provides supplementary information
related to the main content.

It is commonly used for:

- Additional explanations or context

- Tips and best practices

- Historical or background information

- Related links or references

Below is an example of a sidebar providing a practical tip:

> [!NOTE]
> When writing structured documentation, consider breaking content into
> logical sections.
>
> Use elements like
>
> **sidebars** 
>
> to highlight key details without interrupting the main flow.

Sidebars are especially useful in technical documentation, tutorials,
and user guides where additional context improves readability.

</div>

<div id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f_sidebar-idm234775293289558"
class="sidebar">

<div class="title">

Floating sidebar

</div>

This sidebar floats to the right of an image.

</div>

<div id="UUID-2b020bc6-acc1-18de-bdcc-858b592f490f_sidebar-idm234775284021898"
class="sidebar">

<div class="title">

This sidebar spans all columns using the role attribute value pgwide

</div>

Some more text

</div>

<img src="image/img-fe082d1e99f191fd2cf8680a3aa9aae5.png"
style="width:30.0%" />

<span id="UUID-5d3cbc55-892a-949d-6455-69eb0d1c497c"></span>

# Admonitions

> [!WARNING]
> This is a *danger*.

> [!WARNING]
> This is a *warning*. Warnings alert users about potential risks.

> [!NOTE]
> This is a *note*. Notes are used for additional information.

> [!NOTE]
> This is a *notice*.

DocBook includes several types of admonitions to highlight important
content.

> [!IMPORTANT]
> This is an *important* notice. **Pay special attention to this.**

**Understanding Admonitions**

> [!TIP]
> This is a *tip*. Tips provide helpful suggestions.

> [!CAUTION]
> This is a *caution*. Be careful when following these instructions.

<span id="UUID-f4d8e2bf-b8bf-6e3d-2528-622c24fba89a"></span>

# Mathematical Equations

Mathematical equations are essential in scientific and technical
documentation. Below is an example of an inline equation:

``` math
E = mc^2
```

<div class="informalequation">

</div>

We can also format block-level equations for better readability:

The quadratic equation formula is used to find the roots of a quadratic
polynomial:

<span id="UUID-f4d8e2bf-b8bf-6e3d-2528-622c24fba89a_section-idm234762668266861"></span>

## TeX equations in `mathphrase`

``` math
x<superscript>n</superscript> + y<superscript>n</superscript>≠ z<superscript>n</superscript>∀ n ≠ 2xn + yn≠ zn∀ n ≠ 2xn + yn≠ zn∀ n ≠ 2xn + yn≠ zn∀ n ≠ 2
```
``` math
\( _{r} \)
```

``` math
x<superscript>n</superscript> + y<superscript>n</superscript>≠ z<superscript>n</superscript>∀ n ≠ 2xn + yn≠ zn∀ n ≠ 2
```
``` math
\( _ {r} \)
```
``` math
\( _{r} \)\( _{r} \)
```

``` math
\( \frac{\Delta p}{p} \approx - \sum\limits_{i=1}^{11}krd_{i} \cdot \Delta kr_{i}+ \frac{1}{2} \sum\limits_{i=1}^{4}krbc_{i} \cdot \biggl ( \biggl ( \underbrace{ \Delta kr _{i}^{2}- \sigma _{imp,i}^{2} }_{\textstyle Unexpected} \biggr ) \underbrace{ + \sigma _{imp,i}^{2} }_{\textstyle Expected} \biggr )\ \)
```
``` math
\( \left. \underbrace{ \left[ \begin{matrix} a_{11} & a_{12} & a_{13} & \cdots & a_{1n} \\ a_{21} & a_{22} & a_{23} & \cdots & a_{2n} \\ a_{31} & a_{32} & a_{33} & \cdots & a_{3n} \\ \vdots & \vdots & \vdots & & \vdots \\ a_{m1} & a_{m2} & a_{m3} & \cdots & a_{mn} \end{matrix} \right] }_{\text{ n columns}} \right\} \text{m rows} \)
```

## MathML equations in `mml:math`

``` math
\left( {\underset{Unexpected}{\underbrace{\left( {\mathrm{\Delta}kr_{i}^{2} - \sigma_{imp,i}^{2}} \right)}}\underset{Expected}{\underbrace{+ \sigma_{imp,i}^{2}}}} \right)
```

``` math
\underset{Unexpected}{\underbrace{\left( {\mathrm{\Delta}kr_{i}^{2} - \sigma_{imp,i}^{2}} \right)}}\underset{Expected}{\underbrace{+ \sigma_{imp,i}^{2}}}
```

<span id="UUID-8ffb9aaf-c510-46b7-6320-0d6d23b61b65"></span>

# Using Images and Videos in DocBook

**Basic Image**

![](image/img-fe082d1e99f191fd2cf8680a3aa9aae5.png)

**Image with Caption and role img-thumbnail**

DocBook supports various ways to include images and videos for
documentation.

**Multiple Formats for Images**

The simplest way to include an image:

<figure>
<img src="image/img-30c45cdd754b4f1ffb8cb4a95c73ed6a.jpg" />
<figcaption>Screenshot of Application UI</figcaption>
</figure>

<figure>
<table>
<tbody>
<tr>
<td><p><img src="image/img-c9de78982f0a741a5a9f388d186dcc71.png" /></p>
<p><img src="image/img-6408a3808ae76063895abe8c21db93d0.png" /></p></td>
<td></td>
</tr>
</tbody>
</table>
</figure>

Side by side images

![](image/img-c9de78982f0a741a5a9f388d186dcc71.png)

**Linked Image**

Clicking on the image opens a larger version:

![](image/img-db9580f124a6927383079b01c255d612.jpg)

**Externally Linked Video**

Inline image ![](image/img-db9580f124a6927383079b01c255d612.jpg) 

Linking to a video hosted online:

![Video about creating topics and publications]()

Click to view full-size image.

![](image/img-6408a3808ae76063895abe8c21db93d0.png)

Flowchart diagram showing the process.

An example image demonstrating a feature.

<span id="UUID-d59982e6-9411-f1bb-99c5-eda501895b65"></span>

# References and Notes

For more details, refer to [Useful
Links](#UUID-0e61b8c0-4d0d-0f82-6a84-75a0c40e85dd).

Link to topic hidden in ToC [Not in ToC
(rotate)](#UUID-e829518e-5812-a068-2d1b-0487fc7df5ed) 

Link to external content [Paligo Docs](https://docs.paligo.net) 

> [!NOTE]
> DocBook requires a toolchain for processing into readable formats.

# References

DocBook Guide2010

DocBook: The Definitive Guide

O'Reilly MediaNormanWalsh

<span id="UUID-0e61b8c0-4d0d-0f82-6a84-75a0c40e85dd"></span>

# Useful Links

Find more about DocBook at the [official DocBook
website](http://docbook.org).

<span id="UUID-edb203e3-13f6-98c9-c335-cb6a22f2875a"></span>

# Glossterms

A <a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcef382f84a"
class="linktype-component">topic</a> is a container for your content and
building blocks for your output. You create content inside a
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcef382f84a"
class="linktype-component">topic</a> by adding elements for paragraphs,
images, procedures, bullet lists, tables and more. You can add as many
block elements and inline elements as you need, but the maximum
permitted size for a topic is 1
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bce9bf0d128"
class="linktype-component">MB</a>.

Baseform: Instead of writing all sections in one large file, you write
each section in a separate topic. For best practice, each topic should
focus on one subject or task.

Linked: Instead of writing all
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcedaadb21f"
class="linktype-component">sections</a> in one large file, you write
each <a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcedaadb21f"
class="linktype-component">section</a> in a separate
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcef382f84a"
class="linktype-component">topic</a>. For best practice, each
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65bcef382f84a"
class="linktype-component">topic</a> should focus on one subject or
task.

A <a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65cb1f4d25095"
class="linktype-component">glossterm</a> referred from the content
should be included in the glossary (i.e
<a href="#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c3285c52671"
class="linktype-component">Term referred from content</a>).

<span id="UUID-88a52e09-040c-02cb-ff04-4838219a05a0"></span>

# TopNav 1

Topic hidden from ToC, but accessible from topNav.

<span id="UUID-56dea3f2-1f70-7a56-6594-a5b903e361ac"></span>

## TopNav 1 sub 1 (chunk)

Topic hidden from ToC, but accessible from topNav.

<span id="UUID-864ece41-1c2e-17fb-f3a8-a409a2d045dc"></span>

### TopNav 1 sub 2

Topic hidden from ToC, but accessible from topNav.

<span id="UUID-e829518e-5812-a068-2d1b-0487fc7df5ed"></span>

# Not in ToC (rotate)

Topic hidden from ToC, only accessible from link.

<span id="UUID-b631a709-9fbc-c0f7-076a-47bba41b010f"></span>

# Glossary

Knowledge base

# Glossary role auto to filter the glossterms

The following terms are used in this publication:

Term referred from content  
This term is referred from the content and **SHOULD BE INCLUDED!**

See also .

Term referred from TRFC  

Term referred from TRF-TRFC  
This term is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c328a515174)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c3285c52671)
which is referred from the content ([info_title](#)) and **SHOULD BE
INCLUDED!**

See also .

Term referred from TRF-TRF-TRFC  
This term is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c328d5c5831)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c328a515174)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c3285c52671)
which is referred from the content ([info_title](#)) and **SHOULD BE
INCLUDED!**

Term **NOT** referred from content  
This term is **NOT** referred from the content and *SHOULD **NOT** BE
INCLUDED!*

See also .

Term referred from TNRFC  

Term referred from TRF-TNRFC  
This term is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c32e6892a9f)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c32df6b7f3f)
which is **NOT** referred from the content and *SHOULD **NOT** BE
INCLUDED!*

See also .

Term referred from TRF-TRF-TNRFC  
This term is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c32ffce4835)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c32e6892a9f)
which is referred from
[glossentry_title](#UUID-b631a709-9fbc-c0f7-076a-47bba41b010f_N65c32df6b7f3f)
which is **NOT** referred from the content and *SHOULD **NOT** BE
INCLUDED!*

<!-- -->

Loop refers second  
See also .

Loop refers third  
See also .

Loop refers first  
See also .

<!-- -->

A  
See also .

B  
See also .

C  

<!-- -->

Megabyte  
The megabyte is a multiple of the unit byte for digital information. Its
recommended unit symbol is MB. The unit prefix mega is a multiplier
of 1000000 (10<sup>6</sup>) in the International System of
Units(SI). Therefore, one megabyte is one million bytes of information.
This definition has been incorporated into the International System of
Quantities.

Section  
Section is one of the top-level sectioning elements in a component.
There are three types of sectioning elements in DocBook.

Topic  
A topic is a container for your content and building blocks for your
output.

Portable Document Format  
Portable Document Format (PDF), standardized as ISO 32000, is a file
format developed by Adobe in 1992 to present documents, including text
formatting and images, in a manner independent of application
software, hardware, and operating systems.

HyperText Markup Language  
The HyperText Markup Language or HTML is the standard markup
language for documents designed to be displayed in a web browser. It
defines the content and structure of web content. It is often assisted
by technologies such as Cascading Style Sheets (CSS) and scripting
languages such as JavaScript.

See also .

Extensible Markup Language  
Extensible Markup Language (XML) is a markup language and file
format for storing, transmitting, and reconstructing arbitrary data. It
defines a set of rules for encoding documents in a format that is
both human-readable and machine-readable.

HTML5  

World Wide Web Consortium  
The World Wide Web Consortium (W3C) is the main international standards
organization for the World Wide Web. Founded in 1994 and led by Tim
Berners-Lee, the consortium is made up of member organizations that
maintain full-time staff working together in the development of
standards for the World Wide Web.
