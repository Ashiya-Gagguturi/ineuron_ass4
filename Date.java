package mySqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Date {

	public static void main(String[] args) throws ParseException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String url="jdbc:mysql://localhost:3306/mydatabase";
		String Username="root";
		String password="Sanjushanu786*";
		Scanner scan=new Scanner(System.in);
		String name=scan.next();
		String gender=scan.next();
		String adrress=scan.next();
		System.out.println("Enter dob ::dd-MM-yyyy");
		String dob=scan.next();
		System.out.println("Enter dob ::MM-dd-yyyy");
		String doj=scan.next();
		System.out.println("Enter dob ::yyyy-MM-dd");
		String dom=scan.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(dob);
		long time=udate.getTime();
		java.sql.Date sdate=new java.sql.Date(time);
		SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date ddoj=sdf1.parse(doj);
		long ldoj=ddoj.getTime();
		java.sql.Date sdoj=new java.sql.Date(ldoj);
		
		
		java.sql.Date sdom=java.sql.Date.valueOf(dom);
		String query="insert into emptable2(`name`,`gender`,`address`,`dob`,`doj`,`dom`) values(?,?,?,?,?,?)";
		try {
			connection=DriverManager.getConnection(url, Username, password);
			
			if(connection!=null) {
				preparedStatement=connection.prepareStatement(query);
				if(preparedStatement!=null) {
					preparedStatement.setString(1,name);
					preparedStatement.setString(2,gender);
					preparedStatement.setString(3,adrress);
					preparedStatement.setDate(4,sdate);
					preparedStatement.setDate(5,sdoj);
					preparedStatement.setDate(6,sdom);
					preparedStatement.executeUpdate();
					System.out.println("succcess");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(connection!=null){
				connection.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(scan!=null) {
				scan.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		}

	}

}
