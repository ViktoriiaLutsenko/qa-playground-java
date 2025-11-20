<span id="UUID-7d4e9e23-4b63-46cf-3ee5-84c1b30e7c09"></span>

# Code

<div id="example-idm234775143348783" class="example">

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

<span id="section-idm234775164632526"></span>

## Example handling Long Code Lines of using wrap-option role in Program Listings

Long lines in code can sometimes be problematic for readability. Below
is an example of a long code line inside a programlisting element.

``` python
# Example of a very long single-line Python statement query = "SELECT id, name, email, phone, address, city, state, country, zip_code FROM customers WHERE status = 'active' AND last_login >= '2024-01-01' ORDER BY last_login DESC LIMIT 100;"
```

<span id="UUID-f65cd8c1-81ed-4ec8-77b0-61fa32416941"></span>

## Swagger topic

<a href="https://petstore.swagger.io/v2/swagger.json"
class="swagger-ui">https://petstore.swagger.io/v2/swagger.json</a> 

Embedding Swagger
