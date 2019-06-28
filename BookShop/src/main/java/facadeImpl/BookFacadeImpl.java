/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;
import Data.BookMapper;
import entity.Book;
import facade.BookFacade;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class BookFacadeImpl implements BookFacade{
    
    private BookMapper bm;
    
    public BookFacadeImpl(){
        bm = new BookMapper();
    }
    
    
    @Override
    public List<Book> getAllBooks() {
    List<Book> books = bm.getAllBooks();
    return books;
    }

    @Override
    public Book getBookById(int id) {
     Book book = bm.getBookById(id);
     return book;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        List<Book> books = bm.getBooksByGenre(genre);
        return books;
    }
    
}
