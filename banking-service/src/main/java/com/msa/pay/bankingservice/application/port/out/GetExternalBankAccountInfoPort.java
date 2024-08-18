package com.msa.pay.bankingservice.application.port.out;

import com.msa.pay.bankingservice.adapter.out.persistence.external.firmbanking.GetExternalBankAccountInfoResponse;
import com.msa.pay.bankingservice.domain.BankAccount;

public interface GetExternalBankAccountInfoPort {


    GetExternalBankAccountInfoResponse getExternalBankAccountInfo (BankAccount bankAccount);
}
