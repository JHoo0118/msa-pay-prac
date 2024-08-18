package com.msa.pay.bankingservice.adapter.out.persistence.external.firmbanking;

import com.msa.pay.bankingservice.application.port.out.GetExternalBankAccountInfoPort;
import com.msa.pay.bankingservice.common.ServiceAdapter;
import com.msa.pay.bankingservice.domain.BankAccount;
import lombok.RequiredArgsConstructor;

@ServiceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingServiceAdapter implements GetExternalBankAccountInfoPort {


    @Override
    public GetExternalBankAccountInfoResponse getExternalBankAccountInfo(BankAccount bankAccount) {
        return null;
    }
}
