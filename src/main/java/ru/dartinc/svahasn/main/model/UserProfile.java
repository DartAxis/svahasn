package ru.dartinc.svahasn.main.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dartinc.svahasn.security.model.BaseEntity;
import ru.dartinc.svahasn.security.model.User;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserProfile extends BaseEntity {
    //todo дописать отношение
    @OneToOne
    private User userID;

    @Column(name = "birthday")
    private LocalDateTime birthday;


}
