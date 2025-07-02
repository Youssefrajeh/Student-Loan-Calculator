# Student Loan Application

This Java application provides a simple system for managing student loans using object-oriented principles, interfaces, and exception handling.

## Overview

The application allows users to:

- Create student profiles with name, program, and loan amount
- Calculate monthly loan payments based on standard formulas
- Handle invalid input using a custom exception for negative loan values

## Project Structure

- `Student.java` – Defines the `Student` class and implements the loan calculation logic
- `y_a_LoanPayable.java` – Interface that enforces loan-related methods
- `y_a_NegativeValueException.java` – Custom exception for handling negative input
- `StudentLoanApp.java` – Main class that runs the application and interacts with the user

## How to Run

1. Compile all `.java` files:
   ```bash
   javac *.java
Run the application:

bash
Copy
Edit
java StudentLoanApp
Requirements
Java Development Kit (JDK) 8 or higher

Author
Youssef Rajeh ----------- Abdul Maarouf
