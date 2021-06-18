package megacom.kg.test.model.dto;

import lombok.Data;
import megacom.kg.test.model.Person;

@Data
public class AdminDto extends Person {

    private   String login;
    private   String password;

}