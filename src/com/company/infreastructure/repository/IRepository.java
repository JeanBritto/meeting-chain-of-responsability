package com.company.infreastructure.repository;

import com.company.domain.entities.User;

public interface IRepository {
    boolean checkUser(User user);
}
