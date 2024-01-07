package com.fastcampuspay.application.service;

import com.fastcampuspay.adapter.out.persistence.MembershipEntity;
import com.fastcampuspay.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // command -> DB 통신

        // biz logic -> DB
        // external system
        // port, adapter
        MembershipEntity membershipEntity = registerMembershipPort.createMembership(new Membership.MembershipName(command.getName()),
                                                                                    new Membership.MembershipEmail(command.getEmail()),
                                                                                    new Membership.MembershipAddress(command.getAddress()),
                                                                                    new Membership.MembershipIsValid(command.isValid()),
                                                                                    new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Membership

        return membershipMapper.mapToDomain(membershipEntity);
    }

}
