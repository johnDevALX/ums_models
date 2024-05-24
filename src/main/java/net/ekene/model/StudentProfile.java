package net.ekene.model;

import jakarta.persistence.*;
import lombok.*;
import net.ekene.staff.Department;
import net.ekene.user.UserData;
import net.ekene.utility.Address;
import net.ekene.utility.BaseData;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class StudentProfile extends BaseData {
    private String gender;
    private String phoneNumber;
    private LocalDate dob;
    @Embedded
    private Address address;
    @Column(unique = true)
    private int matricNumber;
    @ManyToOne
    private Department department;
    private String admissionStatus;
    private LocalDate enrollmentDate;
    @OneToOne
    private UserData user;
}
