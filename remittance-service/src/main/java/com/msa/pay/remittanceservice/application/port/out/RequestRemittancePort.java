package com.msa.pay.remittanceservice.application.port.out;

import com.msa.pay.remittanceservice.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.msa.pay.remittanceservice.application.port.in.RequestRemittanceCommand;

public interface RequestRemittancePort {

    RemittanceRequestJpaEntity createRemittanceRequestHistory(RequestRemittanceCommand command);
    boolean saveRemittanceRequestHistory(RemittanceRequestJpaEntity entity);
}
