package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "유저 API", description = "인증 관련") // Swagger의 설명
public class UserController {
    private final UserService service;
    @Operation(summary = "회원가입", description = "회원가입 처리")
    @Parameters(value = {
            @Parameter(name = "uid", description = "아이디")
            , @Parameter(name = "upw", description = "비밀번호")
            , @Parameter(name = "nm", description = "이름")
            , @Parameter(name = "pic", description = "프로필 사진")

    })
    @PostMapping("/signup")
    public ResVo postSingUpUser(@RequestBody UserSignupDto dto){
        log.info("dto: {}",dto);
        return new ResVo(service.postSingUpUser(dto));
    }
    @Operation(summary = "인증", description = "아이디/비번을 활용한 인증처리")
    @PostMapping("/signin") // @Parameters가독성이 높지만, 만약 uid를  @Parameters에 넣지 않으면 사용을 하지 못함
    @Parameters(value = {
            @Parameter(name = "uid", description = "아이디")
            , @Parameter(name = "upw", description = "비밀번호")
    })
    public UserSignInVo userSignin(@RequestBody UserSignInDto dto){
        log.info("dto = {}", dto);
        return service.userSignin(dto);
    }
    @GetMapping
    public UserInfoVo getUserInfo(@RequestParam(value = "target_iuser" ) int targetIuser){
        /*방법1 (위코드): 속성등을 더 주고 싶을때 사용 뒤에 defaultValue = 기본값을 줌(값이 들어오지 않을때: required가 false일때만 defaultValue을 사용가능하고
                        ture일때는 무조건 값을 줘야한다.
        방법2 (@RequestParam("target_iuser") : 이름만 바꿀때 */
        log.info("targetIuser ={}",targetIuser);
        return service.getUserInfo(targetIuser);
    }
    @PatchMapping("/pic")
    public ResVo patchUserPic(@RequestBody UserPatchPicDto dto){
        int result = service.patchUserPic(dto);
        log.info("dto ={}",dto);
        return new ResVo(result);
    }
}
