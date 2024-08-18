package com.msa.pay.membershipservice.application.port.in;

import com.msa.pay.membershipservice.domain.Membership;

public interface FindMembershipUseCase {

	Membership findMembership(FindMembershipCommand command);
	// Membership findAxonMembership(FindMembershipCommand command);
}
