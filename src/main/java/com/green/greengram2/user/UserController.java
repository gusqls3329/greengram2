package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSignInDto;
import com.green.greengram2.user.model.UserSignInVo;
import com.green.greengram2.user.model.UserSignupDto;
import com.green.greengram2.user.model.UserSingUpVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResVo postSingUpUser(@RequestBody UserSignupDto dto){
        log.info("dto: {}",dto);
        return new ResVo(service.postSingUpUser(dto));
    }

    @PostMapping("/signin")
    public UserSignInVo userSignin(@RequestBody UserSignInDto dto){
        log.info("dto = {}", dto);
        return service.userSignin(dto);
    }

}
