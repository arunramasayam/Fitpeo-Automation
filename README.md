# Fitpeo Automation Revenue Calculator

# Prerequisites
To run this project, ensure you have the following installed:

Java 8 or higher,
Maven (for dependency management and running tests),
Eclipse or IntelliJ IDEA.


# Steps to Import and Run the Project in Eclipse:

Import the Project:

File → Import → Git → Projects from Git.
In the Clone URI field, paste the GitHub repository URL.
Select Import as General Project and click Finish.
Convert to Maven Project:

Right-click on the imported project → Configure → Convert to Maven Project.



Run the Tests:

Navigate to /src/test/java/runners/.
Right-click on CucumberTestRunner.java → Run As → TestNG Test.

Log files:

locate target folder in project explorer and right click >Show In > System Explorer
open 'cucumber-reports.html' in browser.


# Steps to Import and Run the Project in Intellij:

Import the project:

 File->New -> project from version control -> Paste github repo url -> clone.

Run the Tests:

Navigate to /src/test/java/runners/.
Right-click on CucumberTestRunner.java →  Run CucumberTestRunner.

Log files:

locate target folder in project explorer and expand it.
right click 'cucumber-reports.html'>Open In>Browser>Chrome.

