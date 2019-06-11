package ru.example.demo.user.service;

import ru.example.demo.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<List<User>> findAll();

    Optional<List<User>> findAllByLogin(String login);

}
