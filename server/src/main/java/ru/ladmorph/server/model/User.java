package ru.ladmorph.server.model;

import lombok.Data;

@Data
public class User extends BaseEntity {

    private Long id;
    private String username;
    private String password;
    private Long messageCount;
}
