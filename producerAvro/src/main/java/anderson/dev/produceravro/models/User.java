package anderson.dev.produceravro.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String name;
    private String documentNumber;
    private Short age;
}
