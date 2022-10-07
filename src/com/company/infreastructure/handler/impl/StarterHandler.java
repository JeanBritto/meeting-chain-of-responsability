package com.company.infreastructure.handler.impl;

import com.company.domain.entities.User;

public class StarterHandler extends Handler {
    @Override
    public boolean process(User user) {
        return handleNext(user);
    }
}
