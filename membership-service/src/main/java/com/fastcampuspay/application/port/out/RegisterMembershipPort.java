package com.fastcampuspay.application.port.out;

import com.fastcampuspay.adapter.out.persistence.MembershipEntity;
import com.fastcampuspay.domain.Membership;

public interface RegisterMembershipPort {

    MembershipEntity createMembership(
        Membership.MembershipName membershipName,
        Membership.MembershipEmail membershipEmail,
        Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid,
        Membership.MembershipIsCorp membershipIsCorp
    );

}
