package com.msa.pay.membershipservice.application.service;

import com.msa.pay.membershipservice.common.UseCase;
import lombok.RequiredArgsConstructor;

import com.msa.pay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.msa.pay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.msa.pay.membershipservice.application.port.in.ModifyMembershipCommand;
import com.msa.pay.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.msa.pay.membershipservice.application.port.out.ModifyMembershipPort;
import com.msa.pay.membershipservice.domain.Membership;

import jakarta.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Membership
        return MembershipMapper.mapToDomainEntity(jpaEntity);
    }
}