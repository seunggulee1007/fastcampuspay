package com.fastcampuspay.adapter.in.web;

import com.fastcampuspay.application.port.in.FindMembershipCommand;
import com.fastcampuspay.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membership")
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("{membershipId}")
    public ResponseEntity<Membership> findMembership(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand.builder().membershipId(membershipId).build();
        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }

}
