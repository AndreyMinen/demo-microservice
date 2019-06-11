package ru.example.demo.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.user.model.Role;
import ru.example.demo.user.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final String SQL = "select role.id, role.name from users user\n" +
            "inner join users_roles ur on ur.user_id = user.id\n" +
            "inner join roles role on ur.role_id = role.id\n" +
            "where user.id = :id";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Role>> findAllByUserId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return Optional.of(
                template.query(SQL, params, mapper())
        );
    }

    private RowMapper<Role> mapper(){
        return (rs, i) -> new Role(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

}
