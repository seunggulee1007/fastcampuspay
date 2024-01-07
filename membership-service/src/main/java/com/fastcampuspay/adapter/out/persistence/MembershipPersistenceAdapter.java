package com.fastcampuspay.adapter.out.persistence;

import com.fastcampuspay.application.port.out.FindMembershipPort;
import com.fastcampuspay.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository springDataMembershipRepository;

    @Override
    public MembershipEntity createMembership(Membership.MembershipName membershipName,
                                             Membership.MembershipEmail membershipEmail,
                                             Membership.MembershipAddress membershipAddress,
                                             Membership.MembershipIsValid membershipIsValid,
                                             Membership.MembershipIsCorp membershipIsCorp) {

        return springDataMembershipRepository.save(MembershipEntity.of(membershipName,
                                                                       membershipEmail,
                                                                       membershipAddress,
                                                                       membershipIsValid,
                                                                       membershipIsCorp));

    }

    @Override
    public Optional<MembershipEntity> findMembership(Membership.MembershipId membershipId) {
        return springDataMembershipRepository.findById(Long.parseLong(membershipId.getId()));
    }

}
