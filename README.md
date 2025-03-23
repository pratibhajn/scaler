Eshop

It's a one-stop solution to purchase products and initiate payments
Prodcut invenetory is also managed by adding,deleting or updating products.

Features
Add, update, and delete products
Retrieve product details
Manage product categories
User authentication for auth token
Initiate payments

Requirements
Java (version 17)
Mysql
Maven

Installation

Clone the repository:

git clone git@github.com:pratibhajn/scaler.git
cd productservice
Install the dependencies:

mvn clean install

Configuration

Update the application.properties file with your configuration details, including the database username and password:

spring.datasource.url=jdbc:<your db url> eg: mysql://localhost:3306/testdb
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

Running the Service

1. Start the Mysql service if it's not already running:

net start mysql
Start the Product Service from main method

2. The service will be available at http://localhost:8080.

Product Service Endpoints

Once the service is running, you can use the following endpoints to interact with the product service:

GET /products - Retrieve a list of products
GET /products/:id - Retrieve details of a specific product
POST /products - Create a new product
PUT /products/:id - Update an existing product
DELETE /products/:id - Delete a product
For other controller information like auth controller and payments controller please check the respective classes.



