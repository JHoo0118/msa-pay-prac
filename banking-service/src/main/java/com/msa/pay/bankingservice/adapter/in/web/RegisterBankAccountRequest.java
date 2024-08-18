package com.msa.pay.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {
    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
