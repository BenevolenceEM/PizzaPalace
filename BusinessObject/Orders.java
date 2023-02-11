package BusinessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * Benevolence Ed-Malik
   Pradsley D'Haiti
 */

public class Orders {
    String OrderID;
    String CustomerID;
    String Status;
    
    public Orders() {
        CustomerID = "N/A";
        Status = "Open";
    }
    
    public Orders(String CID) {
        CustomerID = CID;
        Status = "Open";
    }
    
    public String getOrderID() {
        return OrderID;
    }
    
    public void setOrderID(String OID) {
        OrderID = OID;
    }
    
    public String getCustomerID() {
        return CustomerID;
    }
    
    public void setCustomerID(String CID) {
        CustomerID = CID;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public void setStatus(String S) {
        Status = S;
    }
    
    public void setStatusOpen() {
        Status = "Open";
    }
    
    public void setStatusReady() {
        Status = "Ready";
    }
    
    public void setStatusComplete() {
        Status = "Delivered/Picked-up";
    }
    
    public void display() {
        System.out.println("---------------------------");
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Customer ID: " + getCustomerID());
        System.out.println("Order Status: " + getStatus());
        System.out.println("---------------------------");
    }
    
    //select method for Employee using OrderID
    public void SelectDB(String OID) {
        OrderID = OID;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Select * from Orders WHERE OrderID = '"+ OID +"'";
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            setOrderID(rs.getString(1));
            setCustomerID(rs.getString(2));
            setStatus(rs.getString(3));
            
            con.close();
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    //select method for Customer using CustomerID
    public void CustomerSelectDB(String CID) {
        CustomerID = CID;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Select * from Orders WHERE CustomerID = '"+ getCustomerID() +"'";
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            setOrderID(rs.getString(1));
            setCustomerID(rs.getString(2));
            setStatus(rs.getString(3));
            
            con.close();
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    //select method for the OrderID recent Orders
    public void RecentSelectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Select * from Orders ORDER BY OrderID DESC LIMIT 1";
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            setOrderID(rs.getString(1));
            setCustomerID(rs.getString(2));
            setStatus(rs.getString(3));
            
            con.close();
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    public void InsertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Insert into Orders values (NULL, '"+getCustomerID()+"', '" + getStatus()+"')";
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if(n==1){
                System.out.println("INSERT Successful");
            }
            else{
                System.out.println("INSERT Failed");
                con.close();
            }
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    public void UpdateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Update Orders set CustomerID = "
                    + " '" + getCustomerID()+"',"
                    + " "+" Status = '" + getStatus()+"'"
                    + " where OrderID = '"+getOrderID()+"'";
            System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if(n1==1){
                System.out.println("UPDATE Successful");
            }
            else{
                System.out.println("UPDATE Failed");
                con.close();
            }
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    public void DeleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Delete from Orders where OrderID = '" +getOrderID()+"'";
            System.out.println(sql);
            int n2 = stmt.executeUpdate(sql);
            if(n2==1){
                System.out.println("DELETE Successful");
            }
            else{
                System.out.println("DELETE Failed");
                con.close();
            }
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    public static void main(String[] args) {
        //Orders o1 = new Orders();
        //o1.SelectDB("1");
        //o1.display();
        
        //Orders o2 = new Orders();
        //o2.CustomerSelectDB("Daria1");
        //o2.display();
        
        //Orders o3 = new Orders();
        //o3.RecentSelectDB();
        //o3.display();
    }
}
