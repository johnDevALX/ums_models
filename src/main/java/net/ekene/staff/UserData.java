package net.ekene.staff;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import net.ekene.enums.Role;
import net.ekene.response.UserResponseVO;
import net.ekene.utility.BaseData;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData extends BaseData {
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isUserVerified;
    private String password;

    public UserResponseVO returnResponse() {
        return UserResponseVO.builder()
                .name(getFirstName())
                .email(getEmail())
                .role(getRole())
                .verifiedAccount(isUserVerified())
                .token(null)
                .build();
    }

    public UserResponseVO returnResponse(String token) {
        return UserResponseVO.builder()
                .name(getFirstName())
                .email(getEmail())
                .verifiedAccount(isUserVerified())
                .role(getRole())
                .token(token)
                .build();
    }
}
