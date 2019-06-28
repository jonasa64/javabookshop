/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.User;

/**
 *
 * @author Jonas
 */
public class UserMapper {
    
    public void createUser(User u){
        String sql = "insert into users(username, password, blance) values(?, ?, ?)";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getBlance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
 
    
    
   
    public User login(String username, String password){
        
        String sql = "select id, username, blance from users where username = ? and password = ? ";
        
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               return new User(rs.getInt("id"), rs.getString("username"), rs.getInt("blance"));
           } 
              
           return null;
           
        } catch (SQLException e) {
        e.printStackTrace();
        
        }
        
        return null;
        
    }
    
    
    public void addToBlance(int id, int amount){
        String sql = "update users set blance = blance + ? where  id = ?";
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void withdrawalFromBlance(int id, int amount){
          String sql = "update users set blance = blance - ? where  id = ?";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public User findUser(int id){
        String sql = "select id, username, blance from users where id = ?";
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("id"), rs.getString("username"), rs.getInt("blance"));
                
            }
            
            return null;
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        UserMapper um = new UserMapper();
       
      
    }
    
    
}
