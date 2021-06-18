package megacom.kg.test.model.dto;

import lombok.Data;
import megacom.kg.test.model.baseEntity.BaseEntity;

@Data
public class AddressDto extends BaseEntity {

    private    String address;
    private    String phone;

}
