package net.ekene.user;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import net.ekene.user.UserData;
import net.ekene.utility.BaseData;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken extends BaseData {
    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private UserData userData;
    @NonNull
    private String token;
    private boolean isExpired;
}
