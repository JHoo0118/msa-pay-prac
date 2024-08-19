package com.msa.pay.bankingservice.application.port.out;

import com.msa.pay.bankingservice.adapter.out.external.bank.BankAccount;
import com.msa.pay.bankingservice.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request) ;
}