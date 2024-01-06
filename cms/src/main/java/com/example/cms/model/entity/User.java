package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @NotEmpty
    private String userName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    private boolean loggedIn;

   /* @OneToMany(mappedBy = "user")
      @Nullable
   /* private List<Wishlist> wishlist = new ArrayList<>(); */

   public User (String userName, String email, String password, boolean loggedIn) {
       this.userName=userName;
       this.email=email;
       this.password=password;
       this.loggedIn=loggedIn;
   }

}
