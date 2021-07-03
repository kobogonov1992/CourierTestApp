package megacom.kg.test.model;

import lombok.*;
import megacom.kg.test.model.enums.Courier_status;
import javax.persistence.*;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "couriers")
public class Courier extends Person {

    private  String phone;

    @Enumerated(value = EnumType.STRING )
    private Courier_status courier_status;


}
