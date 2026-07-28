# 💳 Digital Wallet Management System

A full-stack Java web application that enables users to securely manage a digital wallet. Users can register, log in, add money, transfer money to other registered users, manage their profile, and view transaction history.

The application is built using **Jakarta Servlets**, **JSP**, **JDBC**, and **MySQL**, following the **MVC (Model-View-Controller)** architecture.

---

## 🚀 Features

- User Registration
- Secure Login & Logout
- Session-Based Authentication
- Remember Me using Cookies
- Add Money to Wallet
- Transfer Money Between Users
- View Transaction History
- View & Update User Profile
- Input Validation
- Authentication Filter for Protected Routes
- Database Transactions for Secure Money Transfer
- Custom Error Handling

---

## 🛠️ Technology Stack

### Backend
- Java 21
- Jakarta Servlet 6.0
- JDBC
- Apache Tomcat 10

### Frontend
- JSP (JavaServer Pages)
- JSTL
- HTML5
- CSS3
- Bootstrap 5

### Database
- MySQL

### Build Tool
- Maven

---

# 🏗️ Project Architecture (MVC)

```
Browser
    │
    ▼
Authentication Filter
    │
    ▼
Servlet (Controller)
    │
    ▼
DAO Layer
    │
    ▼
MySQL Database
    │
    ▼
JSP Pages (View)
```

---

# 📁 Project Structure

```
DigitalWalletManagementSystem
│
├── src
│   └── main
│       ├── java
│       │   ├── controller
│       │   │   ├── AddMoneyServlet.java
│       │   │   ├── DashboardServlet.java
│       │   │   ├── LoginServlet.java
│       │   │   ├── LogoutServlet.java
│       │   │   ├── ProfileServlet.java
│       │   │   ├── RegisterServlet.java
│       │   │   ├── SendMoneyServlet.java
│       │   │   ├── TransactionServlet.java
│       │   │   └── UpdateProfileServlet.java
│       │   │
│       │   ├── dao
│       │   │   ├── DBConnection.java
│       │   │   ├── UserDAO.java
│       │   │   ├── WalletDAO.java
│       │   │   └── TransactionDAO.java
│       │   │
│       │   ├── model
│       │   │   ├── User.java
│       │   │   ├── Wallet.java
│       │   │   └── Transaction.java
│       │   │
│       │   ├── filter
│       │   │   └── AuthenticationFilter.java
│       │   │
│       │   ├── listener
│       │   │   └── AppContextListener.java
│       │   │
│       │   └── util
│       │       └── Validation.java
│       │
│       ├── resources
│       │
│       └── webapp
│           ├── WEB-INF
│           ├── index.jsp
│           ├── login.jsp
│           ├── register.jsp
│           ├── dashboard.jsp
│           ├── profile.jsp
│           ├── editProfile.jsp
│           ├── sendMoney.jsp
│           ├── transactions.jsp
│           ├── navbar.jsp
│           ├── footer.jsp
│           └── error.jsp
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# 🔄 Application Workflow

1. User registers a new account.
2. User logs into the application.
3. Authentication Filter verifies every protected request.
4. Dashboard displays wallet balance.
5. Users can:
   - Add money
   - Transfer money
   - View transaction history
   - Update profile
6. Money transfers are executed using database transactions to maintain consistency.
7. User logs out and the session is destroyed.

---

# 🗄️ Database

### Users Table

Stores:
- User Details
- Email
- Password
- Mobile Number
- Wallet Balance

### Transactions Table

Stores:
- Sender Email
- Receiver Email
- Amount
- Transaction Type
- Timestamp

---

# 🔐 Security Features

- Session-Based Authentication
- Remember Me Cookies
- Authentication Filter
- PreparedStatement (SQL Injection Prevention)
- Input Validation
- Database Transactions (Commit & Rollback)



# ⚙️ Installation

## Clone Repository

```bash
git clone https://github.com/shahtanish/DigitalWalletManagementSystem.git
```

## Configure Database

- Create a MySQL database.
- Import the SQL tables.
- Update database credentials in the project.

## Run Project

- Import as a Maven Project.
- Deploy on Apache Tomcat.
- Open:

```
http://localhost:8080/DigitalWalletManagementSystem
```

---

# 📚 Concepts Implemented

- MVC Architecture
- Jakarta Servlets
- JSP
- JSTL
- JDBC
- DAO Pattern
- Session Management
- Cookies
- Servlet Filters
- Database Transactions
- Exception Handling
- Form Validation

---

# 🚀 Future Improvements

- Password Hashing using BCrypt
- Spring Boot Migration
- Spring Security
- REST APIs
- Email Notifications
- Connection Pooling
- Pagination
- Unit Testing
- Docker Deployment

---

# 👨‍💻 Author

**Tanish Shah**

GitHub: https://github.com/shahtanish

---

## ⭐ Star this repository if you found it useful!
