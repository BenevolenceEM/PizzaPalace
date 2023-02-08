/** ******************************************************************************
 * Pizza Store Project
 * Product Business Object
 * Author: Benevolence Ed Malik & Pradsley D'Haiti
 * Date: 02/07/2022
 ******************************************************************************** */
package BusinessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Product {
    // Fields
    private int id;
    private String productId;
    private String productName;
    private double price;
    private String description;
    private String status;
    // Constructors
    public Product(){
        id = 0;
        productId = "";
        productName = "";
        price = 0;
        description = "";
        status = "";
    }
    // Constructor with arguments
    public Product(int id, String proId, String proName, double p, String desc, String status){
        this.id = id;
        this.productId = proId;
        this.productName = proName;
        this.price = p;
        this.description = desc;
        this.status = status;
    }
    // Copy Constructor
    public Product(Product product){
        this.id = product.id;
        this.productId = product.productId;
        this.productName = product.productName;
        this.price = product.price;
        this.description = product.description;
        this.status = product.status;
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
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void selectDB(String prodId){
        this.productId = prodId;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            System.out.println("Database connected");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Products WHERE ProductID ='"+ getProductId()+"'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                setId(rs.getInt("ID"));
                setProductId(rs.getString("ProductId"));
                setProductName(rs.getString("ProductName"));
                setPrice(rs.getDouble("Price"));
                setDescription(rs.getString("Description"));
                setStatus(rs.getString("Status"));
            
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public void display(){
        System.out.println("Id : " + getId());
        System.out.println("ProductID : " + getProductId());
        System.out.println("Product name : " + getProductName());
        System.out.println("Price : " + getPrice());
        System.out.println("Description : " + getDescription());
        System.out.println("Status : " + getStatus());
        System.out.println();
    }
    
    public static void main(String[] arg){
        Product p = new Product();
        p.selectDB("OPC23");
        p.display();
    }
    
}
