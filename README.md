📚 StudentDBMS – JDBC Mini Project
A console-based Student Database Management System built using Core Java and JDBC.
This project demonstrates complete CRUD operations with a PostgreSQL database using PreparedStatement.
🚀 Features
➕ Add new student records
📄 Display all students
✏️ Update student details
Name
Age
Name & Age
❌ Delete student records
🔍 Search student by ID

🔁 Menu-driven program with repeat options

🔐 SQL Injection safe (PreparedStatement)

🛠️ Technologies Used
Java (Core Java)
JDBC
PostgreSQL
Maven
Git & GitHub

🗂️ Project Structure
StudentDBMS-With-JDBC
│
├── src
│   └── main
│       └── java
│           └── StudentDBMS.java
│
├── pom.xml
├── .gitignore
└── README.md

🧑‍💻 Database Schema
Table Name: StudentDBMS
CREATE TABLE StudentDBMS (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    branch VARCHAR(50)
);

⚙️ How It Works

User selects an option from the menu
Input is taken using Scanner
SQL queries are executed using PreparedStatement
Database responds with success or failure
User can repeat operations using y/n

▶️ How to Run the Project
Clone the repository
git clone https://github.com/anujsawant138/StudentDBMS-With-JDBC.git
Open the project in IntelliJ IDEA / Eclipse
Configure PostgreSQL credentials in code:
String url = "jdbc:postgresql://localhost:5432/First";
String user = "postgres";
String pass = "root";

Make sure PostgreSQL is running
Run StudentDBMS.java
📸 Sample Menu Output
=================================
WELCOME TO STUDENT DBMS
=================================
1. Add Student
2. Display Student
3. Update Details
4. Delete Student
5. Search Student
6. Exit
=================================

🎯 Learning Outcomes

Hands-on experience with JDBC
Understanding of CRUD operations
Usage of PreparedStatement
Proper database resource handling
Real-world menu-driven application design
Git & GitHub workflow

🔮 Future Enhancements

Convert to Spring Boot REST API
Add Android / Web frontend
Implement login system
Add transaction management
Use DAO pattern

👤 Author
Anuj Sawant
Engineering Student | Java & Backend Enthusiast

📌 GitHub: https://github.com/anujsawant138

⭐ If you like this project

Give it ⭐ on GitHub — it motivates me to build more 🚀
