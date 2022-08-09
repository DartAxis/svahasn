package ru.dartinc.svahasn.security.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dartinc.svahasn.security.dto.UserDTO;
import ru.dartinc.svahasn.security.model.Role;
import ru.dartinc.svahasn.security.model.Status;
import ru.dartinc.svahasn.security.model.User;
import ru.dartinc.svahasn.security.repository.RoleRepository;
import ru.dartinc.svahasn.security.repository.UserRepository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User getByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if(user != null) {
            log.info("User whit username {} found. ", userName);
        } else {
            log.warn("User whit username {} not found. ", userName);
        }
        return user;
    }

    @Transactional
    public User add(User user) {
        Role role = roleRepository.findByName("ROLE_SVUI_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        User registerUser = userRepository.save(user);
        log.info("Добавлен пользователь: {}", registerUser.getUsername());
        return registerUser;
    }

    @Transactional
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        User updateUser = userRepository.save(user);
        log.info("Добавлен пользователь: {}", updateUser.getUsername());
        return updateUser;
    }

    @Transactional
    public boolean delete(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<UserDTO> getAllFront(){
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
