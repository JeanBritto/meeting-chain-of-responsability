package com.company.infreastructure.database.impl;

import com.company.infreastructure.database.IDatabaseMock;

import java.util.HashMap;
import java.util.Map;

public class DatabaseMock implements IDatabaseMock {
    private Map<String, String> users = new HashMap<>();

    @Override
    public DatabaseMock register(String email, String password) {
        users.put(email, password);
        return this;
    }

    @Override
    public Map<String, String> getConnection() {
        return this.users;
    }
}
