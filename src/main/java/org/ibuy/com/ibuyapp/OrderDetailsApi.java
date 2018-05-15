package org.ibuy.com.ibuyapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DbConnect.DatabaseConnect;
import Objects.OrderDetailsTable;
import Objects.OrderTable;

public class OrderDetailsApi {

	
	PreparedStatement pst = null;
	Connection con = null;
    public OrderDetailsApi()
    {
    	
    }
    
    public String OrderDetailInsert(OrderDetailsTable orderdet)
	{
		OrderDetailsTable orddet=new OrderDetailsTable();
		orddet=orderdet;
		
		String response="";
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Insert into OrderDetailsTable(OrderTable_orderid,productId,quantity,Productname) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,orddet.getOrderid());
			pst.setLong(2,orddet.getProductid());
			pst.setLong(3,orddet.getQuantity());
			pst.setString(4,orddet.getProductName());
		
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			
			response="SuccessfullyPaid";
			
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
    
    public ArrayList<OrderDetailsTable> getOrderlist(int orderid)
  	{
  		ArrayList<OrderDetailsTable> orddet=new ArrayList<OrderDetailsTable>();
  		try {
  			con = DatabaseConnect.connection();
  			pst = con.prepareStatement("Select * from OrderDetailsTable where OrderTable_orderid='"+orderid+"'");
  			ResultSet rs= pst.executeQuery();
  			while(rs.next()) { 
  				
  				OrderDetailsTable orddetobj=new OrderDetailsTable();
  				
  				orddetobj.setProductid(rs.getLong("productId"));
  				orddetobj.setProductName(rs.getString("Productname"));
  				orddetobj.setQuantity(rs.getLong("quantity"));
  				orddet.add(orddetobj);
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
  		
  		return orddet;
  	}
      
    

    
    
}
