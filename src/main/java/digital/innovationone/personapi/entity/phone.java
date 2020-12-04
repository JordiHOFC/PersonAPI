package digital.innovationone.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   // @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    //private phoneType type;

    @Column(nullable = false)
    private String number;
}
