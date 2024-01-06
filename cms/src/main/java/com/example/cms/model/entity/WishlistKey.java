package com.example.cms.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class WishlistKey implements  Serializable{

    @Column(name = "shoeId")
    Long shoeId;

    @Column(name = "userName")
    String userName;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(shoeId.hashCode()) + String.valueOf(userName.hashCode());
        return concatString.hashCode();
    }

    public WishlistKey(){}

    public WishlistKey(Long shoeId, String userId){
        this.setShoeId(shoeId);
        this.setUserName(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof WishlistKey))
            return false;
        WishlistKey other = (WishlistKey) o;
        return shoeId.equals(other.shoeId) && userName.equals(other.userName);
    }

}
