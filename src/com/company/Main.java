package com.company;

import com.company.domain.entities.User;
import com.company.domain.enuns.Role;
import com.company.infreastructure.database.IDatabaseMock;
import com.company.infreastructure.database.impl.DatabaseMock;
import com.company.infreastructure.handler.IHandler;
import com.company.infreastructure.handler.impl.*;
import com.company.infreastructure.repository.IRepository;
import com.company.infreastructure.repository.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static IDatabaseMock db = new DatabaseMock()
            .register("admin@mail.com", "admin")
            .register("user@mail.com", "user");
    private static IRepository repository = new UserRepository(db);

    private Main() {
    }

    public static void main(String[] args) throws IOException {

        System.out.print("Enter email: ");
        String email = reader.readLine();

        System.out.print("Input password: ");
        String password = reader.readLine();

        User user = new User().setEmail(email).setPassword(password).setRole(Role.ADMIN);

        authenticateUserConfigChain().process(user);
    }

    private static IHandler authenticateUserConfigChain() {

        IHandler starterHandler = new StarterHandler();
        IHandler throttlingHandler = new ThrottlingHandler(5);
        IHandler userHandler = new UserHandler(repository);
        IHandler roleHandler = new RoleHandler();

        starterHandler
                .setNext(throttlingHandler)
                .setNext(roleHandler)
                .setNext(userHandler);


        return starterHandler;
    }

}
