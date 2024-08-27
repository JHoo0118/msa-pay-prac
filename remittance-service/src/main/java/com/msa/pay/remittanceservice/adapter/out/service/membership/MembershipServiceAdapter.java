package com.msa.pay.remittanceservice.adapter.out.service.membership;

import com.msa.pay.remittanceservice.common.CommonHttpClient;
import com.msa.pay.remittanceservice.common.ExternalSystemAdapter;
import com.msa.pay.remittanceservice.application.port.out.membership.MembershipPort;
import com.msa.pay.remittanceservice.application.port.out.membership.MembershipStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class MembershipServiceAdapter implements MembershipPort {

    private final CommonHttpClient membershipServiceHttpClient;

    @Value("${service.membership.url}")
    private String membershipServiceEndpoint;

    @Override
    public MembershipStatus getMembershipStatus(String membershipId) {

        String buildUrl = String.join("/", this.membershipServiceEndpoint, "membership", membershipId);
        try {
            String jsonResponse = membershipServiceHttpClient.sendGetRequest(buildUrl).body();
            ObjectMapper mapper = new ObjectMapper();

            Membership mem = mapper.readValue(jsonResponse, Membership.class);
            if (mem.isValid()){
                return new MembershipStatus(mem.getMembershipId(), true);
            } else{
                return new MembershipStatus(mem.getMembershipId(), false);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
