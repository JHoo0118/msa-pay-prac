package com.msa.pay.membershipservice.application.service;

import com.msa.pay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.msa.pay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.msa.pay.membershipservice.application.port.in.FindMembershipCommand;
import com.msa.pay.membershipservice.application.port.in.FindMembershipUseCase;
import com.msa.pay.membershipservice.application.port.out.FindMembershipPort;
import com.msa.pay.membershipservice.common.UseCase;
import com.msa.pay.membershipservice.domain.Membership;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

	private final FindMembershipPort FindMembershipPort;

	@Override
	public Membership findMembership(FindMembershipCommand command) {
		MembershipJpaEntity jpaEntity = FindMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return MembershipMapper.mapToDomainEntity(jpaEntity);
	}

}
