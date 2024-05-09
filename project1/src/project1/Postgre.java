package project1;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgre {

	public static void main(String[] args) throws SQLException, IOException, 
	ClassNotFoundException {
		
		// Postgresql driver
				Class.forName("org.postgresql.Driver");
				
				// Connection to postgre				
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root@123");
		
				//Atomicity
				conn.setAutoCommit(false);
				
				// For Isolation
				conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
				
				Statement stmt = null;
				try {
					// Create statement object
					stmt = conn.createStatement();
					
                    
                 //1.Product p1 is deleted from product and stock
				//stmt.executeUpdate("DELETE FROM product WHERE product.prodid = 'p1'");
				
                 //2. The depot d1 is deleted from Depot and Stock
               //stmt.executeUpdate("DELETE FROM Depot WHERE depid = 'd1'");
					
				 //3. Change product p1 name to pp1 in Product and Stock
				//stmt.executeUpdate("UPDATE product SET prodid = 'pp1' WHERE prodid = 'P1'");		
				
				//4. The depot d1 changes its name to dd1 in Depot and Stock.
				//stmt.executeUpdate("UPDATE depot SET depid = 'dd1' WHERE depid = 'D1'");
				  
				//5. Add product (p100, cd, 5) in Product and (p100, d2, 50) in Stock 
				//stmt.executeUpdate("INSERT INTO product (prodid, pname, price) VALUES ('p100', 'cd',5)");
				//stmt.executeUpdate("INSERT INTO stock (prodid, depid, quantity) VALUES ('p100', 'd2', 50)");
				
				//6. Add a depot (d100, Chicago, 100) in Depot and (p1, d100, 100) in Stock.
				//stmt.executeUpdate("INSERT INTO stock (prodid, depid, quantity) VALUES ('p1', 'd00', 100)");
				//stmt.executeUpdate("INSERT INTO depot (depid, address ,volume) VALUES ('d100', 'Chicago',100)");
				}
		
				catch(SQLException e) {
					
					System.out.println("Transaction Failed, PERFORMING ROLLBACK \n"+e);
					// for atomicity
					conn.rollback();
					stmt.close();
					conn.close();
					return;
				}
		
				System.out.println("Transaction Successful, PERFORMING COMMIT \n");
				conn.commit();
				stmt.close();
				conn.close();
				
	}
}

