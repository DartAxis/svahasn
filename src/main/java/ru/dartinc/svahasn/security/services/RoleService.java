package ru.dartinc.svahasn.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dartinc.svahasn.security.model.Role;
import ru.dartinc.svahasn.security.repository.RoleRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private RoleRepository repository;

    @Transactional
    public Role getById(Long id) {
        return repository.getById(id);
    }
    @Transactional
    public List<Role> getAll() {
        return repository.findAll();
    }
    @Transactional
    public Role getByName(String name) {
        return repository.findByName(name);
    }
    @Transactional
    public Role add(Role role) {
        return repository.save(role);
    }
    @Transactional
    public Role update(Role role) {
        return repository.save(role);
    }
    @Transactional
    public boolean delete(Role role) {
        try {
            repository.delete(role);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Transactional
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
