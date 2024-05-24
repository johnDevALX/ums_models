package net.ekene.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import net.ekene.response.DepartmentResponseObj;
import net.ekene.user.StaffProfile;
import net.ekene.utility.BaseData;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department extends BaseData {
    @Column(unique = true)
    private String departmentName;
    @OneToOne
    private StaffProfile headOfDepartment;
    private LocalDate dateCreated;
    private boolean accredited;

    public DepartmentResponseObj returnResponse(){
        return DepartmentResponseObj.builder()
                .departmentName(getDepartmentName())
                .headOfDepartment(getHeadOfDepartment().getUser().getFirstName())
                .build();
    }
}
