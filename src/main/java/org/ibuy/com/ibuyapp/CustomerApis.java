package org.ibuy.com.ibuyapp;

import Objects.Customer;
import DbConnect.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerApis {
	
	PreparedStatement pst = null;
	Connection con = null;
    public CustomerApis()
    {
    	
    }
	
	public Customer getCustomerDetailsName(String custname)
	{
		Customer customer=new Customer();
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from CustomersTable where customerName='"+custname+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) { 
				
				customer.setCustomerName(rs.getString("customerName"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setId(rs.getInt("id"));
				customer.setPhone(rs.getInt("phone"));
			}
			
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return customer;
	}
	
	
	public String Signup(Customer customer)
	{
		Customer cus=new Customer();
		cus=customer;
		String response="ok";
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Insert into CustomersTable(customerName,email,password,phone) values (?,?,?,?)");
			pst.setString(1,cus.getCustomerName());
			pst.setString(2,cus.getEmail());
			pst.setString(3,cus.getPassword());
			pst.setInt(4, cus.getPhone());
			pst.executeUpdate();
			response="SuccesfullyInserted";
		}catch(Exception exp)
		{
		
			System.out.println("" + exp);
			response=exp.getMessage();
			
		}
		finally {
			
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
		return response;
		
	}
	
	
	public String SignIn(String customername,String password)
	{
		Customer customer=new Customer();
		String response="Invalid User";
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from CustomersTable where customerName='"+customername+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) { 
				
				customer.setCustomerName(rs.getString("customerName"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setId(rs.getInt("id"));
				customer.setPhone(rs.getInt("phone"));
			}
			
			if(password.equals((String)customer.getPassword()))
			{
				response="ValidUser";
			}
					
			
		}catch(Exception exp)
		{
		
			System.out.println("" + exp);
			response=exp.getMessage();
			
		}
		finally {
			
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
		return response;
		
	}
	

}
