package edu.hfut.across.backend.controller;

import edu.hfut.across.backend.annotation.UserLoginToken;
import edu.hfut.across.backend.dao.PageMapper;
import edu.hfut.across.backend.dto.user.LoginRequestBean;
import edu.hfut.across.backend.dto.user.LoginResponseBean;
import edu.hfut.across.backend.dto.user.RegisterRequestBean;
import edu.hfut.across.backend.entity.Response;
import edu.hfut.across.backend.entity.User;
import edu.hfut.across.backend.entity.UserResponse;
import edu.hfut.across.backend.service.TokenService;
import edu.hfut.across.backend.service.UserService;
import edu.hfut.across.backend.util.PasswordUtil;
import edu.hfut.across.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    final
    TokenService tokenService;

    final
    UserService userService;

    @Autowired
    public UserController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestBody LoginRequestBean requestBean) {
        String account = requestBean.getAccount();
        String password = requestBean.getPassword();
        User user = userService.login(account, password);
        if (user == null) {
            return ResponseUtil.error("账号或密码错误");
        }
        String token = tokenService.getToken(user);
        user.setPassword(null);
        LoginResponseBean loginResponseBean = new LoginResponseBean();
        UserResponse userResponse = userService.getUserResponses(user);
        loginResponseBean.setUser(userResponse);
        loginResponseBean.setToken(token);
        return ResponseUtil.success("登录成功", loginResponseBean);
    }

    @UserLoginToken
    @PostMapping("/getMessage")
    public Response getMessage() {
        return ResponseUtil.success("获取成功");
    }

    @PostMapping("/register")
    public Response register(@RequestBody RegisterRequestBean registerRequestBean) {
        String email = registerRequestBean.getEmail();
        String plainPassword = registerRequestBean.getPassword();
        String password = PasswordUtil.encode(plainPassword);
        String account = userService.register(email, password);
        if (account != null) {
            return ResponseUtil.success("注册成功！", account);
        } else {
            return ResponseUtil.error("注册失败, 邮箱已经被注册");
        }
    }
}
