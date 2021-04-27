package io.jzheaux.springsecurity.resolutions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity(name="users")
public class User implements Serializable {
    @Id
    UUID id;
    @Column
    String username;
    @Column
    String password;
    @Column
    boolean enabled = true;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    Collection<UserAuthority> userAuthorities = new ArrayList<>();

    User() {}
    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
    }

    public Collection<UserAuthority> getUserAuthorities() {
        return Collections.unmodifiableCollection(this.userAuthorities);
    }
    public void grantAuthority(String authority) {
        UserAuthority userAuthority = new UserAuthority(this, authority);
        this.userAuthorities.add(userAuthority);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserAuthorities(Collection<UserAuthority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }
}
