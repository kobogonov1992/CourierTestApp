package megacom.kg.test.model.dto;

import lombok.Data;
import megacom.kg.test.model.Admin;
import megacom.kg.test.model.Courier;
import megacom.kg.test.model.OrderStatus;
import megacom.kg.test.model.baseEntity.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class OrderDto extends BaseEntity {

    private String order_name;

    private long ransom_sum;

    @CreationTimestamp
    private LocalDateTime order_date;

    private long delivery_price;

    private String comment;

    @ManyToOne
    @JoinColumn(name="order_status_id")
    private OrderStatus order_status;

    @ManyToOne
    @JoinColumn(name="courier_id")
    private Courier courier;

//    @ManyToOne
//    @JoinColumn(name="from_address")
//    private Address from_address;
//
//    @ManyToOne
//    @JoinColumn(name="to_address")
//    private Address to_address;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;


}
