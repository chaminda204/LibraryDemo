This contains the set of instructions required to build and run the Web Application.

Building the Project.
====================

Pre-requisites
--------------
JDK 1.6.x or higher
Maven 2 or higher
set java_home and m2_home.
eClipse 3.5 or higher (Optional)

Steps:
------
1 - Download the project
2 - Go to the project home directory of LibraryWeb , and run 
    $ mvn clean package
    
3 - Import project to your IDE for review (Optional)
	a) To import your project into eclipse IDE
			$ mvn eclipse:eclipse
 			Import the project into eclipse IDE (Existing Projects in Workspace > Browse and locate the extracted "PeterPalLibraryWeb" folder). 
    


Running the application.
========================
For instructions on setting Extjs, please refer to http://www.sencha.com/products/extjs .

Copy the PeterPalLibraryWeb.war file to deployment folder in your web application and start the server.
Please note this was tested on JBoss server.
		

       
       


