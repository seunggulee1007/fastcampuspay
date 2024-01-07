package com.fastcampuspay.application.port.in;

import com.fastcampuspay.common.SelfValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidation<RegisterMembershipCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    @NotBlank
    private final String address;

    @AssertTrue
    private final boolean valid;
    
    private final boolean corp;

    public RegisterMembershipCommand(String name, String email, String address, boolean valid, boolean corp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.valid = valid;
        this.corp = corp;
        this.validateSelf();
    }

}
