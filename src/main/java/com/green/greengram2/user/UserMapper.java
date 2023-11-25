package com.green.greengram2.user;

import com.green.greengram2.user.model.UserInfoVo;
import com.green.greengram2.user.model.UserPatchPicDto;
import com.green.greengram2.user.model.UserSignInProcVo;
import com.green.greengram2.user.model.UserSingUpVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSingUpVo dto);
    UserSignInProcVo selUser(String uid);
    UserInfoVo selUserInfo(int targetIuser);
    int upUserPic(UserPatchPicDto dto);
}
