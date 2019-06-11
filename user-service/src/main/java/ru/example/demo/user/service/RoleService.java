package ru.example.demo.user.service;

import ru.example.demo.user.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<List<Role>> findAllByUserId(Long id);

}
