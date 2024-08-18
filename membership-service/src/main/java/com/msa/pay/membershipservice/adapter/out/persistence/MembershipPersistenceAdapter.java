package com.msa.pay.membershipservice.adapter.out.persistence;

import com.msa.pay.membershipservice.application.port.out.FindMembershipPort;
import com.msa.pay.membershipservice.application.port.out.ModifyMembershipPort;
import com.msa.pay.membershipservice.application.port.out.RegisterMembershipPort;
import com.msa.pay.membershipservice.common.PersistenceAdapter;
import com.msa.pay.membershipservice.domain.Membership;
import com.msa.pay.membershipservice.domain.Membership.MembershipAddress;
import com.msa.pay.membershipservice.domain.Membership.MembershipEmail;
import com.msa.pay.membershipservice.domain.Membership.MembershipIsCorp;
import com.msa.pay.membershipservice.domain.Membership.MembershipIsValid;
import com.msa.pay.membershipservice.domain.Membership.MembershipName;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {
    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(MembershipName membershipName, MembershipEmail membershipEmail,
            MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
            MembershipIsCorp membershipIsCorp) {
            return membershipRepository.save(
				new MembershipJpaEntity(
                    membershipName.getNameValue(),
                    membershipEmail.getEmailValue(),
                    membershipAddress.getAddressValue(),
                    membershipIsValid.isValidValue(),
                    membershipIsCorp.isCorpValue()
				)
		    );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
     return membershipRepository.findById(Long.parseLong(membershipId.getMembershipId())).get();
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        MembershipJpaEntity entity = membershipRepository.findById(Long.parseLong(membershipId.getMembershipId())).get();
        entity.setName(membershipName.getNameValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setEmail(membershipEmail.getEmailValue());
        entity.setCorp(membershipIsCorp.isCorpValue());
        entity.setValid(membershipIsValid.isValidValue());

        return membershipRepository.save(entity);
    }

}
