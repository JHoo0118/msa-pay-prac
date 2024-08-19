package com.msa.pay.bankingservice.application.port.out;

import com.msa.pay.bankingservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.msa.pay.bankingservice.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}