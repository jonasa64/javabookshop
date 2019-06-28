/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;
import entity.User;
import Data.UserMapper;
import facade.UserFacade;

/**
 *
 * @author Jonas
 */
public class UserFacadeImpl implements UserFacade{
    
    private UserMapper um;
    
    public UserFacadeImpl(){
        um = new UserMapper();
    }
    

    @Override
    public void crateUser(User u) {
       um.createUser(u);
    }



    @Override
    public User loginUser(String username, String password) {
        User u = um.login(username, password);
        return u;
    }

    @Override
    public void addToToBlance(int id, int blance) {
      um.addToBlance(id, blance);
    }

    @Override
    public User findeUser(int id) {
     User u = um.findUser(id);
     return u;
    }

  
    
}
