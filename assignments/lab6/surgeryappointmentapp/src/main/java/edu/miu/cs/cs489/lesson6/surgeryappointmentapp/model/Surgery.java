package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "surgeries")
public class Surgery {
    @Id
    private String surgeryNo;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
} 