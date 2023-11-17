/*package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "wishlists")

public class Wishlist {

    @Id
    @NotEmpty
    private Long wishlistId;

    @OneToOne(mappedBy = "shoeId")
    @JoinColumn(name = "shoes")
    @Nullable
    private Shoe shoe;

    @ManyToOne
    @JoinColumn(name ="users")
    @Nullable
    private User user;







}
*/