package megacom.kg.test.repositories;

import megacom.kg.test.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository <Order,Long> {
}
