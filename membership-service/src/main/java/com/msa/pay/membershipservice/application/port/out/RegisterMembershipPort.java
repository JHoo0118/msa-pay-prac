package com.msa.pay.membershipservice.application.port.out;

import com.msa.pay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.msa.pay.membershipservice.domain.Membership;

public interface RegisterMembershipPort {

	MembershipJpaEntity createMembership(
			Membership.MembershipName membershipName
			, Membership.MembershipEmail membershipEmail
			, Membership.MembershipAddress membershipAddress
			, Membership.MembershipIsValid membershipIsValid
			, Membership.MembershipIsCorp membershipIsCorp
	);
}
