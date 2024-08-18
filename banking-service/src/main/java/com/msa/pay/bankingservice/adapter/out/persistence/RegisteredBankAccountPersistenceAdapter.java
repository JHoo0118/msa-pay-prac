package com.msa.pay.bankingservice.adapter.out.persistence;

import com.msa.pay.bankingservice.application.port.out.RegisterBankAccountPort;
import com.msa.pay.bankingservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount() {
        return registeredBankAccountRepository.save(
            new RegisteredBankAccountJpaEntity(

            )
        );
    }
}
