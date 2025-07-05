# 💸 PrimoWallet - Java Desktop Application

**PrimoWallet** is a Java-based desktop application designed for digital wallet management. It allows users to register accounts, manage balances via cash or bank transactions, transfer funds, and view transaction history through a user-friendly GUI.

---

## 🧩 Features

* ✅ User Registration & Login
* 💳 Add Balance (via Cash or Bank)
* 🔁 Transfer Balance to Other Users
* 📄 Withdraw Balance (Cash or Bank)
* 👤 View Profile & Account Info
* 📚 Transaction History Viewer
* 🧠 Validation of Input & Secure JDBC Handling

---

## 🗂️ Project Structure

```
PrimoWallet_Project-master/
|
├── build.xml                # Ant build script
├── manifest.mf             # Manifest file
├── primodb.sql             # SQL dump for MariaDB/MySQL
├── account.txt             # Empty placeholder
├── /build/                 # Build output
|
├── /src/ or /projectgui/   # Java GUI logic and main forms
├── /projectoop/            # Business logic classes (inferred from imports)
|
└── *.java                  # Java source files (Swing GUI)
```

---

## 🚠 Tech Stack

* **Java SE** (Swing for GUI)
* **JDBC** (Java Database Connectivity)
* **MySQL/MariaDB** (Database)
* **NetBeans** (Project originally developed in NetBeans IDE)

---

## 🗃️ Database

Import the following SQL file to set up the database:

```sql
primodb.sql
```

Use tools like **phpMyAdmin** or command-line MySQL client:

```bash
mysql -u root -p < primodb.sql
```

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/PrimoWallet.git
   cd PrimoWallet
   ```

2. Open the project in **NetBeans** (or any Java IDE).

3. Ensure your database (MySQL/MariaDB) is running and import `primodb.sql`.

4. Run the project (typically `Login.java` is the entry point).

---

## 🔐 Authentication & Validation

* **Username/password validation** with SQL-backed storage
* **Input validation** using regex in `Validation.java`

---
