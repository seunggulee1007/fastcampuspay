package com.fastcampuspay.adapter.out.persistence;

import com.fastcampuspay.domain.Membership;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String email;
    private boolean valid;
    private boolean corp;

    public static MembershipEntity of(Membership.MembershipName membershipName,
                                      Membership.MembershipEmail membershipEmail,
                                      Membership.MembershipAddress membershipAddress,
                                      Membership.MembershipIsValid membershipIsValid,
                                      Membership.MembershipIsCorp membershipIsCorp) {
        MembershipEntity membershipEntity = new MembershipEntity();
        membershipEntity.name = membershipName.getName();
        membershipEntity.email = membershipEmail.getEmail();
        membershipEntity.address = membershipAddress.getAddress();
        membershipEntity.valid = membershipIsValid.isValidValue();
        membershipEntity.corp = membershipIsCorp.isCorp();
        return membershipEntity;
    }

}
