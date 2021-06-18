package megacom.kg.test.service.impl;

import megacom.kg.test.exception.ResourceNotFoundException;
import megacom.kg.test.model.Courier;
import megacom.kg.test.repositories.CourierRepo;
import megacom.kg.test.service.CourierService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepo courierRepo;

    public CourierServiceImpl(CourierRepo courierRepo) {
        super();
        this.courierRepo = courierRepo;
    }

    @Override
    public List<Courier> getAllCouriers() {
        return courierRepo.findAll();
    }

    @Override
    public Courier creatCourier(Courier courier) {
        return courierRepo.save(courier);
    }

    @Override
    public Courier updateCourier(Long id, Courier courierRequest) {
       Courier courier = courierRepo.findById(id).
               orElse(null);
       courier.setFullName(courierRequest.getFullName());
       courier.setPhone(courierRequest.getPhone());
       courier.setCourier_status(courierRequest.getCourier_status());
        return courierRepo.save(courier);
    }

    @Override
    public void deleteCourier(Long id) {
        Courier courier = courierRepo.findById(id).
                orElse(null);
        courierRepo.delete(courier);
    }

    @Override
    public void deleteById(Long id){
        courierRepo.deleteById(id);
    }

    @Override
    public Courier getCourierById(Long id) {
        Optional<Courier> result = courierRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            try {
                throw new ResourceNotFoundException("Courier", "id", id);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }

        Courier courier = courierRepo.findById(id).orElse(null);
        return courier;
    }
}
