package DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseConnect {
	
	protected Properties prop;
	protected InputStream input;
	
	public DatabaseConnect() throws IOException
	{
		prop=new Properties();
		input=DatabaseConnect.class.getClassLoader().getResourceAsStream("data/config.properties");
		prop.load(input);
		
	}
	public static Connection connection() {
		
		DatabaseConnect dbconnect = null;
		try {
			dbconnect = new DatabaseConnect();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection con = null;
		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("url"+dbconnect.prop.getProperty("url"));
			con = DriverManager.getConnection(dbconnect.prop.getProperty("url"), dbconnect.prop.getProperty("username"), dbconnect.prop.getProperty("password"));

			
		} catch (SQLException exp) {
			System.out.println("Exception  is :" + exp);
		}
		return con;
	}


}
	
	