package com.msa.pay.remittanceservice.application.port.out;

import com.msa.pay.remittanceservice.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.msa.pay.remittanceservice.application.port.in.FindRemittanceCommand;

import java.util.List;

public interface FindRemittancePort {

    List<RemittanceRequestJpaEntity> findRemittanceHistory(FindRemittanceCommand command);
}
