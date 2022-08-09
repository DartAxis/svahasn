package ru.dartinc.svahasn.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dartinc.svahasn.security.model.User;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String status;
    private List<RoleDTO> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.created = user.getCreated();
        this.updated = user.getUpdated();
        this.status = user.getStatus().name();
        List<RoleDTO> list = new ArrayList<>();
        user.getRoles().forEach(role -> list.add(new RoleDTO(role)));
        this.setRoles(list);
    }
}
