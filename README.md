# UtilityFor--DB--POJO--JSON
------------------------------
What is this utility about?

In different scenarios there are cases where we have to extarct data from databases and use that data as inputs to API's.
With the help of this code we can perform the above said task which will contain series of process.
Firstly, we need to prepare our query to hit the database and fetch results.
Secondly, we need to convert the db results to plain old java object format.
Third, have to convert the pojo object to json(javascript object notation - the format or the data communicator or the object used in API's)
------------------------------
Prerequisites - 
One has to have any database before using these utility. Below some urls to download databases:
1. https://dev.mysql.com/downloads/installer/ - MySqlDb for different OS are given, please install as per the configuration
2. https://www.oracle.com/database/technologies/112010-win64soft.html - oracle db
3. Install jdbc driver for the particular database in use.
4. set the path for dll file - Go to auth folder, it will be generated once the jdbc is intalled, there will be ".dll" depending upon
system bit configuration, copy the dll file, place it in java/bin folder directory path will be something like ("C:\Program      Files\Java\jdk1.8.0_201\bin").


------------------------------
Code Description -

There are total three classes:
1. DatabaseConnection.java - under src/test/java - which is based on Singleton Design Pattern, it will always return a single instance of connection object
2. RetrieveDataFromDB_JDBC.java - under src/test/java - this class will take the connection from DataBaseConnection class execute the query to the database, fetch the results, convert them in to pojo format and then to json format.
3. User.java - This class create the pojo of User details fetch from the database and uses getter/setter methods for the same.

------------------------------

How to Use it?

1. Clone the project in to your workspace.
2. Import the project in to any IDE.
3. Run the RetrieveDataFromDB_JDBC.java and see the results in file named "user.json".

