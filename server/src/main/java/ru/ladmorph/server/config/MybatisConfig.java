package ru.ladmorph.server.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import ru.ladmorph.server.mapper.UserMapper;

import javax.sql.DataSource;

public class MybatisConfig {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:ladmorph.db";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String ENVIRONMENT_ID = "Development";

    public static SqlSessionFactory buildSqlSessionFactory() {
        DataSource dataSource =
                new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);

        Environment environment =
                new Environment(ENVIRONMENT_ID, new JdbcTransactionFactory(), dataSource);

        Configuration cfg = new Configuration(environment);
        cfg.addMapper(UserMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(cfg);
    }
}
