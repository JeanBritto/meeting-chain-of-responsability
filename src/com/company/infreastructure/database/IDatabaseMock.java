package com.company.infreastructure.database;

import com.company.infreastructure.database.impl.DatabaseMock;

import java.util.Map;

public interface IDatabaseMock {

    DatabaseMock register(String email, String password);

    Map<String, String> getConnection();
}
