package com.msa.pay.membershipservice.application.port.in;

import com.msa.pay.membershipservice.domain.Membership;


public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
