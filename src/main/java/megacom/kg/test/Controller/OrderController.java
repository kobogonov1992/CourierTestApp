package megacom.kg.test.Controller;

import megacom.kg.test.model.Admin;
import megacom.kg.test.model.Courier;
import megacom.kg.test.model.Order;
import megacom.kg.test.service.AdminService;
import megacom.kg.test.service.CourierService;
import megacom.kg.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    private  final OrderService orderService;
    private final CourierService courierService;
    private final AdminService adminService;

    @Autowired
    public OrderController(OrderService orderService, CourierService courierService, AdminService adminService) {
        this.orderService = orderService;
        this.courierService = courierService;
        this.adminService = adminService;
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders",orders);

        return "order-list";
    }

    @GetMapping("/order-create")
    public String createOrderForm(Order order, Model model){
        List<Courier> couriers = courierService.getAllCouriers();
        model.addAttribute("couriers",couriers);
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins",admins);
        return "order-create";
    }

    @PostMapping("/order-create")
    public String createOrder(Order newOrder, HttpServletRequest request){
        String [] addresses_from  = request.getParameterValues("address_from");
        String [] phones  = request.getParameterValues("phone");
        String [] addresses_to  = request.getParameterValues("address_to");

      for(int i = 0; i<addresses_from.length; i++){
          newOrder.addDetail(addresses_from[i],phones[i],addresses_to[i]);
      }

        orderService.creatOrder(newOrder);
        return "redirect:/orders";
    }

    @GetMapping("order-delete/{id}")
    public String deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    @GetMapping("/order-update/{id}")
    public String updateOrderForm(@PathVariable("id") Long id, Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("order",order);
        List<Courier> couriers = courierService.getAllCouriers();
        model.addAttribute("couriers",couriers);
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins",admins);
        return "/order-update";
    }

    @PostMapping("/order-update")
    public String updateCourier(Order order){
        orderService.creatOrder(order);

        return "redirect:/orders";
    }

}
