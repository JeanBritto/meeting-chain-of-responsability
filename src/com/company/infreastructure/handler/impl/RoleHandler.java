package com.company.infreastructure.handler.impl;

import com.company.domain.entities.User;

public class RoleHandler extends Handler {
    @Override
    public boolean process(User user) {

        System.out.println("Processing Role...");

        switch (user.getRole()) {

            case ADMIN:
                System.out.println("Hello, Admin!");
                break;
            case CLIENT:
                System.out.println("Hello, " + user.getEmail());
                break;
            case NONE:
            default:
                System.out.println("You`re not permitted");
                return false;

        }

        return handleNext(user);
    }
}