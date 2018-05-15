package org.ibuy.com.ibuyapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnect.DatabaseConnect;
import Objects.PaymentTable;

public class PurchaseApi {
	
	PreparedStatement pst = null;
	Connection con = null;
    public PurchaseApi()
    {
    	
    }
    
	
	public int PaymentInsert(PaymentTable pay)
	{
		PaymentTable paymentobj=new PaymentTable();
		paymentobj=pay;
		
		int  response=-1;
		try {
			con = DatabaseConnect.connection();
			pst = con.prepareStatement("Insert into PaymentTable(cardHolderName, CardNumber, amountPaid) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,paymentobj.getCardHolderName());
			pst.setLong(2,paymentobj.getCardNumber());
			pst.setLong(3,paymentobj.getAmountPaid());
			
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

}
