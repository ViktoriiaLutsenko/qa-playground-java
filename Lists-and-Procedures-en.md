<span id="UUID-20958887-cafd-f28c-7c6c-cd9a7d2dec88"></span>

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

<span id="section-id22448234877166"></span>

## Procedures and Steps

<div id="itemizedlist-idm623477354114618">

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
