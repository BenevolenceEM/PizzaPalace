/** ******************************************************************************
 * Pizza Store Project
 * Customer Business Object
 * Author: Benevolence Ed Malik & Pradsley D'Haiti
 * Date: 02/05/2022
 ******************************************************************************** */
package BusinessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerList {
    private ArrayList<Customer> customers;
    
    // Constructor 
    public CustomerList(){
        customers = new ArrayList<>();
    }
     /**
     * @param cust object, add a customer inside the arraylist.
     */
    public void addCustomer(Customer cust){
        customers.add(cust);
    }
   /**
     * Return all the customers from the database.
     */
    public ArrayList<Customer> getCustomers(){
        
       
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            System.out.println("Database connected");
            Statement stmt = con1.createStatement();
            String sql = "SELECT * FROM Customers";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = (rs.getInt(1));
                String custId = (rs.getString("CustomerID"));
                String custFn = (rs.getString("FirstName"));
                String custLn = (rs.getString("LastName"));
                String custEmail = (rs.getString("Email"));
                String phone = (rs.getString("Phone"));
                String custPass = (rs.getString("Password")); 
                
                Customer c1 = new Customer(id,custId,custFn, custLn, custEmail, phone, custPass);
                customers.add(c1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return customers;
    }
    public void display(){
        for(int i = 0; i < customers.size(); i++){
            customers.get(i).display();
        }
    }
    
}
