package com.msa.pay.bankingservice.application.port.in;


import com.msa.pay.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
