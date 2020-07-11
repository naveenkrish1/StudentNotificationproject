package com.students.notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.students.ConnectionEstablishment;
import org.json.simple.JSONObject; 


public class NotifyCourses {
	@SuppressWarnings("unchecked")
	public  JSONObject GetNotifications(String username) throws SQLException {
		Connection connection = new ConnectionEstablishment().createConnection();
		String sql="SELECT * FROM NOTIFICATIONS WHERE username= ?";
		PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
	    statement.setString(1, username);
	    statement.executeQuery();
	    ResultSet result = statement.executeQuery();
	    JSONObject item=new JSONObject();
	    while(result.next()) {
	    	String notify=result.getString("notification");
	    	String status=result.getNString("status");
	    	item.put(notify,status);
	    }
	    result.close();
	    connection.close();
	    return item;
	}
	public boolean Updatestatus(String username){
		Connection connection1 = new ConnectionEstablishment().createConnection();
		String sql="Update NOTIFICATIONS SET status=? where username=?";
		PreparedStatement statement = ((java.sql.Connection) connection).prepareStatement(sql);
		statement.setString(1,"read");
		statement.setString(2,username);
		statement.executeUpdate();
		connection1.close();
		return true;
	}
	
}
