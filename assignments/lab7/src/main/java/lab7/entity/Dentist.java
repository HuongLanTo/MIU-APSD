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
public class Dentist {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;
}

