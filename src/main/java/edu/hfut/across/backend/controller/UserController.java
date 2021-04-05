package edu.hfut.across.backend.controller;

import edu.hfut.across.backend.annotation.UserLoginToken;
import edu.hfut.across.backend.dto.LoginRequestBean;
import edu.hfut.across.backend.dto.LoginResponseBean;
import edu.hfut.across.backend.dto.RegisterRequestBean;
import edu.hfut.across.backend.entity.Response;
import edu.hfut.across.backend.entity.User;
import edu.hfut.across.backend.service.TokenService;
import edu.hfut.across.backend.service.UserService;
import edu.hfut.across.backend.util.PasswordUtil;
import edu.hfut.across.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginRequestBean requestBean) {
        User user = new User();
        user.setAccount(requestBean.getAccount());
        user.setPassword(requestBean.getPassword());
        String token = tokenService.getToken(user);
        LoginResponseBean loginResponseBean = new LoginResponseBean();
        loginResponseBean.setUser(user);
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
        String account = userService.register(email,password);
        if (account != null) {
            return ResponseUtil.success("注册成功！", account);
        } else {
            return ResponseUtil.error("注册失败");
        }
    }
}
