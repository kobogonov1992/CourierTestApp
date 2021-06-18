package megacom.kg.test.service;

import megacom.kg.test.model.Courier;
import megacom.kg.test.repositories.CourierRepo;

import java.util.List;

public interface CourierService {

    List<Courier> getAllCouriers();

    Courier creatCourier(Courier courier);

    Courier updateCourier(Long id,Courier courier );

    void deleteCourier(Long id);

    Courier getCourierById(Long id);

    void deleteById(Long id);

}
