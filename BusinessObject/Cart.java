package BusinessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cart extends Product {

    private int quantity;
    private int id;

    public Cart() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qt) {
        this.quantity = qt;
    }

    public Cart getCartId(int id) {
        this.id = id;
        Cart item = new Cart();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//OneDrive//Personal//OneNote//Documents//PizzaStoreDB.accdb/");
            System.out.println("Database connected");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Products WHERE ID = " + id + "";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
                item.setId(rs.getInt("ID"));
                item.setProductId(rs.getString("ProductId"));
                item.setProductName(rs.getString("ProductName"));
                item.setPrice(rs.getDouble("Price"));
                item.setDescription(rs.getString("Description"));
                item.setStatus(rs.getString("Status"));
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return item;
    }
    
    @Override
    public void display() {
        System.out.println("ID : " + getId());
        System.out.println("CartID : " + getProductId());
        System.out.println("Cart name : " + getProductName());
        System.out.println("Price : " + getPrice());
        System.out.println("Description : " + getDescription());
        System.out.println("Status : " + getStatus());
        
    }

    public static void main(String[] args) {
      Cart cart = new Cart();
      cart = cart.getCartId(3);
      cart.display();
    }
} 
