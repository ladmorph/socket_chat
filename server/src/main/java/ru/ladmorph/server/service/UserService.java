package ru.ladmorph.server.service;

import ru.ladmorph.server.model.User;

/**
 * The user service.
 */
public interface UserService {

    /**
     * Get username from message.
     *
     * @param message from user
     * @return username
     */
    String getUsernameFromMessage(String message);

    /**
     * Save user.
     *
     * @param user the user instance
     */
    void save(User user);

    /**
     * Find user by username.
     *
     * @param username the username
     * @return User
     */
    User findByUsername(String username);
}
