package com.fastcampuspay.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String membershipId;

    private final String name;

    private final String email;

    private final String address;

    private final boolean isValid;

    private final boolean isCorp;

    // membership
    // 오염이 되면 안되는 클래스. 고객 정보. 핵심 도메인.

    public static Membership generateMember(MembershipId memberShipId,
                                            MembershipName membershipName,
                                            MembershipEmail membershipEmail,
                                            MembershipAddress membershipAddress,
                                            MembershipIsValid membershipIsValid,
                                            MembershipIsCorp membershipIsCorp

    ) {
        return new Membership(memberShipId.id,
                              membershipName.name,
                              membershipEmail.email,
                              membershipAddress.address,
                              membershipIsValid.validValue,
                              membershipIsCorp.corp);
    }

    @Value
    public static class MembershipId {

        String id;

        public MembershipId(String value) {
            this.id = value;
        }

    }

    @Value
    public static class MembershipName {

        String name;

        public MembershipName(String value) {
            this.name = value;
        }

    }

    @Value
    public static class MembershipEmail {

        String email;

        public MembershipEmail(String value) {
            this.email = value;
        }

    }

    @Value
    public static class MembershipAddress {

        String address;

        public MembershipAddress(String value) {
            this.address = value;
        }

    }

    @Value
    public static class MembershipIsValid {

        boolean validValue;

        public MembershipIsValid(boolean value) {
            this.validValue = value;
        }

    }

    @Value
    public static class MembershipIsCorp {

        boolean corp;

        public MembershipIsCorp(boolean value) {
            this.corp = value;
        }

    }

}
