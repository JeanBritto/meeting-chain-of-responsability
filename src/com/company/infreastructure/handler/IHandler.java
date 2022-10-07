package com.company.infreastructure.handler;

import com.company.domain.entities.User;

public interface IHandler {
    boolean process(User user);

    IHandler setNext(IHandler nextInChain);
}
