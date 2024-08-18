package com.msa.pay.membershipservice.application.port.in;

import com.msa.pay.membershipservice.domain.Membership;

public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand command);
}
