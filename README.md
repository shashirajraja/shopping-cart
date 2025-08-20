# Online Shopping Cart (E-Commerce Website)
- Youtube Video for introduction, demo and setup for this Project: https://www.youtube.com/watch?v=RgQG0_orFpM
<!-- - YouTube video for step by step local setup of similar project: https://www.youtube.com/watch?v=mLFPodZO8Iw&t=8s -->
<!-- Live site url: https://ellisonelectronics.herokuapp.com -->
This is an E-Commerce Website build for selling of any electronics products online.

### About

In this projects a user can visit the websites, registers and login to the website. They can check all the products available for shopping, filter and search item based on different categories, and then add to cart. They can add multiple item to the cart and also plus or minus the quantity in the cart. Once the cart is updated, the user can proceed to checkout and click the credit card payment details to proceed. Once the payment is success the orders will be placed and users will be able to see the orders details in the orders section along with the shipping status of the product.

The admin also plays an important role for this project as the admin is the one responsible for adding any product to the store, updating the items, removing the item from the store as well as managing the inventory. The admin can see all the product orders placed and also can mark them as shipped or delivered based on the conditions.

One of the best functionality that the projects include is mailing the customers, so once a user registers to the website, they will recieve a mail for the successful registration to the website, and along with that whenever a user orders any product or the product got shipped from the store, then the user will also receive the email for its confirmation.
Sometimes, if the user tried to add any item which is out of stock, them they will get an email one the item is available again the stock.

Note: The payment page is created only for demo purpose and its not fully integrated with any payment gateway. So for now any credit card details will be accepted and the demo orders will be placed.

## Highlights :--

### The users will get a mail to their registered mail Id during:-
- New User Registration
- Order Successfully Placed
- The Item was out of stock while exploring but now it got available in the store
- Successful shipment and delivery of the Item

### Technologies used:-
1. Front-End Development:
- HTML
- CSS
- Javascript
- BootStrap

2. Back-End Development:
- Java [JDK 8+]
- JDBC
- Servlet
- JSP

3. Database:
- MySql

