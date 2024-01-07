package com.fastcampuspay.application.port.out;

import com.fastcampuspay.adapter.out.persistence.MembershipEntity;
import com.fastcampuspay.domain.Membership;

import java.util.Optional;

public interface FindMembershipPort {

    Optional<MembershipEntity> findMembership(Membership.MembershipId membershipId);

}
