# Online Shopping Cart E-Commerce Website
- Youtube video for step by step local setup of similar project: https://www.youtube.com/watch?v=mLFPodZO8Iw&t=8s
<!-- Live site url: https://ellisonelectronics.herokuapp.com -->
- Note: [Register as customer before login, for admin login use : username: Admin and password: Admin] <br><br>
This is an ecommerse website build for selling of any products online.
In this project we have mainly considered to adding the products to the users cart and again let them decide the amount of item to buy.
The users can increase or decrease the items amount in the cart. 
After that the user may pay and get the order successful.
The Project also uses the mail facilities to the users.
### The users will get a mail to their registered mail Id during:-
- New User Registration
- Order Successfully Placed
- The Item was not available but now it got available in the store
- Successful Delivery of Item

### The Technologies Used in this Project are:-
- HTML
- CSS
- Javascript
- Bootstrap
- Java
- JDBC
- JSP
- Servlets
- MySql

## database commands
```MySQL
create database shopping;
use shopping;

create table user(name varchar(20),mobile bigint(12),email varchar(40) primary key, address varchar(150),pincode integer(6),password varchar(20));

create table admin(username varchar(30) primary key, password varchar(30));

create table product(pid varchar(16) primary key,pname varchar(20),ptype varchar(20),pinfo varchar(150),pprice decimal(12,2),pquantity int(10),image blob);

create table usercart(username varchar(40), prodid varchar(16),quantity int(4));

create table admin(company varchar(30), email varchar(30), username varchar(30), password varchar(30));

alter table usercart add foreign key (prodid) references product(pid) on delete cascade;

alter table usercart add foreign key (username) references user(email) on delete cascade;

create table transactions(transid varchar(16) primary key,username varchar(40) references user(email) on delete cascade,time datetime, amount decimal(10,2));

create table orders(transid varchar(16) references transactions(transid) on delete cascade, prodid varchar(16) references product(pid) on delete cascade,quantity int(4), amount decimal(10,2), primary key(transid,prodid));

create table user_demand(username varchar(40) references user(email) on delete cascade, prodid varchar(16) references product(pid) on delete cascade, quantity int(4), primary key(username,prodid));

```

### IDE Used:-
- Eclipse Express Edition


