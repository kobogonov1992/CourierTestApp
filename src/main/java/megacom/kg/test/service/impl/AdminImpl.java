package megacom.kg.test.service.impl;

import megacom.kg.test.exception.ResourceNotFoundException;
import megacom.kg.test.model.Admin;
import megacom.kg.test.repositories.AdminRepo;
import megacom.kg.test.service.AdminService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminImpl(AdminRepo adminRepo) {
        super();
        this.adminRepo = adminRepo;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Admin creatAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin adminRequest) {

        Admin admin = adminRepo.findById(id).
                orElse(null);
        admin.setFullName(adminRequest.getFullName());
        admin.setLogin(admin.getLogin());
        admin.setPassword(admin.getPassword());
        return adminRepo.save(admin);

    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = adminRepo.findById(id).
                orElse(null);
        adminRepo.delete(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> result = adminRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            try {
                throw new ResourceNotFoundException("Admin", "id", id);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
            Admin admin = adminRepo.findById(id).orElse(null);
            return admin;
        }
    }

        @Override
        public void deleteById (Long id){
            adminRepo.deleteById(id);
        }

}