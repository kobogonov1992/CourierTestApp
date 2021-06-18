package megacom.kg.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import megacom.kg.test.model.baseEntity.BaseEntity;
import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "address_details")
public class AddressDetails extends BaseEntity {

    @Column(nullable = false)
    private    String from_address;

    @Column(nullable = false)
    private    String phone;

    @Column(nullable = false)
    private    String to_address;

    public AddressDetails(String from_address, String phone, String to_address, Order order) {
        this.from_address = from_address;
        this.phone = phone;
        this.to_address = to_address;
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Override
    public String toString() {
        return
                "from_address='" + from_address +  " , " +
                " phone='" + phone + " , "+
                        "to_address='" + to_address;
    }
}
