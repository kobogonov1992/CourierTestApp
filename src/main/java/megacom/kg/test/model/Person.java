package megacom.kg.test.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import megacom.kg.test.model.baseEntity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

  public Person(Long id,String fullName) {
    super(id);
    this.fullName = fullName;
  }


  @Column(name="name", nullable = false)
  private  String fullName;

}
