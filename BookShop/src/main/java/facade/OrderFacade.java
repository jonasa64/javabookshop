/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Order;
import java.util.List;

/**
 *
 * @author Jonas
 */
public interface OrderFacade {
    
    public void creatOrder(Order o);
    public List<Order> getOrderByUser(int id);
    
}
