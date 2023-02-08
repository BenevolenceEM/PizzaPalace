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
public class Employees {
    public int ID;
    public String EmpID;
    public String FullName;
    public String Password;
    
    public Employees() {
        ID = 0;
        EmpID = "";
        FullName = "";
        Password = "";
    }
    
    public Employees(int I, String EID, String FN, String P) {
        ID = I;
        EmpID = EID;
        FullName = FN;
        Password = P;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setID(int I){
        ID = I;
    }
    
    public String getEmpID(){
        return EmpID;
    }
    
    public void setEmpID(String EID){
        EmpID = EID;
    }
    
    public String getFullName(){
        return FullName;
    }
    
    public void setFullName(String FN){
        FullName = FN;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String P){
        Password = P;
    }
    
    public void SelectDB(int I) {
        ID = I;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Select * from Employees WHERE ID = '"+getID()+"'";
            System.out.println(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            ID = rs.getInt(1);
            EmpID = rs.getString(2);
            FullName = rs.getString(3);
            Password = rs.getString(4);
            
            con.close();
        }
        catch(Exception e) {
            System.out.println("PP: " + e);
        }
    }
    
    public void InsertDB(int I, String EID, String FN, String P) {
        ID = I;
        EmpID = EID;
        FullName = FN;
        Password = P;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String connURL="jdbc:ucanaccess://c:/Users/malik/OneDrive/Desktop/PizzaStoreDB.accdb";
            Connection con = DriverManager.getConnection(connURL);
            System.out.println("DB Connected");
            
            Statement stmt = con.createStatement();
                                                                                                                                            
            String sql;
            sql = "Insert into Employees values ("+getID()+", "+"'" + getEmpID()+"', "+"'" + getFullName()+"', "+"'" + getPassword()+"')";
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
            sql = "Update Employees set EmpID = "
                        + "'" + getEmpID()+"', "
                        + ""+" FullName = '" + getFullName()+"', "
                        + ""+" Password = '" + getPassword()+"' "
                        + "where ID = "+getID()+"";
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
            sql = "Delete from Employees where ID = '"+getID()+"'";
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
    
    public void display(){
        System.out.println(ID);
        System.out.println(EmpID);
        System.out.println(FullName);
        System.out.println(Password);
    }
    
    public static void main(String[] args) {
        //Employees e1 = new Employees();
        //e1.SelectDB(1);
        //e1.display();
        
        //Employees e2 = new Employees();
        //e2.InsertDB(4, "BS2101", "Bella Smith", "bemith101*");
        //e2.display();
        
        //Employees e3 = new Employees();
        //e3.SelectDB(4);
        //e3.setFullName("Ben Smith");
        //e3.UpdateDB();
        //e3.display();
        
        Employees e4 = new Employees();
        e4.SelectDB(4);
        e4.DeleteDB();
    }
}
