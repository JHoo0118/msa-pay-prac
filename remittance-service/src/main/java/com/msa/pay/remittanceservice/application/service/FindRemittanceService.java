package com.msa.pay.remittanceservice.application.service;

import com.msa.pay.remittanceservice.common.UseCase;
import com.msa.pay.remittanceservice.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.msa.pay.remittanceservice.adapter.out.persistence.RemittanceRequestMapper;
import com.msa.pay.remittanceservice.application.port.in.FindRemittanceCommand;
import com.msa.pay.remittanceservice.application.port.in.FindRemittanceUseCase;
import com.msa.pay.remittanceservice.application.port.in.RequestRemittanceCommand;
import com.msa.pay.remittanceservice.application.port.in.RequestRemittanceUseCase;
import com.msa.pay.remittanceservice.application.port.out.FindRemittancePort;
import com.msa.pay.remittanceservice.application.port.out.RequestRemittancePort;
import com.msa.pay.remittanceservice.application.port.out.banking.BankingPort;
import com.msa.pay.remittanceservice.application.port.out.membership.MembershipPort;
import com.msa.pay.remittanceservice.application.port.out.membership.MembershipStatus;
import com.msa.pay.remittanceservice.application.port.out.money.MoneyInfo;
import com.msa.pay.remittanceservice.application.port.out.money.MoneyPort;
import com.msa.pay.remittanceservice.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;

import jakarta.transaction.Transactional;
import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindRemittanceService implements FindRemittanceUseCase {
    private final FindRemittancePort findRemittancePort;
    private final RemittanceRequestMapper mapper;

    @Override
    public List<RemittanceRequest> findRemittanceHistory(FindRemittanceCommand command) {
        //
        findRemittancePort.findRemittanceHistory(command);
        return null;
    }
}
