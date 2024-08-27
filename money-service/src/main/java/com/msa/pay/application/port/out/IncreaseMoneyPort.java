package com.msa.pay.application.port.out;

import com.msa.pay.adapter.out.persistence.MemberMoneyJpaEntity;
import com.msa.pay.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.msa.pay.domain.MemberMoney;
import com.msa.pay.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MembershipId memberId,
            int increaseMoneyAmount
    );
}
