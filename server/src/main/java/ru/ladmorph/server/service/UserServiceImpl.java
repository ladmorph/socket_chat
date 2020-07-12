package ru.ladmorph.server.service;

import ru.ladmorph.server.model.User;

/**
 * Default implementation of user service.
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getUsernameFromMessage(String message) {
        int idx = message.indexOf(':');
        return message.substring(0, idx + 1);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
