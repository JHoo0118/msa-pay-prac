package com.msa.pay.bankingservice.application.port.out;

import com.msa.pay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
    );
}
