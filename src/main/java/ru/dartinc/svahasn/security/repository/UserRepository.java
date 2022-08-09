package ru.dartinc.svahasn.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dartinc.svahasn.security.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
