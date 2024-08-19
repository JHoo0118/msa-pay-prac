package com.msa.pay.bankingservice.application.port.in;


import com.msa.pay.bankingservice.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}