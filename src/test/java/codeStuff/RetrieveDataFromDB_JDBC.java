package codeStuff;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class RetrieveDataFromDB_JDBC {

	public static void main(String []args) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		User u;
		ObjectMapper obj;
		ArrayList<User> al = new ArrayList<User>();
		JSONArray j= new JSONArray();
		FileWriter file = null;
		
		DatabaseConnection dbConn = DatabaseConnection.getInstance();
		Connection conn=dbConn.getConnection();
		System.out.println("Connection created");
		Statement stat=conn.createStatement();
		ResultSet rs=stat.executeQuery("select * from UserInfo;");
		
		while(rs.next()) {
			
			u = new User();
		    u.setId(rs.getInt(1));
		    u.setName(rs.getString(2));
		    u.setPhone(rs.getInt(3));
		    u.setCity(rs.getString(4));
		    u.setState(rs.getString(5));
		    u.setCountry(rs.getString(6));
		    
		    al.add(u);
		}
		
		
		for(int i=0;i<al.size();i++) {
			obj = new ObjectMapper();
		   obj.writeValue(new File("C:\\Users\\Mudit\\eclipse-workspace\\DBPojoJsonApi\\userInfo"+i+".json"), al.get(i));
		// Gson - create json string from java object
			Gson g = new Gson();
			String jsonString=g.toJson(al.get(i));
			j.add(jsonString);
	}
		
		// Json simple - 
		JSONObject jO = new JSONObject();
		jO.put("data", j);
		//System.out.println(jO.toJSONString());
		
		// From ApacheCommonsText Api
		String unescapeString=StringEscapeUtils.unescapeJava(jO.toJSONString());
		//System.out.println(unescapeString);
		String string1=unescapeString.replace("\"{", "{");
		String finalOutput=string1.replace("}\"", "}");
		//System.out.println(finalOutput);
		
		// To write json string in to json file
		try {
			file = new FileWriter("C:\\Users\\Mudit\\eclipse-workspace\\DBPojoJsonApi\\user.json");
			file.write(finalOutput);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			file.close();
		}
		conn.close();
		System.out.println("Connection closed");
	
	}
}
