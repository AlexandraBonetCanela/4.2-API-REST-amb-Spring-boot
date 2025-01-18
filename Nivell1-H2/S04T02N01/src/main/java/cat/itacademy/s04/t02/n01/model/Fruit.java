package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Setter
    @Min(value = 1, message = "Quantity must be at least 1 kg")
    private int kgQuantity;

    @Override
    public String toString() {
        return "Fruit{id=" + id + ", name='" + name + "', kgQuantity=" + kgQuantity + "}";
    }
}
