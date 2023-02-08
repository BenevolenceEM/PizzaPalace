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

public class Customer {
    private int id;
    private String customerId;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    
    //Empty constructor
    public Customer(){
        this.id = 0;
        this.customerId = "";
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.phone = "";
        this.password = "";
    }
    // Copy constructor
    public Customer(Customer c){
        this.id = c.id;
        this.customerId = c.customerId;
        this.firstname = c.firstname;
        this.lastname = c.lastname;
        this.email = c.email;
        this.phone = c.phone;
        this.password = c.password;
    }
    //Constructor with parameters
    public Customer(int id, String custId, String fn, String ln, String em, String ph, String pass){
        this.id = id;
        this.customerId = custId;
        this.firstname = fn;
        this.lastname = ln;
        this.email = em;
        this.phone = ph;
        this.password = pass;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }
    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }
    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return a customer from the database.
     */
    public void selectEmail(String email){
        this.email = email;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            Statement stmt = con.createStatement();
            String request = "SELECT * FROM Customers WHERE email = '" +getEmail()+ "'";
            System.out.println(request);
            ResultSet rs = stmt.executeQuery(request);
            
            rs.next();
                setId(rs.getInt(1));
                setCustomerId(rs.getString("CustomerID"));
                setFirstname(rs.getString("FirstName"));
                setLastname(rs.getString("LastName"));
                setEmail(rs.getString("Email"));
                setPhone(rs.getString("Phone"));
                setPassword(rs.getString("Password"));    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     /**
     * @return all the class fields without invoking the method.
     */
    public String toString(){
        return  "Id: " + this.id +"\n" +
                "CustomerId: " + this.customerId +"\n" +
                "Firstname: " + this.firstname +"\n" +
                "Lastname: " + this.lastname +"\n" +
                "Email: " + this.email +"\n" +
                "Phone: " + this.phone +"\n" +
                "Password: " + this.password +"\n" ;             
    }
     /**
     * @return all the class fields.
     */
    public void display(){
        System.out.println("Id: " + this.id);
        System.out.println("CustomerId: " + this.customerId);
        System.out.println("Firstname: " + this.firstname);
        System.out.println("Lastname: " + this.lastname);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Password: " + this.password);
        System.out.println();
    }
    
    
}
