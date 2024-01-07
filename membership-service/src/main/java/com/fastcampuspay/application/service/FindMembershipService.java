package com.fastcampuspay.application.service;

import com.fastcampuspay.adapter.out.persistence.MembershipEntity;
import com.fastcampuspay.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.application.port.in.FindMembershipCommand;
import com.fastcampuspay.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.application.port.out.FindMembershipPort;
import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        Optional<MembershipEntity> membership = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomain(membership.orElseThrow());
    }

}
