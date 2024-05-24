package net.ekene.user;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import net.ekene.response.ClientResponseObj;
import net.ekene.utility.Address;
import net.ekene.utility.BaseData;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StaffProfile extends BaseData {

    private String gender;
    private String phoneNumber;
    private LocalDate dob;
    @Embedded
    private Address address;
    private String departmentName;
    private double salary;
    @OneToOne
    private UserData user;

    public ClientResponseObj mapToClientResponseObj(){
        return ClientResponseObj.builder()
                .firstName(getUser().getFirstName())
                .email(getUser().getEmail())
                .departmentName(getDepartmentName())
                .gender(getGender())
                .role(getUser().getRole())
                .build();
    }
}
