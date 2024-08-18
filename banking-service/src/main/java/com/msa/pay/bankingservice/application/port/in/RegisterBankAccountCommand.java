package com.msa.pay.bankingservice.application.port.in;

import com.msa.pay.bankingservice.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    @NotBlank
    private final String address;

    @AssertTrue
    private final boolean isValid;

    private final boolean isCorp;

    public RegisterBankAccountCommand(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
