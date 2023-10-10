# Spring Boot E-Commerce Backend System
This is a Spring Boot application for managing a E-commerce system where seller can add their details, product and sell their product, and  customer can view, addto cart and buy the  the product. 
This project provides 10 APIs to perform various operations.




## Installation 

 - [Clone the repository to your local machine](https://github.com/your_username/library-management.git)
 - [Open a terminal and navigate to the project directory]()
 - [Run mvn clean install to build the project]()
 - [Run mvn spring-boot:run to start the application]()
 
## Requirements
Before you begin, ensure that you have met the following requirements:

 - [You have installed the latest version of Java]()
 - [You have installed the latest version of Maven]()
 - [You have installed the latest version of Spring Boot]()


## API Reference

#### This project provides the following APIs:

#### Post item

```http
  POST /api/addSeller
```
```http
  POST /api/addProduct
```

```http
  POST /api/addCustomer
```

```http
  POST /api/order/place
```
```http
  POST /api/cart/checkout
```
```http
  POST /api/cart/add
```


#### PUT item

```http
  PUT /api/updateEmail
```



#### Get item

```http
  GET /api/getSeller
```
```http
  GET /api/getByPanNo
```

```http
  GET /api/get/product
```

```http
  GET /api/item/view
```
## Contributing

Contributions are always welcome!


 - [Fork the repository]()
 - [Create a new branch (git checkout -b feature/feature-name)]()
 - [Make the changes]()
- [Commit your changes (git commit -am 'Add some feature')]()
 - [Push to the branch (git push origin feature/feature-name)]()
 - [Create a new Pull Request]()


## License

This project is licensed under the MIT License. See LICENSE for more information.
