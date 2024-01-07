package com.fastcampuspay.application.port.in;

import com.fastcampuspay.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);

}
