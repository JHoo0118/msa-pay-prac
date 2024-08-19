package com.msa.pay.bankingservice.application.port.out;

import com.msa.pay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.msa.pay.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
