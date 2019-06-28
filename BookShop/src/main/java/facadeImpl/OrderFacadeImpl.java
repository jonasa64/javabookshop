/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;
import java.util.List;
import entity.Order;
import Data.OrderMapper;
/**
 *
 * @author Jonas
 */
public class OrderFacadeImpl implements facade.OrderFacade{
    private OrderMapper om;
    
    public OrderFacadeImpl(){
        om = new OrderMapper();
    }
    
    @Override
    public void creatOrder(Order o) {
       om.creatOrder(o);
    }

    @Override
    public List<Order> getOrderByUser(int id) {
        List<Order> orders = om.getOrderByUser(id);
        return orders;
    }
    
}
