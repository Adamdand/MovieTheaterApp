Authors (Group 3)
---
Junwoo Choi   
Karlen Chow   
Adam D'Andrea   
Dong Phuong      

How to Run
---
1. Edit login.txt to match your MySQL environment/credentials (in both MovieTheaterApp and Database_Creation)
2. Run CreateDB.jar using the following terminal command "java -jar CreateDB.jar". See 1.png for a successful output
3. Run MovieTheaterApp.jar using the following terminal command "java -jar MovieTheaterApp.jar". See 2.png for a successful output

Notes About the Program
---
0. Uses MySQL for the database
1. Make sure login.txt is in the same directory as MovieTheaterApp.jar
2. Make sure login.txt, movieOfferings.txt, registeredUsers.txt and voucherList.txt are all in the same directory as CreateDB.jar
3. Alternatively you can create the database using the provided MySQL dump, make sure you have a database named "movietheaterdb"
4. Source code files are provided in the .tar file
5. Receipts are outputted as text files in the same directory of MovieTheaterApp.jar
6. Main method for the GUI is located in Main (Controller package)
7. Main method for the database creation is located in DBEngine (DatabaseController package)