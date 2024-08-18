package com.msa.pay.membershipservice.application.service;

import com.msa.pay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.msa.pay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.msa.pay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.msa.pay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.msa.pay.membershipservice.application.port.out.RegisterMembershipPort;
import com.msa.pay.membershipservice.common.UseCase;
import com.msa.pay.membershipservice.domain.Membership;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
            new Membership.MembershipName(command.getName()),
            new Membership.MembershipEmail(command.getEmail()),
            new Membership.MembershipAddress(command.getAddress()),
            new Membership.MembershipIsValid(command.isValid()),
            new Membership.MembershipIsCorp(command.isCorp()
            )
        );
        return MembershipMapper.mapToDomainEntity(jpaEntity);
    }
}