### ================ Software And Tools Required ================
- : Git [https://www.youtube.com/watch?v=gv7VPQ4LZ7g]
- : Java JDK 8+ [https://www.youtube.com/watch?v=O9PWH9SeTTE]
- : Eclipse EE (Enterprise Edition) [https://www.youtube.com/watch?v=8aDsEV7txXE]
- : Apache Maven [https://www.youtube.com/watch?v=jd2zx3dLjuw]
- : Tomcat v8.0+ [https://youtu.be/mLFPodZO8Iw?t=903]
- : MySQL Server [https://www.youtube.com/watch?v=Ydh5jYA6Frs]
- : MySQL Workbench [https://www.youtube.com/watch?v=t79oCeTXHwg]

### ================= Dummy Database Initialization =================
STEP 1: Open MySQL Command Prompt or MySQL Workbench

STEP 2: Login to the administrator user of MySql:
	 ```mysql -u <username> -p``` (Enter Password if asked)

STEP 3: Copy paste and execute the MySQL Query from the following file:-
- Run the Sql Query From this file: [databases/mysql_query.sql](./databases/mysql_query.sql)

### ======GENERATING GMAIL APP PASSWORD [For Mailing Functionalities]========
Step 1: Create a gmail account or login to existing account in any browser

Step 2 : Go to [https://myaccount.google.com/security](https://myaccount.google.com/security) and check if 2 step verifications is enabled or not, enable it if not enabled

Step 3: Go to [https://myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords) and enter password if asked

Step 4: In Select an App Section: select Other (custom name) => enter "Ellison Electronics" => Generate

Step 5: After that it will generate 16 digits app password which you need to copy and save for future configurations.

Step 6: Done : Now continue to importing the project. [Don't share the above password generated to anyone]

### ========== Importing and Running The Project Through Eclipse EE ==========

Step 1: Open Eclipse Enterprise Edition. [Install, if not already installed.]

Step 2: Click On File > Import > Git > Projects From Git > Clone Uri > Paste The Repository Url as: ```https://github.com/shashirajraja/shopping-cart.git```> Select master Branch > Next > Next > Finish.

Step 3: Go inside ```Java Resources > src > application.properties``` and update the values as below:
- a) Update value for db.username and db.password according to your installed mysql credentials.
- b) Update value for mailer.email and mailer.password, with the same email and app password that you generated earlier in above section [ NOTE:Actual gmail password will not work]

Step 4: Right Click on Project > Run as > Maven Build > In the goals field enter "clean install" > apply > run

Step 5: Right Click On Project > Build Path > Configure Build Path > Libraries > Remove and Update Any Libraries if Red Mark Exists > Finish.

Step 6: Right Click on Project > maven > update project > select force update > apply > close

Step 7: Tomcat Configurations:
- If Tomcat Server is not configured in Eclipse :
	-  Right Click On Project > Run As > Run On Server > Manually Define a new server > Select server type > select Tomcat v8.0+ > (Select Tomcat V8.0+ Installation Location If Asked) > Next > Add the current project > Finish.

- Else If Tomcat Server is already configured in Eclipse:
	- Right Click On Project > Run As > Run On Server > Select Tomcat Version > Next > Add the project > Finish.
		<p align='center'>or</p>
	- You can directly goto server tab, select the tomcat server and use the debug or run button to start the previously ran project

Step 8: Check Running The Site At  [http://localhost:8080/shopping-cart/](http://localhost:8080/shopping-cart/)

Step 9:  [To Change the Port, if getting error like 'port already in use'] Open The Server Tab > Double Click On Tomcat Server > Ports > Change The Port Number For Http/1.1 To 8083 > Close And Save. Now Start and you can access the project on [http://localhost:8083/shopping-cart/](http://localhost:8083/shopping-cart/)

Step 10: Default Username And Password For Admin Is "admin@gmail.com" And "admin"

Step 11: The default Username And Password For User Is "guest@gmail.com" And "guest"

## FAQ
**Question:1** Unable to Connect to Database?

**Answer:** Please check you have installed the mysql correctly and have updated the correct db details in application.properties file. Also you can try doing maven clean install and force update the project and restart.
<hr>

Note:- This is a Sample Project for learning purpose, we have not much considered of web security.

#### Some Screenshots for the project:
- Home Page
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/6161fb90-ac83-445d-9fb2-56681f6a52b4)
- Login Page
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/c5451416-a669-4d76-ad84-9b8ea26bf6b4)
- Register Page
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/19f06ec9-70aa-4700-8846-a2e6514d88c2)
- Category Wise Product Filter
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/757e552c-1526-4142-869b-ffbf27a232e0)
- Cart Items
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/12963112-1276-49ca-8b9c-f3272c6b9b7b)
- Credit Card Payment
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/990595ce-856c-46fe-8182-052a127d67b4)
- Order Details & Status
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/db8b4511-cac0-41df-930a-ef3bdebe5c24)
- User Profile
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/aa22b0cd-726b-4e5c-85cd-5409b7fc5391)

- Admin Home
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/0e909800-b9a2-4ece-884c-24cdc8ca931a)
- Stock Items
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/e94e519b-e65c-4f51-8b37-e1b555208f2d)
- Shipped Items
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/e34de1d9-91ae-4d3b-a38e-7d78aae1f410)
- Recent Orders yet to be shipped
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/ed2df621-3256-41bd-8739-d3872474403c)
- Add Product to the stock
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/3f38b7cf-c120-4523-abec-cdb2238c17b0)
- Remove Product from the stock
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/1e9c6565-6a14-4cb3-834e-8d7f5d273927)
- Update the stock item
![image](https://github.com/shashirajraja/shopping-cart/assets/34605595/1529a9a7-19a3-4381-ac58-29dbc55229d9)
- Sample Email for order placed
<img width="404" alt="image" src="https://github.com/shashirajraja/shopping-cart/assets/34605595/cb60c616-c32c-42eb-abe5-494d8574c09a">

- Class Diagram
<img width="589" alt="image" src="https://github.com/shashirajraja/shopping-cart/assets/34605595/d6dbfdb9-5108-4071-b4b6-d055f0370acd">

#### "Suggestions and project improvement ideas are welcomed!"

<bold>Thanks a lot,</bold><br/>
                                                                                                        Project Leader<br/>
                                                                                                         <b>Shashi Raj</b>


