# CRUD-desktop-app---Wholesaler

#java #hibernate #msql2_database #docker

PROBLEM AREA

The IT system was created for the "FotoSun" company dealing in the sale and assembly of solar panels, but it can be successfully used by other companies of a similar size dealing in this field.


THE PURPOSE OF THE PROJECT

The system is to be used to store information about the company. It is to facilitate access and increase the transparency of data concerning, inter alia, orders and customers, top sellers or product properties. An employee or manager using the system should be able to add new orders and view orders that already exist in the system. The system also makes it possible to edit the selected order and view its details, such as: the name of the customer who made the order, the name of the technician assigned to perform this order and the list of ordered solar panels.

 

USER REQUIREMENTS

1.	Information on persons associated with the company should be stored in the system. They have been divided according to the function performed - into employees and customers, including employees into salesmen, technicians and helpers. All divisions are complete.

2.	Name, surname and e-mail address should be kept for each person.

3.	Company employees should be described by PESEL, date of birth, salary and length of service. For people from outside the company - for customers, information about the address of residence and any discount should be remembered (if the customer places another order or recommended the company to a friend).

4.	The system should store more accurate information about the company's employees. For salespeople, the area they deal with. Information on specializations is stored for technicians. We keep the amount of overtime for helpers.

5.	The system should make it possible to find a currently available technician and find the best seller - that is the seller who currently handles the largest number of orders.

6.	The system should also store information about orders. The value of the order, the date of submission and its planned date of commencement of execution should be kept. Additionally, the order may have a report.

7.	The report consists of a detailed description of the contract and includes information on any subsidies.

8.	The placed customer's order is serviced by the seller, while the technician or a group of technicians is responsible for the execution of the order, depending on the size of the order.

9.	The planned period of work for the technicians is also recorded, consisting of the assembly start date and the expected completion date.

10.	Panels are ordered under the order. For panels, information on efficiency (on a scale from 1-5), area (panel surface area) and the type of panel due to its possible location - roof or ground, should be kept. For the roof panel, we store information about its weight, and for the ground panel, we store information about the type of frame - it can be made of stainless steel or aluminum. The system will also store information about the material the panel is made of (polycrystalline, monocrystalline). For a monocrystalline panel, it is possible to choose a color - blue or black. For the polycrystalline panel, information about possible subsidies under national government programs aimed at taking care of the environment is stored.



FUNCTIONAL REQUIREMENTS
 
The system is to support potential users, among others in carrying out the tasks listed below:
• find the best seller (seller)
• display all orders planned for a given month (technician)
• find a free technician (seller)
• browse the list of orders (seller, assistant, technician)
• view order details (seller, assistant, technician)
• write a report for the order (assistant, technician, seller)
• add a new order (seller)
• edit order (seller)
• delete order (seller)


NON-FUNCTIONAL REQUIREMENTS
 
The following is a list of examples of non-functional requirements that could be considered when considering the constraints on which the company should work.
• Transparency and intuitiveness of the GUI
• Ease of use
• Data storage in a database
• Securing the correctness of data (data validation)
•	Availability
• Reliability
• Ensuring data security


USE CASES DIAGRAM
 

ANALYTICAL CLASS DIAGRAM

 



SCENARIO FOR USE CASE "View Order Details"

Name of the use case 	Browse order details
Initial condition 	There is at least one order in the system.
The main flow of events	1.	The employee actor starts a use case.
2.	 The system displays a list of orders in the system
3.	 The actor chooses the order
4.	The system displays the details of the selected order

Alternative course of events	2a. There is no order in the system, the system displays a message and the use case ends. 
End 	According to the script
Final condition	Provided the conditions are met - order details have been displayed.

 
ACTIVITY DIAGRAM FOR A USE CASE - "View order details"
 


INTERACTION DIAGRAM FOR USE CASE - "View Order Details"
 

CONDITION DIAGRAM FOR THE "Order" CLASS
 
GUI CONCEPT
 
 
 


DYNAMIC ANALYSIS

When creating the activity diagram for a use case, there was a need to add the following methods to the "Order" class:
• addOrder ()
• deleteOrder ()
• editOrder ()
• displayDetails ()
• viewDateMonth'sOrders ()
• browseOrderList ()
 
and removing the methods updujZameniem () from the "Seller" class and displayZamieniaZDanegoMonta (MonthNumber) from the Technician class because they were deemed unnecessary in these classes.
The getName () method has been added to the Person class, which will be inherited by the Client, Technician, Merchant and assistant. The getListPaneli () method has been added to the Panel class.
 

DESIGN CLASS DIAGRAM

 


DISCUSSION OF DESIGN DECISIONS
1.	The project will be implemented in Java.
2.	Composite attribute - address, in the "Customer" class has been replaced with a separate "Address" class and the connection with the "Customer" class with the relationship 1-1.
3.	The composition between the "Report" and "Order" classes has been replaced with the internal class "Report" in the "Order" superclass.
4.	"Execution" association class has been replaced with a normal class in the diagram.
5.	Multifaceted inheritance has been replaced by flattening. The attributes of the "Roof panel" and "Ground panel" classes have been moved to the "Panel" class.
6.	Derivative attribute - seniority, in the "Employee" class will be calculated using the calculateStaz () method based on the date of employment of a given employee.
7.	Class attribute - the minimum age in the "Employee" class will be implemented using the static keyword, since it is the same for all objects of this class - equal to 18.
8.	Repeatable attribute - specializations, will be implemented in the "Technician" class using a list.
9.	The persistence of the extension will be implemented by connecting the application to the database.
