package mySqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewCode {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Connection connection=null;
		Statement statement=null;
		String url="jdbc:mysql://localhost:3306/mydatabase";
		String Username="root";
		String password="Sanjushanu786*";
		try {
		connection=DriverManager.getConnection(url, Username, password);
		if(connection!=null) {
			statement=connection.createStatement();
			if (statement!=null) {
				String sqlQueryInsert="insert into emptable1 values(26,'Asshri',35)";
				int countInsert=statement.executeUpdate(sqlQueryInsert);
				System.out.println("Rows Effected while inserting..."+countInsert);
				String sqlQueryUpdate="update emptable1 set age=30 where id=8";
				int countUpdate=statement.executeUpdate(sqlQueryUpdate);
				System.out.println("Row effected while updating....."+countUpdate);
				String sqlQueryDelete="delete from emptable1 where id=1";
				int countDelete=statement.executeUpdate(sqlQueryDelete);
				System.out.println("Rows effected while deleting..."+countDelete);
				String sqlQueryShow="select id,name,age from emptable1";
				resultSet=statement.executeQuery(sqlQueryShow);
				if(resultSet!=null) {
					while(resultSet.next()) {
						int id=resultSet.getInt("id");
						String name=resultSet.getString("name");
						int age=resultSet.getInt("age");
						System.out.println(id+name+age);
						
					}
				}
			
			
		}
		}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
	}

}
