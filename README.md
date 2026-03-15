# 🏧 ATM System (Java + JDBC + MySQL)

A **console-based ATM Transaction System** developed using **Java, JDBC, and MySQL**.  
This project simulates core banking operations such as deposits, withdrawals, balance inquiry, and transaction tracking.

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
ATM-System-Java
│
├── src
│ └── atm_project
│ ├── ATMSystem.java
│ ├── Account.java
│ ├── OptionMenu.java
│ └── DatabaseConnection.java
│
├── database
│ └── atm_database.sql
│
├── screenshots
│
└── README.md


---

## ⚙️ How to Run the Project

1️⃣ Clone the repository
git clone https://github.com/PranavBhosale20/ATM-System-Java.git


2️⃣ Import the project into **Eclipse IDE**

3️⃣ Setup MySQL database using:
database/atm_database.sql


4️⃣ Configure database credentials in:
DatabaseConnection.java


5️⃣ Run the program:
ATMSystem.java


---

## 🗄 Database Schema

The database contains two tables:

**accounts**

| Column | Description |
|------|-------------|
| customer_number | Unique user ID |
| pin | User PIN |
| current_balance | Current account balance |
| saving_balance | Savings account balance |

**transactions**

Stores transaction history for deposits and withdrawals.

---

## 👨‍💻 Author

**Pranav Bhosale**  
🎓 B.Tech – Computer Science (Data Science)  
💻 Aspiring **Java Backend Developer**

---

⭐ If you found this project useful, consider giving it a **star**!

