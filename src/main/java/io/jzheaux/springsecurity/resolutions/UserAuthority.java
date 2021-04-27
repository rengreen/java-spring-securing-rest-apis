package io.jzheaux.springsecurity.resolutions;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="authorities")
public class UserAuthority {
    @Id
    UUID id;
    @Column
    String authority;

    @JoinColumn(name="username", referencedColumnName="username")
    @ManyToOne
    User user;

    UserAuthority() {}
    public UserAuthority(User user, String authority) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.authority = authority;
    }
}
