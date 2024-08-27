package com.msa.pay.remittanceservice.application.port.out.money;

public interface MoneyPort {

    MoneyInfo getMoneyInfo(String membershipId);
    boolean requestMoneyRecharging(String membershipId, int amount);
    boolean requestMoneyIncrease(String membershipId, int amount);
    boolean requestMoneyDecrease(String membershipId, int amount);
}
