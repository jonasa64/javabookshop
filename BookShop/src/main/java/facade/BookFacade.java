/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entity.Book;
import java.util.List;
/**
 *
 * @author Jonas
 */
public interface BookFacade {
    List<Book> getAllBooks();
    Book getBookById(int id);
    List<Book> getBooksByGenre(String genre);
}
