package megacom.kg.test.service.impl;

import megacom.kg.test.exception.ResourceNotFoundException;
import megacom.kg.test.model.Order;
import megacom.kg.test.repositories.OrderRepo;
import megacom.kg.test.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order creatOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order orderRequest) {
        Order order = orderRepo.findById(id).
                orElse(null);
        orderRequest.setOrder_name(orderRequest.getOrder_name());
        orderRequest.setRansom_sum(orderRequest.getRansom_sum());
        orderRequest.setOrder_date(orderRequest.getOrder_date());
        orderRequest.setDelivery_price(orderRequest.getDelivery_price());
        orderRequest.setComment(orderRequest.getComment());
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepo.findById(id).
                orElse(null);
        orderRepo.delete(order);
    }

    @Override
    public void deleteById(Long id){
        orderRepo.deleteById(id);
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> result = orderRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            try {
                throw new ResourceNotFoundException("Order", "id", id);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }

        Order order = orderRepo.findById(id).orElse(null);
        return order;
    }
}
