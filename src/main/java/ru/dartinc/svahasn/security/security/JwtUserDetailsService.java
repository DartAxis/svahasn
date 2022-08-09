package ru.dartinc.svahasn.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dartinc.svahasn.security.model.User;
import ru.dartinc.svahasn.security.services.UserService;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User with username :"+username+" not found");
        }

        JwtUser jwtUser = JwtUserFactory.createUser(user);
        log.info("user {} successfully loaded",user.getUsername());
        return jwtUser;
    }
}
