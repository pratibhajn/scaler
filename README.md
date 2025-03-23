Eshop

It's a one-stop solution to purchase products and initiate payments
Prodcut invenetory is also managed by adding,deleting or updating products.

Features

Add, update, and delete products
Retrieve product details
Manage product categories
User authentication for auth token
Manage roles
Initiate payments

Requirements
Java (version 17)
Mysql
Maven

Installation

Clone the repository:
git clone git@github.com:pratibhajn/scaler.git

In each of the 3 directories:
Install the dependencies:
mvn clean install

Start the Mysql service if it's not already running:
net start mysql

REST Endpoints:

1.	Product service API’s:

•	GET <ip>/products: To get the list of all the products
•	GET <ip>/products/{id}: To get the product with given ID
•	POST <ip> with body having the Product JSON: To create a product with given details
•	PUT <ip>/products/{id} with body having the Product JSON: To update the product with given ID
•	DELETE <ip>/products/{id}: To delete the product with given ID
•	POST <ip>/search with body having the search request: To search product based on conditions
•	GET <ip>/categories/{id}: To get the list of product details in the given category 
•	POST <ip>/categories/titles with body having List of UUIDs: To fetch titles of products in the given category and having the given UUID’s

2.	Payment Service API’s:
•	POST <ip>/payments with body have Initiate Payment JSON: To initiate payment

3.	User Service API’s:

•	POST <ip>/auth/login with body having login request: To login
•	POST <ip>/auth/logout with body having logout request: To logout
•	POST <ip>/auth/signup with body having signup request: To signup
•	POST <ip>/auth/validate with body having validate token request: To validate token
•	POST <ip>/roles with body having create role request: To create a role
•	GET <ip>users/id: To get details of the user with given ID
•	POST <ip>/users/{id}/roles with set user roles request: To set roles for the user with given ID. 

Configuration:

1. Product Service configuration
Update the application.properties file of productservice-authtest with your configuration details, including the database username and password:

spring.datasource.url=jdbc:<your db url> eg: mysql://localhost:3306/testdb
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

Running the Product Service
Start the Product Service from main method
The service will be available at http://localhost:8080.


2. User Service configuration
Update application.properties file of userservice-master with your configuration details:

spring.datasource.url=jdbc:<your db url> eg: mysql://localhost:3306/testdb
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
server.port=<server_port>

Running the User Service
Start the User Service from main method
The service will be available at http://localhost:8080.

Similarly Role service and Auth service

3. Payment Service configuration
Update the application.properties file of paymentservicefinal-master with your configuration details, including the database username and password:

spring.datasource.url=jdbc:<your db url> eg: mysql://localhost:3306/testdb
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

Running the Payment Service
Start the Payment Service from main method
The service will be available at http://localhost:8080.



