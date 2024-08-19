package com.msa.pay.bankingservice.adapter.in.web;

import com.msa.pay.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.msa.pay.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.msa.pay.bankingservice.common.WebAdapter;
import com.msa.pay.bankingservice.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;
    @PostMapping(path = "/banking/register/account")
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        return registerBankAccountUseCase.registerBankAccount(command);
    }
}
