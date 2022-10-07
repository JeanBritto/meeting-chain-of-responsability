package com.company.infreastructure.repository;

import com.company.domain.entities.User;
import com.company.infreastructure.database.IDatabaseMock;

public class UserRepository implements IRepository {

    IDatabaseMock database;

    public UserRepository(IDatabaseMock database) {
        this.database = database;
    }

    @Override
    public boolean checkUser(User user) {
        return this.hasEmail(user.getEmail()) && this.isValidPassword(user.getEmail(), user.getPassword());
    }

    private boolean hasEmail(String email) {
        var contains = database.getConnection().containsKey(email);
        if (!contains)
            System.out.println("This email is not registered!");
        return contains;
    }

    private boolean isValidPassword(String email, String password) {
        var matches = database.getConnection().get(email).equals(password);
        if (!matches)
            System.out.println("Something went wrong!");
        return matches;
    }
}