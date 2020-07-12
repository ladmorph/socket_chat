package ru.ladmorph.server.mapper;

import org.apache.ibatis.annotations.Insert;
import ru.ladmorph.server.model.User;

public interface UserMapper {

    @Insert("INSERT INTO users(username, password, message_count, creation_date, updated_date) " +
            "VALUES (#{username}, #{password}, #{message_count}, #{creation_date}, #{updated_date})")
    void save(User user);
}
