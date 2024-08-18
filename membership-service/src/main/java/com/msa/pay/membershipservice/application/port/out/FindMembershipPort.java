package com.msa.pay.membershipservice.application.port.out;

import com.msa.pay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.msa.pay.membershipservice.domain.Membership;

public interface FindMembershipPort {

	MembershipJpaEntity findMembership(
        Membership.MembershipId membershipId
	);
}
