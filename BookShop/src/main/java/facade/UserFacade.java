/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entity.User;
/**
 *
 * @author Jonas
 */
public interface UserFacade {
    void crateUser(User u);
   User loginUser(String username, String password);
    void addToToBlance(int id, int blance);
    User findeUser(int id);
}
