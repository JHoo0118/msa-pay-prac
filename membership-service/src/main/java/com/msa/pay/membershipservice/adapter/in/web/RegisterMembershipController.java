package com.msa.pay.membershipservice.adapter.in.web;

import com.msa.pay.membershipservice.common.WebAdapter;
import org.springframework.web.bind.annotation.RestController;

import com.msa.pay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.msa.pay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.msa.pay.membershipservice.domain.Membership;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@WebAdapter
@Tag(name = "register-membership-controller", description = "일반 사용자 서비스를 위한 컨트롤러입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    // request가 수정되어도
    // requset -> command와
    // Usecase 는 추상화로써 수정되면 안 됨
    @Operation(summary = "Membership Register API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR!!"),
    })
    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return registerMembershipUseCase.registerMembership(command);
    }
    
}
