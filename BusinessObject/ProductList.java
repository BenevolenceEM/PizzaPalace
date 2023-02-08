/** ******************************************************************************
 * Pizza Store Project
 * ProductList Business Object
 * Author: Benevolence Ed Malik & Pradsley D'Haiti
 * Date: 02/07/2022
 ******************************************************************************** */
package BusinessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> products;
    //Constructor
    public ProductList(){
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(new Product(product));
    }
  public ArrayList<Product> searchProduct(String pdetail){   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            System.out.println("Database connected");
            Statement stmt = con1.createStatement();
            String sql = "SELECT * FROM Products WHERE ProductName LIKE'"+pdetail+"%' OR Price='"+pdetail+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = (rs.getInt(1));
                String productId = (rs.getString("ProductId"));
                String productName = (rs.getString("ProductName"));
                double price = (rs.getDouble("Price"));
                String description = (rs.getString("Description"));
                String status = (rs.getString("Status")); 
                
                Product product = new Product(id,productId,productName, price, description, status);
                products.add(new Product(product));
                   
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }      
        return products;
    }
    /**
     * Return all the products from the database.
     */
    public ArrayList<Product> getProducts(){   
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            System.out.println("Database connected");
            Statement stmt = con1.createStatement();
            String sql = "SELECT * FROM Products";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int id = (rs.getInt(1));
                String productId = (rs.getString("ProductId"));
                String productName = (rs.getString("ProductName"));
                double price = (rs.getDouble("Price"));
                String description = (rs.getString("Description"));
                String status = (rs.getString("Status")); 
                
                Product product = new Product(id,productId,productName, price, description, status);
                products.add(new Product(product));
                   
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }      
        return products;
    }
    public void display(){
        for(Product prod: products){
            prod.display();
        }
    }
    public static void main(String[] arg){
        ProductList products = new ProductList();
        products.searchProduct("Original");
        products.display();
    }
}
