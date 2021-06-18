package megacom.kg.test.model.dto;

import lombok.Data;
import megacom.kg.test.model.Courier;
import megacom.kg.test.model.Person;


@Data
public class CourierDto extends Person {

    private  String phone;

    private Courier courier;

//    @Enumerated(value = EnumType.STRING )
//    private Courier_status courier_status;

    private String courier_status;
}
