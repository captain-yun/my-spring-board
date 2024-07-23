package com.kitri.myspringboard2.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String password;
    private String password2;
    private boolean enabled = true;
}
