package com.green.greengram2.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
public class UserSignInDto {
    private String uid;
    private String upw;
}
