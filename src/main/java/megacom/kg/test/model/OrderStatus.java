package megacom.kg.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import megacom.kg.test.model.baseEntity.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class OrderStatus extends BaseEntity {

    private String name;

}
