package megacom.kg.test.Controller;

import megacom.kg.test.model.Courier;
import megacom.kg.test.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("/couriers")
    public String getAllCouriers(Model model) {  // Model это аналог Мапы в Java в которую добавляем атрибуты
        List <Courier> couriers = courierService.getAllCouriers();
        model.addAttribute("couriers",couriers);
        return "courier-list";
    }

    @GetMapping("/courier-create")
    public String createCourierForm(Courier courier){
        return "courier-create";
    }

    @PostMapping("/courier-create")
    public String createCourier(Courier courier){
        courierService.creatCourier(courier);
        return "redirect:/couriers";
    }

    @GetMapping("courier-delete/{id}")
    public String deleteCourierById(@PathVariable("id") Long id){
        courierService.deleteById(id);
        return "redirect:/couriers";
    }

    @GetMapping("/courier-update/{id}")
    public String updateCourierForm(@PathVariable("id") Long id, Model model){
      Courier courier = courierService.getCourierById(id);
      model.addAttribute("courier",courier);
        return "/courier-update";
    }


    @PostMapping("/courier-update")
    public String updateCourier(Courier courier){
        courierService.creatCourier(courier);
        return "redirect:/couriers";
    }


}
