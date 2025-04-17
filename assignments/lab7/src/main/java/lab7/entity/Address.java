package lab7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String city;

    @OneToOne(mappedBy = "primaryAddress")
    private Patient patient;

    @ManyToOne
    private Surgery surgery;
}

