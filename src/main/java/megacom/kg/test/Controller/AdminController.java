package megacom.kg.test.Controller;

import megacom.kg.test.model.Admin;
import megacom.kg.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    private  final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) { this.adminService = adminService; }

    @GetMapping("/admins")
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins",admins);
        return "admin-list";
    }

    @GetMapping("/admin-create")
    public String createAdminForm(Admin admin){
        return "admin-create";
    }

    @PostMapping("/admin-create")
    public String createAdmin(Admin admin){
        adminService.creatAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("admin-delete/{id}")
    public String deleteAdminById(@PathVariable("id") Long id){
       adminService.deleteById(id);
        return "redirect:/admins";
    }

    @GetMapping("/admin-update/{id}")
    public String updateAdminForm(@PathVariable("id") Long id, Model model){
        Admin admin = adminService.getAdminById(id);
        model.addAttribute("admin",admin);
        return "/admin-update";
    }

    @PostMapping("/admin-update")
    public String updateAdmin(Admin admin){
        adminService.creatAdmin(admin);
        return "redirect:/admins";
    }

}
