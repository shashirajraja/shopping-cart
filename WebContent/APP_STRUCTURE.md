# Application Overview

## JSP

### index.jsp
- **Landing Page** showcasing available products.
- Users can **add products to cart** or proceed to purchase.
- **Search functionality** to filter products.
- **Dynamic content** based on user's authentication and type (admin/customer).
  
### header.jsp
- **Common Header** for consistent branding and navigation.
- **Search Form** directing to `index.jsp`.
- **Dynamic Navigation** based on user's type (e.g., customer, admin).

### login.jsp
- **User Authentication** interface.
- Fields for username, password, and user type.
- **Error messages** for failed login attempts or other notifications.

### register.jsp
- **User Registration** interface.
- Form to collect user details including email, name, password, and contact.
- After registration, likely redirects to `login.jsp` or `userHome.jsp`.

### userHome.jsp
- **User Dashboard** after successful login.
- Displays user-specific information, order history, and other relevant actions.

### userProfile.jsp
- **User Profile View**.
- Showcases user details like email, name, and contact.
- Potential options to update or modify these details.

### adminHome.jsp
- **Dashboard** for administrators.
- Links to various **product management functionalities**:
  - View all products (`adminViewProduct.jsp`).
  - Add new products (`addProduct.jsp`).
  - Update or delete existing products using `updateProduct.jsp` or `removeProduct.jsp`.

### adminStock.jsp
- **Stock Management** interface for administrators.
- Displays products with options to **view or edit stock levels**.

### adminViewProduct.jsp
- **Detailed View** for admins to manage the inventory.
- Displays products in a table with options to **edit, delete, or view stock details**.

### cartDetails.jsp
- Displays products added to the **user's shopping cart**.
- Options to **modify quantities, remove items**, or proceed to checkout.

### orderDetails.jsp
- **Post-purchase View** of a specific order.
- Displays products, quantities, prices, and other **order-specific details**.

### payment.jsp
- Handles the **payment process** for cart products.
- Collects **payment details** and proceeds with the transaction.

### addProduct.jsp
- Allows administrators to **add new products** to the inventory.
- Collects product details and submits them for addition to the inventory.

### removeProduct.jsp
- **Product Removal** interface for administrators.
- Allows admins to remove products from the inventory based on product ID or other criteria.

### shippedItems.jsp
- **Shipped Orders View** for administrators or users.
- Lists out orders that have been marked as shipped.

### unshippedItems.jsp
- **Unshipped Orders View** for administrators or users.
- Showcases orders that haven't been shipped yet.

### updateProduct.jsp & updateProductById.jsp
- **Product Update** interfaces for administrators.
- Provides forms to modify details of existing products in the inventory, either in bulk or by specific product ID.

## Java Beans

### CartBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for a shopping cart item.
- **Attributes**:
  - `userId`: ID of the user who has added the item to their cart.
  - `prodId`: ID of the product added to the cart.
  - `quantity`: Number of units of the product in the cart.
- **Methods**: Getters and setters for each attribute and a constructor.

### DemandBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for product demand.
- **Attributes**:
  - `userName`: Name of the user showing interest in a product.
  - `prodId`: ID of the product for which demand is recorded.
  - `demandQty`: Quantity of the product in demand.
- **Methods**: Getters and setters for each attribute and a constructor.

### OrderBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for an order.
- **Attributes**:
  - `transactionId`: Unique ID for the transaction.
  - `productId`: ID of the product being ordered.
  - `quantity`: Quantity of the product ordered.
  - `amount`: Total amount for the ordered product.
  - `shipped`: Flag to indicate shipping status.
- **Methods**: Getters and setters for each attribute and two constructors.

### OrderDetails.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for detailed order information.
- **Attributes**:
  - `orderId`: Unique ID for the order.
  - `productId`: ID of the product in the order.
  - `prodName`: Product name.
  - `qty`: Product quantity in the order.
  - `amount`: Total amount for the product in the order.
  - `shipped`: Flag to indicate shipping status.
  - `time`: Timestamp for order placement.
  - `prodImage`: Image of the product.
- **Methods**: Getters and setters for each attribute.

### ProductBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for a product.
- **Attributes**:
  - `prodId`: Unique ID for the product.
  - `prodName`: Product name.
  - `prodType`: Product type or category.
  - `prodInfo`: Product description.
  - `prodPrice`: Product price.
  - `prodQuantity`: Stock quantity.
  - `prodImage`: Product image.
- **Methods**: Getters and setters for each attribute and a constructor.

### TransactionBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for a transaction.
- **Attributes**:
  - `transactionId`: Unique ID for the transaction.
  - `userName`: User name for the transaction.
  - `transDateTime`: Transaction timestamp.
  - `transAmount`: Total transaction amount.
- **Methods**: Getters and setters for each attribute and multiple constructors.

### UserBean.java
- **Package**: `com.shashi.beans`
- **Purpose**: Represents a Java Bean for a user.
- **Attributes**:
  - `name`: User name.
  - `mobile`: Mobile number.
  - `email`: Email ID.
  - `address`: Address.
  - `pinCode`: Postal or ZIP code.
  - `password`: Password.
- **Methods**: Getters and setters for each attribute and multiple constructors.

## Database
1. Table `product`:
   - Attributes:
     - `pid` (VARCHAR(45))
     - `pname` (VARCHAR(100))
     - `ptype` (VARCHAR(20))
     - `pinfo` (VARCHAR(350))
     - `pprice` (DECIMAL(12,2))
     - `pquantity` (INT)
     - `image` (LONGBLOB)
     - `brand` /////TODO//////
-PRIMARY KEY (`pid`)

2. Table `orders`:
   - Attributes:
     - `orderid` (VARCHAR(45))
     - `prodid` (VARCHAR(45))
     - `quantity` (INT)
     - `amount` (DECIMAL(10,2))
     - `shipped` (INT)
   - PRIMARY KEY (`orderid`, `prodid`)

3. Table `user`:
   - Attributes:
     - `email` (VARCHAR(60))
     - `name` (VARCHAR(30))
     - `mobile` (BIGINT)
     - `address` (VARCHAR(250))
     - `pincode` (INT)
     - `password` (VARCHAR(20))
   - PRIMARY KEY (`email`)

4. Table `transactions`:
   - Attributes:
     - `transid` (VARCHAR(45))
     - `username` (VARCHAR(60))
     - `time` (DATETIME)
     - `amount` (DECIMAL(10,2))
   - PRIMARY KEY (`transid`)

5. Table `user_demand`:
   - Attributes:
     - `username` (VARCHAR(60))
     - `prodid` (VARCHAR(45))
     - `quantity` (INT)
   - PRIMARY KEY (`username`, `prodid`)

6. Table `usercart`:
   - Attributes:
     - `username` (VARCHAR(60))
     - `prodid` (VARCHAR(45))
     - `quantity` (INT)