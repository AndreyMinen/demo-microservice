package ru.example.demo.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.user.model.User;
import ru.example.demo.user.service.RoleService;
import ru.example.demo.user.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final String SQL = "select * from users";
    private final String SQL_BY_LOGIN = "select * from users where login = :login";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<User>> findAll() {
        return Optional.of(
                template.query(SQL, mapper())
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<User>> findAllByLogin(String login) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("login", login);
        return Optional.of(
                template.query(SQL_BY_LOGIN, params, mapper())
        );
    }

    private RowMapper<User> mapper(){
        return (rs, i) -> new User(
                rs.getLong("id"),
                rs.getString("login"),
                roleService.findAllByUserId(rs.getLong("id"))
                        .orElse(new ArrayList<>())
        );
    }

}
