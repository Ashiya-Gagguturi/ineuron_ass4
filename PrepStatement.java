package mySqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class PrepStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement ps=null;
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		String name=scan.next();
		int age=scan.nextInt();
		String url="jdbc:mysql://localhost:3306/mydatabase";
		String Username="root";
		String password="Sanjushanu786*";
		String sqlQueryInsert="insert into emptable1 values(?,?,?)";
		try {
		connection=DriverManager.getConnection(url, Username, password);
		if(connection!=null) {
			ps=connection.prepareStatement(sqlQueryInsert);
			if (ps!=null) {
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.executeUpdate();
				
				
					}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(connection!=null){
				connection.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(scan!=null) {
				scan.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
}
