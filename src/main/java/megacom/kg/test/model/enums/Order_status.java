package megacom.kg.test.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Order_status {
    ОТКРЫТ("ОТКРЫТ"), ВИП("ВИП"), ЗАКРЫТ("ЗАКРЫТ");

    private final String status2;

}
