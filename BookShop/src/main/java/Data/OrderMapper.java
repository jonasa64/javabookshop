/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import entity.Order;

/**
 *
 * @author Jonas
 */
public class OrderMapper {
    
    
    public void creatOrder(Order o){
        String sql = "insert into orders(user_id, book_id, totalprice, quatiay) values(?,?,?,?)";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getBookId());
            ps.setInt(3, o.getTotalPrice());
            ps.setInt(4, o.getQuatiay());
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    
    public List<Order> getOrderByUser(int userId){
        String sql = "select * from orders where user_id = ?";
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                orders.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("book_id"), rs.getInt("totalprice"),rs.getDate("orderDate"), rs.getInt("quatiay")));
            }
            return orders;
           
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        return null;
    }
    
 

}
