package megacom.kg.test.service;

import megacom.kg.test.model.Order;
import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order creatOrder(Order order);

    Order updateOrder(Long id,Order order );

    void deleteOrder(Long id);

    Order getOrderById(Long id);

    void deleteById(Long id);

}
