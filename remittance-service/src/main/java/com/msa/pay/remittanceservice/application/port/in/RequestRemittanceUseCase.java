package com.msa.pay.remittanceservice.application.port.in;


import com.msa.pay.remittanceservice.domain.RemittanceRequest;

public interface RequestRemittanceUseCase {
    RemittanceRequest requestRemittance(RequestRemittanceCommand command);
}
