package org.ibuy.com.ibuyapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnect.DatabaseConnect;
import Objects.Customer;
import Objects.OrderTable;

public class OrderApi {
	
	PreparedStatement pst = null;
	Connection con = null;
    public OrderApi()
    {
    	
    }
    
    public int OrderInsert(OrderTable order)
	{
		OrderTable ordobj=new OrderTable();
		ordobj=order;
		
		int  response=-1;
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Insert into OrderTable(PaymentTable_transactionId,CustomersTable_id,amount,qrcode) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,ordobj.getPaymentTable_transactionId());
			pst.setInt(2,ordobj.getCustomersTable_id());
			pst.setLong(3,ordobj.getAmount());
			pst.setString(4,ordobj.getQrcode());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			
			response=generatedKey;
		}catch(Exception exp)
		{
		
			System.out.println("" + exp);
			
			
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
    
    
    public OrderTable getorderDetails(String qrcode)
	{
		OrderTable ordtab=new OrderTable();
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from OrderTable where qrcode='"+qrcode+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) { 
				
				ordtab.setAmount(rs.getLong("amount"));
				ordtab.setCustomersTable_id(rs.getInt("CustomersTable_id"));
				ordtab.setOrderid(rs.getInt("orderid"));
				ordtab.setPaymentTable_transactionId(rs.getInt("PaymentTable_transactionId"));
				ordtab.setQrcodePrinted((rs.getBoolean("qrcodePrinted")));
				
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
		
		return ordtab;
	}
    
    public boolean printedQR(String qrcode)
    {
    	boolean result=false;
    	try {
  			con = DatabaseConnect.connection();
  			pst = con.prepareStatement("UPDATE OrderTable SET qrcodePrinted=NOT qrcodePrinted WHERE qrcode='"+qrcode+"'");
  			pst.executeUpdate();
  			result=true;
  			
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
  		
    	
    	return result;
    }
    
    
    public boolean getqrprinted(String qrcode)
   	{
   		boolean res=false;
   		try {
   			con = DatabaseConnect.connection();
   			pst = con.prepareStatement("Select * from OrderTable where qrcode='"+qrcode+"'");
   			ResultSet rs= pst.executeQuery();
   			while(rs.next()) { 
   				
   			
   				res=(rs.getBoolean("qrcodePrinted"));
   				
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
   		
   		return res;
   	}
       


}
