package com.company.infreastructure.handler.impl;

import com.company.domain.entities.User;
import com.company.infreastructure.repository.IRepository;

public class UserHandler extends Handler {

    private IRepository userRepository;

    public UserHandler(IRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public boolean process(User user) {
        System.out.println("Processing User...");
        if (userRepository.checkUser(user)) {
            return handleNext(user);
        }
        return false;
    }
}
