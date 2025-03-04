# Hotel Management System

## Project Description
The **Hotel Management System** is a desktop-based application developed using **Java Swing** and **AWT** with **MySQL** as the backend database. This project is designed to efficiently manage hotel operations and automate tasks such as customer management, employee management, driver management, and room status tracking.

## Features
- **Add Customer:** Admin can add customer details such as name, contact, room number, and check-in/check-out dates.
- **Add Employee:** Admin can register employee details like name, job position, salary, and contact information.
- **Add Driver:** Admin can add driver information including name, vehicle number, and availability status.
- **View All Lists:** Admin can view the list of all customers, employees, and drivers.
- **Room Status Management:** Admin can view and update the status of hotel rooms (available/occupied).
- **User-Friendly Interface:** Simple and interactive GUI designed using Java Swing and AWT.

## Technologies Used
- **Java Swing & AWT** (Graphical User Interface)
- **MySQL** (Database Management System)
- **JDBC** (Java Database Connectivity)

## Installation Steps
1. Install **Java JDK 8 or later**.
2. Install **MySQL Server**.
3. Clone this repository using:
   ```bash
   git clone https://github.com/surajaghav1/Hotel-Management-System.git
   ```
4. Import the database from the **hotel.sql** file.
5. Configure the database connection in the project by updating the JDBC URL, username, and password.
6. Compile and run the project:
   ```bash
   javac Dashboard.java
   java Dashboard
   ```

## Database Configuration
Update the following credentials in the database connection class:
```java
String url = "jdbc:mysql://localhost:3306/hotel_management";
String username = "root";
String password = "your_password";
```

## Screenshots
(Add screenshots of your application here)

## Future Improvements
- Add User Authentication for Admin Login.
- Generate Reports for Customer Bookings.
- Improve GUI with Modern Design Libraries.

## Contributing
Feel free to contribute to this project by submitting pull requests. For major changes, please open an issue first to discuss what you would like to change.

## Contact
For any queries, please contact:
- GitHub: https://github.com/surajaghav1



