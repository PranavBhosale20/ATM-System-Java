# 🏧 ATM System (Java + JDBC + MySQL)

A **console-based ATM Transaction System** developed using **Java, JDBC, and MySQL**.

This project simulates real-world banking operations such as **user authentication, deposits, withdrawals, balance inquiry, and transaction tracking**. It also includes an **admin panel** to monitor accounts and transaction history.

---

## 💡 Project Overview

This project demonstrates how **Java applications interact with databases using JDBC**.  
Users can securely log in using their **customer number and PIN**, perform banking transactions, and view account balances.

An **admin module** allows administrators to view all accounts and transaction records stored in the database.

---

## 🚀 Features

✅ **Customer Login System**  
✅ **Admin Login Panel**  
✅ **Deposit Money**  
✅ **Withdraw Money**  
✅ **Balance Enquiry**  
✅ **Transaction History Tracking**  
✅ **Multiple User Accounts Support**

---

## 🛠 Technologies Used

| Technology | Purpose |
|------------|--------|
| **Java** | Core application logic |
| **JDBC** | Database connectivity |
| **MySQL** | Data storage |
| **Eclipse IDE** | Development environment |

---

## 📂 Project Structure

```
ATM-System-Java
│
├── src
│   └── atm_project
│       ├── ATMSystem.java
│       ├── Account.java
│       ├── OptionMenu.java
│       └── DatabaseConnection.java
│
├── database
│   └── atm_database.sql
│
├── screenshots
│
└── README.md
```

---

## ⚙️ How to Run the Project

1️⃣ Clone the repository
**git clone https://github.com/PranavBhosale20/ATM-System-Java.git**

2️⃣ Import the project into **Eclipse IDE**

3️⃣ Setup MySQL database using the SQL file located in
**database/atm_database.sql**

4️⃣ Configure database credentials in
**DatabaseConnection.java**

5️⃣ Run the program
**ATMSystem.java**


---

## 🗄 Database Schema

The database contains two tables.

### **Accounts Table**

| Column | Description |
|------|-------------|
| customer_number | Unique user ID |
| pin | User PIN |
| current_balance | Current account balance |
| saving_balance | Savings account balance |

### **Transactions Table**

Stores transaction history for **deposits and withdrawals**.

| Column | Description |
|------|-------------|
| id | Transaction ID |
| customer_number | Account owner |
| account_type | Current / Saving |
| transaction_type | Deposit / Withdraw |
| amount | Transaction amount |
| transaction_time | Timestamp |

---

## 📸 Screenshots

Screenshots of the application can be found in the **screenshots** folder.

Examples include:

- Login interface
- Customer transaction menu
- Admin panel
- Transaction history output

---

## 🚀 Future Improvements

Possible upgrades for this project:

- Add **GUI interface using Java Swing**
- Build a **web version using Spring Boot**
- Implement **secure password hashing**
- Add **REST APIs for banking operations**
- Improve validation and error handling

---

## 👨‍💻 Author

**Pranav Bhosale**  
🎓 B.Tech – Computer Science (Data Science)  
💻 Aspiring **Java Backend Developer**

---

⭐ If you found this project useful, consider giving it a **star**.
































