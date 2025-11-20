<span id="UUID-22e997fa-036e-f41d-87f1-ff7df38599e7"></span>

# Complex Tables in DocBook (portal-category)

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
