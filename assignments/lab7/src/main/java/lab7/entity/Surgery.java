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
public class Surgery {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "surgery")
    private List<Address> addresses;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}

