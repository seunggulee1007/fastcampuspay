package com.fastcampuspay.adapter.in.web;

import com.fastcampuspay.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request ~~
        // request -> Command
        // Usecase ~~ (request x, command)
        RegisterMembershipCommand command =
            RegisterMembershipCommand.builder().name(request.getName()).address(request.getAddress()).email(request.getEmail()).valid(true).corp(
                request.isCorp()).build();
        return registerMembershipUseCase.registerMembership(command);
    }

}
