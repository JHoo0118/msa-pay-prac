package com.msa.pay.bankingservice.application.service;

import com.msa.pay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.msa.pay.bankingservice.adapter.out.persistence.RegisteredBankAccountMapperMapper;
import com.msa.pay.bankingservice.adapter.out.persistence.external.firmbanking.GetExternalBankAccountInfoResponse;
import com.msa.pay.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.msa.pay.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.msa.pay.bankingservice.application.port.out.GetExternalBankAccountInfoPort;
import com.msa.pay.bankingservice.application.port.out.RegisterBankAccountPort;
import com.msa.pay.bankingservice.common.UseCase;
import com.msa.pay.bankingservice.domain.BankAccount;
import com.msa.pay.bankingservice.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;

import jakarta.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapperMapper registerBankAccountMapper;

    private final GetExternalBankAccountInfoPort getExternalBankAccountInfoPort;
    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 1. call external system1 (membership-service)
        // to check if member is valid.
        GetExternalBankAccountInfoResponse resp = getExternalBankAccountInfoPort.getExternalBankAccountInfo(
                BankAccount.generateBankAccount(
                        new BankAccount.BankAccountId("123")
                )
        );


        // 2. call external system2 (firm-banking system)
        // to check if the BankAccount is valid


        // 3. if ok,
        // Register Bank Account
        RegisteredBankAccountJpaEntity jpaEntity = registerBankAccountPort.createRegisteredBankAccount(

        );

        // 4. write result to DB
        // Write History of Registered Bank Account


        // entity -> Membership
        return registerBankAccountMapper.mapToDomainEntity(jpaEntity);
    }

}
