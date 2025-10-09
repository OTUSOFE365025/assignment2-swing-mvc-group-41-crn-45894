# MVC Swing Cash Register Application

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)

## Overview
This project demonstrates a Model-View-Controller (MVC) architecture implementation using Java Swing, featuring a cash register application that scans products and calculates running totals.

## Team Members
- **Aliza Rizwan** (100922005): Deliverables 1 + 4
- **Inshal Chauhdry** (100918210): Deliverable 2 + CashRegister model
- **Zainab Lawal** (100911716): Display + Controller + Scanner

## Assignment Deliverables

### 1. Do some investigation into the Swing framework and write a short paragraph describing the purpose of the Swing framework. Submit a class diagram of the components of Swing.
The Swing framework is a GUI (Graphical User Interface) toolkit that is a part of the Java Foundation Classes. The purpose of the Swing framework is to provide ready-made components such as buttons, text fields, labels, and windows, which can then be combined to become an interactive desktop application. Switch is a relatively lightweight framework and is mostly written in Java, which means that it can work the same way in many different operating systems, such as Windows, Mac, and Linux. One of the more important qualities of the Swing framework is that it follows the MVC (Model-View-Controller) architecture internally. In this architecture, the model represents the data, the view handles how the data is displayed, and the controller manages user actions such as button clicks. To summarize, Swing as a framework makes it easier for the user to focus on how the application looks and behaves without needing to build out everything from scratch. 
In this MVC project, Swing is used in the View and Scanner classes to showcase an interactive display window, where the controller listens for button events and updates the model.

<img width="646" height="263" alt="image" src="https://github.com/user-attachments/assets/69444722-c106-4cd6-a5c7-476fa4083ec9" />



### 2.  Look through the example code in the GitHub repository and explain how this example implements the MVC pattern. How does it differ from the conventional MVC pattern described in the lectures?
The purpose of the MVC pattern is to separate information (Model), presentation (View), and user interaction (Control). This is used so that when data changes, the view and controller can update independently. The example code in the Github repository implements the MVC pattern by firstly making the model class store the users' first and last names and provides getter and setter methods. It only represents the data and does not depend on any graphics. The view class creates the user interface by using Swing components such as JFrame, JLabel, JTextField, and JButton. This class is responsible for displaying data and creating user fields in which the user can type. The controller class connects the view and model by listening for user actions such as button clicks. When new data is received, it updates the model and tells the view to refresh for display new messages. However, this code differs from the conventional MVC pattern described in the lectures as the controller manually tells the view what to display. The model does not directly notify the view or controller about changes, but instead, the controller handles all the communication. This makes it different from the conventional MVC pattern as the controller and view are more tightly linked. 

### 3.  In the repository there is another Java file that is named Scanner. This Class emulates the scanning of a product by generating a UPC code. If you press on the Scan button you will see that it prints out the “12345” code to the console. For this assignment, modify the Scanner so that each time the Scan button is pressed, it randomly selects a UPC code from a file containing product information with the following format.

The application has been modified to include a functional cash register system:

**Components:**

- **Model (CashRegister)**:
  - Reads product information from a file
  - Maintains a list of scanned items
  - Provides methods to add items by UPC code
  - Calculates running subtotals

- **View (Display)**:
  - Shows a scrollable list of all scanned items with their prices
  - Displays the running subtotal at the bottom
  - Uses Swing components for the user interface

- **Controller**:
  - Receives scan events from the Scanner
  - Tells the CashRegister to add scanned items
  - Updates the View with new information

- **Scanner**:
  - Generates random UPC codes from a product database file
  - Format: UPC Code | Product | Price

**Product Database Format:**
| UPC Code | Product | Price |
|----------|---------|-------|
| 12345    | Coffee  | $8.32 |
| 67890    | Muffin  | $2.50 |

**Usage:**
When executing the main Java file, users can repeatedly press the Scan button to see multiple products appear in the scrollable list, with the subtotal updating automatically after each scan.

### 4. Create a sequence diagram of your design for the scenario presented in question 3, representing a single press of the scan button.

*A sequence diagram representing a single press of the scan button would be included here, showing the interaction between Scanner, Controller, CashRegister (Model), and Display (View) components.*
<img width="744" height="364" alt="image" src="https://github.com/user-attachments/assets/7886e49f-1ce4-4187-bc73-f5dccd9a31e6" />


## Conclusion

As a team, we gained a clearer understanding of how MVC is interpreted differently across frameworks like Swing. Building the Cash Register application helped us appreciate the separation of concerns and the importance of controller logic in managing user interactions. We also observed that tightly coupled components, while not ideal in large systems, can still work effectively in small-scale applications like ours.

