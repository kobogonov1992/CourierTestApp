package megacom.kg.test.repositories;

import megacom.kg.test.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepo extends JpaRepository<Courier,Long> {

}
