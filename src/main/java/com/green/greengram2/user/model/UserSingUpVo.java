package com.green.greengram2.user.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSingUpVo {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private int iuser;

}
