package com.company.infreastructure.handler.impl;

import com.company.domain.entities.User;
import com.company.infreastructure.handler.IHandler;

public abstract class Handler implements IHandler {
    private IHandler next;

    public IHandler setNext(IHandler nextInChain) {
        next = nextInChain;
        return nextInChain;
    }

    public abstract boolean process(User user);

    public boolean handleNext(User user) {
        if (next == null) {
            return true;
        }
        return next.process(user);
    }
}