package com.fastcampuspay.application.port.in;

import com.fastcampuspay.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
