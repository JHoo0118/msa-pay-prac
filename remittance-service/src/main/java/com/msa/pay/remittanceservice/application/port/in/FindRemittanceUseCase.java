package com.msa.pay.remittanceservice.application.port.in;


import com.msa.pay.remittanceservice.domain.RemittanceRequest;

import java.util.List;

public interface FindRemittanceUseCase {
    List<RemittanceRequest> findRemittanceHistory(FindRemittanceCommand command);
}
