package com.company.infreastructure.handler.impl;

import com.company.domain.entities.User;

public class ThrottlingHandler extends Handler {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingHandler(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean process(User user) {

        System.out.println("Processing Throttleing...");

        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().interrupt();
        }

        return handleNext(user);
    }

}