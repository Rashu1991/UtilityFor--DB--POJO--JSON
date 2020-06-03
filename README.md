# UtilityFor--DB--POJO--JSON
------------------------------
What is this utility about?

In different scenarios there are cases where we have to extarct data from databases and use that data as inputs to API's.
With the help of this code we can perform the above said task which will contain series of process.
Firstly, we need to prepare our query to hit the database and fetch results.
Secondly, we need to convert the db results to plain old java object format.
Third, have to convert the pojo object to json(javascript object notation - the format or the data communicator or the object used in API's)

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

