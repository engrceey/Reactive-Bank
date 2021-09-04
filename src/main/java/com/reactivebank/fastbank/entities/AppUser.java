package com.reactivebank.fastbank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table("AppUser")
@Data
public class AppUser implements Persistable<Boolean> {
    @Id
    @Column("userId")
    private Long userId;
    @Column("firstName")
    private String firstName;
    @Column("lastName")
    private String lastName;
    @Column("email")
    private String email;
    @Column("phoneNumber")
    private String phoneNumber;
    @Column("role")
    private String role;

    @Transient
    private boolean newAppUser;

    @Override
    public Boolean getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return this.newAppUser || userId == null;
    }

    public AppUser setAsNew(){
        this.newAppUser = true;
        return this;
    }
}
