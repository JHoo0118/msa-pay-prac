package com.msa.pay.membershipservice.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.msa.pay.membershipservice.domain.Membership;

@Component
public class MembershipMapper {
	public static Membership mapToDomainEntity(
			MembershipJpaEntity membership) {
		System.out.println(membership.toString());
		return Membership.generateMember(
            new Membership.MembershipId(membership.getMembershipId()+""),
            new Membership.MembershipName(membership.getName()),
            new Membership.MembershipEmail(membership.getEmail()),
            new Membership.MembershipAddress(membership.getAddress()),
            new Membership.MembershipIsValid(membership.isValid()),
            new Membership.MembershipIsCorp(membership.isCorp())
            );
	}
}
