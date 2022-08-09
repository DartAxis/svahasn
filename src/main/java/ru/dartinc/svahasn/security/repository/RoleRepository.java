package ru.dartinc.svahasn.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dartinc.svahasn.security.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
