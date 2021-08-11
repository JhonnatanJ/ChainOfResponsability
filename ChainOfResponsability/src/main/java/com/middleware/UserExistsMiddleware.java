package com.middleware;

import com.server.Server;

public class UserExistsMiddleware extends Middleware{
	
	private Server server;

    public UserExistsMiddleware(Server server2) {
        this.server = server2;
    }

	public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
	
}
