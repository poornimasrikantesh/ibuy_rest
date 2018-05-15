package org.ibuy.com.ibuyapp;


import DbConnect.DatabaseConnect;
import Objects.Customer;
import Objects.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductApis {

	PreparedStatement pst = null;
	Connection con = null;
    public ProductApis()
    {
    	
    }
    
    
    
    public int getAisle(String Productname)
	{
    	int ailseno=0;
		
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from ProductsTable where productName='"+Productname +"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				int no = rs.getInt("aisleNo");
				ailseno=no;
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
		
		return ailseno;
	
	}
    
    

    public Product getProduct(String barcode)
	{
    		Product prod=new Product();
		
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from ProductsTable where barcode='"+barcode +"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				prod.setAisleNo(rs.getInt("aisleNo"));
				prod.setProductName(rs.getString("productName"));
				prod.setWeight(rs.getInt("weight"));
				prod.setProductprice(rs.getInt("productPrice"));
				prod.setId(rs.getInt("id"));
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
		
		return prod;
	
	}
    
    

    public ArrayList<Product> getAllProduct()
	{
    		ArrayList<Product> products=new ArrayList<Product>();
    		
		
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from ProductsTable");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				Product prod=new Product();
				prod.setAisleNo(rs.getInt("aisleNo"));
				prod.setProductName(rs.getString("productName"));
				prod.setWeight(rs.getInt("weight"));
				prod.setProductprice(rs.getInt("productPrice"));
				prod.setId(rs.getInt("id"));
				prod.setBarcode(rs.getString("barcode"));
				
				products.add(prod);
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
		
		return products;
	
	}
    
    
    public int getProductPrice(String Productname)
	{
    	int productprice=0;
		
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Select * from ProductsTable where productName='"+Productname +"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				int no = rs.getInt("productPrice");
				productprice=no;
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
		
		return productprice;
	
	}
    

    
}
