package com.green.greengram2.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVo {
    private int feedCnt; //등록한 피드수
    private int favCnt; //등록한 피드에 달린 좋아요수
    private String nm;
    private String pic;
    private String createdAt; //아이디 만든 날짜
}
