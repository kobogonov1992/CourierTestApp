package megacom.kg.test.model;

import lombok.*;
import megacom.kg.test.model.baseEntity.BaseEntity;
import megacom.kg.test.model.enums.Order_status;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    private String order_name;

    @Enumerated(value = EnumType.STRING )
    private Order_status order_status;

    private long ransom_sum;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime order_date;

    private long delivery_price;

    private String comment;


    @ManyToOne
    @JoinColumn(name="courier_id")
    private Courier courier;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<AddressDetails> addressDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

    public void addDetail(String address_from,String phone,String address_to){
        this.addressDetails.add(new AddressDetails(address_from,phone,address_to,this));
    }

}
