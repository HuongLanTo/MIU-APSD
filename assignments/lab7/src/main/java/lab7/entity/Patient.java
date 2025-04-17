package lab7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address primaryAddress;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
