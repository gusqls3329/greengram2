package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postSingUpUser(UserSignupDto dto) {
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());

        log.info("hashedPw:{}", hashedPw);
        UserSingUpVo procVo = UserSingUpVo.builder()
                .uid(dto.getUid())
                .upw(hashedPw)
                .nm(dto.getNm())
                .pic(dto.getPic())
                .build();
        int affectedRows = mapper.insUser(procVo);
        if (affectedRows == 0) {
            return 0;
        }

        return procVo.getIuser();
    }

    public UserSignInVo userSignin(UserSignInDto dto) {
        UserSignInProcVo procVo = mapper.selUser(dto.getUid());
        UserSignInVo vo = new UserSignInVo();
        if (procVo == null) {
            vo.setResult(2);
            return vo;
        }

        String savedPw = procVo.getUpw();
        boolean compared = BCrypt.checkpw(dto.getUpw(), savedPw);
        if (compared) {
            vo.setResult(1);
            vo.setIuser(procVo.getIuser());
            vo.setNm(procVo.getNm());
            vo.setPic(procVo.getPic());
        } else {
            vo.setResult(3);
        }
        return vo;
    }

}
