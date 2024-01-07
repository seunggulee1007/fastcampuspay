package com.fastcampuspay.application.port.in;

import com.fastcampuspay.common.SelfValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidation<FindMembershipCommand> {

    @NotNull
    private final String membershipId;

    public FindMembershipCommand(String membershipId) {
        this.membershipId = membershipId;
        this.validateSelf();
    }

}
