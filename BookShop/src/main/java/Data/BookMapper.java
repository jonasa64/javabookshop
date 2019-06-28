/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;
import java.util.ArrayList;
import entity.Book;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author Jonas
 */
public class BookMapper {
    
public List<Book> getAllBooks(){
    String sql = "select * from books";
    List<Book> books = new ArrayList<>();
    try {
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
        }
        return books;
    } catch (SQLException e) {
    e.printStackTrace();
    }

    return null;
}


public Book getBookById(int id){
    String sql = "select * from books where id = ?";
    
    try {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("publish"), rs.getString("genre"), rs.getInt("price"));
       }
       return null;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

/*
@pram string genre 
return a list of the books by genre
*/
public List<Book> getBooksByGenre(String genre){
    String sql = "select * from books where genre = ?";
    List<Book> books = new ArrayList<>();
    try {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, genre);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
              books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
        }
        return books;
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
   return null;
}



}
