package com.msa.pay.remittanceservice.application.port.out.banking;

import com.msa.pay.remittanceservice.application.port.out.membership.MembershipStatus;

public interface BankingPort {

    BankingInfo getMembershipBankingInfo(String bankName, String bankAccountNumber);

    boolean requestFirmbanking(String bankName, String bankAccountNumber, int amount);
}
