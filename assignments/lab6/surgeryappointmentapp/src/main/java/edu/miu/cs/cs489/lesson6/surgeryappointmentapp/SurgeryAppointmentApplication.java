package edu.miu.cs.cs489.lesson6.surgeryappointmentapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.*;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@SpringBootApplication
public class SurgeryAppointmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurgeryAppointmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            PatientService patientService,
            DentistService dentistService,
            SurgeryService surgeryService,
            AppointmentService appointmentService) {
        return args -> {
            System.out.println("Starting Dental Surgery Application...\n");

            // Create Surgeries
            var surgery1 = new Surgery();
            surgery1.setSurgeryNo("S10");
            surgery1.setName("Surgery 10");
            surgery1.setAddress(new Address(null, "123 Main St", "Fairfield", "IA", "52557"));
            
            var surgery2 = new Surgery();
            surgery2.setSurgeryNo("S15");
            surgery2.setName("Surgery 15");
            surgery2.setAddress(new Address(null, "456 Burlington Ave", "Fairfield", "IA", "52556"));

            var surgery3 = new Surgery();
            surgery3.setSurgeryNo("S13");
            surgery3.setName("Surgery 13");
            surgery3.setAddress(new Address(null, "789 Court St", "Fairfield", "IA", "52557"));
            
            surgeryService.addNewSurgery(surgery1);
            surgeryService.addNewSurgery(surgery2);
            surgeryService.addNewSurgery(surgery3);
            System.out.println("Surgeries created successfully!");

            // Create Patients
            var patient1 = new Patient();
            patient1.setPatNo("P100");
            patient1.setPatName("Gillian White");
            patient1.setAddress(new Address(null, "111 Patient St", "Fairfield", "IA", "52557"));

            var patient2 = new Patient();
            patient2.setPatNo("P105");
            patient2.setPatName("Jill Bell");
            patient2.setAddress(new Address(null, "222 Patient Ave", "Fairfield", "IA", "52557"));

            var patient3 = new Patient();
            patient3.setPatNo("P108");
            patient3.setPatName("Ian MacKay");
            patient3.setAddress(new Address(null, "333 Patient Dr", "Fairfield", "IA", "52557"));

            var patient4 = new Patient();
            patient4.setPatNo("P110");
            patient4.setPatName("John Walker");
            patient4.setAddress(new Address(null, "444 Patient Ln", "Fairfield", "IA", "52557"));

            patientService.addNewPatient(patient1);
            patientService.addNewPatient(patient2);
            patientService.addNewPatient(patient3);
            patientService.addNewPatient(patient4);
            System.out.println("Patients created successfully!");

            // Create Dentists
            var dentist1 = new Dentist();
            dentist1.setDentistNo("D1");
            dentist1.setDentistName("Tony Smith");

            var dentist2 = new Dentist();
            dentist2.setDentistNo("D2");
            dentist2.setDentistName("Helen Pearson");

            var dentist3 = new Dentist();
            dentist3.setDentistNo("D3");
            dentist3.setDentistName("Robin Plevin");

            dentistService.addNewDentist(dentist1);
            dentistService.addNewDentist(dentist2);
            dentistService.addNewDentist(dentist3);
            System.out.println("Dentists created successfully!");

            // Create Appointments
            var appointment1 = new Appointment();
            appointment1.setAppointmentDate(LocalDate.of(2013, 9, 12));
            appointment1.setAppointmentTime(LocalTime.of(10, 0));
            appointment1.setPatient(patient1);
            appointment1.setDentist(dentist1);
            appointment1.setSurgery(surgery2);

            var appointment2 = new Appointment();
            appointment2.setAppointmentDate(LocalDate.of(2013, 9, 12));
            appointment2.setAppointmentTime(LocalTime.of(12, 0));
            appointment2.setPatient(patient2);
            appointment2.setDentist(dentist1);
            appointment2.setSurgery(surgery2);

            var appointment3 = new Appointment();
            appointment3.setAppointmentDate(LocalDate.of(2013, 9, 12));
            appointment3.setAppointmentTime(LocalTime.of(10, 0));
            appointment3.setPatient(patient3);
            appointment3.setDentist(dentist2);
            appointment3.setSurgery(surgery1);

            var appointment4 = new Appointment();
            appointment4.setAppointmentDate(LocalDate.of(2013, 9, 14));
            appointment4.setAppointmentTime(LocalTime.of(14, 0));
            appointment4.setPatient(patient3);
            appointment4.setDentist(dentist2);
            appointment4.setSurgery(surgery1);

            var appointment5 = new Appointment();
            appointment5.setAppointmentDate(LocalDate.of(2013, 9, 14));
            appointment5.setAppointmentTime(LocalTime.of(16, 30));
            appointment5.setPatient(patient2);
            appointment5.setDentist(dentist3);
            appointment5.setSurgery(surgery2);

            var appointment6 = new Appointment();
            appointment6.setAppointmentDate(LocalDate.of(2013, 9, 15));
            appointment6.setAppointmentTime(LocalTime.of(18, 0));
            appointment6.setPatient(patient4);
            appointment6.setDentist(dentist3);
            appointment6.setSurgery(surgery3);

            appointmentService.addNewAppointment(appointment1);
            appointmentService.addNewAppointment(appointment2);
            appointmentService.addNewAppointment(appointment3);
            appointmentService.addNewAppointment(appointment4);
            appointmentService.addNewAppointment(appointment5);
            appointmentService.addNewAppointment(appointment6);
            System.out.println("Appointments created successfully!\n");

            // Display all data using service layer
            System.out.println("Displaying all data from database:\n");
            
            System.out.println("All Patients:");
            patientService.getAllPatients().forEach(System.out::println);
            
            System.out.println("\nAll Dentists:");
            dentistService.getAllDentists().forEach(System.out::println);
            
            System.out.println("\nAll Surgeries:");
            surgeryService.getAllSurgeries().forEach(System.out::println);
            
            System.out.println("\nAll Appointments:");
            appointmentService.getAllAppointments().forEach(System.out::println);

            // Demonstrate some service layer queries
            System.out.println("\nDemonstrating service layer queries:");
            
            System.out.println("\nFinding patient by name 'Gillian White':");
            patientService.findPatientByPatName("Gillian White")
                    .ifPresent(System.out::println);
            
            System.out.println("\nFinding appointments for dentist 'Tony Smith':");
            appointmentService.findAppointmentsByDentistNo("D1")
                    .forEach(System.out::println);
            
            System.out.println("\nFinding appointments for September 12, 2013:");
            appointmentService.findAppointmentsByDate(LocalDate.of(2013, 9, 12))
                    .forEach(System.out::println);
        };
    }
} 