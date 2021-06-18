package megacom.kg.test.service;

import megacom.kg.test.model.Admin;
import java.util.List;


public interface AdminService {

    List<Admin> getAllAdmins();

    Admin creatAdmin(Admin admin);

    Admin updateAdmin(Long id,Admin admin );

    void deleteAdmin(Long id);

    Admin getAdminById(Long id);

    void deleteById(Long id);

}
