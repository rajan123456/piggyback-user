package com.incentives.piggyback.user.util;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public enum Roles {

    PIGGY_ADMIN,
    PIGGY_USER,
    PARTNER_ADMIN,
    PARTNER_USER,
    PARTNER_API_USER;

    private static final List<Roles> rolesList = new ArrayList<>();

    static {
        rolesList.addAll(Arrays.asList(Roles.values()));
    }

    public static final List<Roles> getAllRoles(){
        return rolesList;
    }

}