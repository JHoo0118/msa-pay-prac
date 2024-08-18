package com.msa.pay.membershipservice.adapter.in.web;


import com.msa.pay.membershipservice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.msa.pay.membershipservice.application.port.in.FindMembershipCommand;
import com.msa.pay.membershipservice.application.port.in.FindMembershipUseCase;
import com.msa.pay.membershipservice.domain.Membership;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;
	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId) {

		FindMembershipCommand command = FindMembershipCommand.builder()
				.membershipId(membershipId)
				.build();
		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
}
