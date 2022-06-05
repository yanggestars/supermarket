package com.sup.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sup.common.ActiverUser;
import com.sup.common.ResultObj;
import com.sup.common.WebUtils;
import com.sup.entity.User;

import com.sup.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 登陆前端控制器
 * @Author: admin-
 * @Date: 2021/10/13 21:33
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService;
    @RequestMapping("login")
    public ResultObj login(User user, String code, HttpSession session){

        //获得存储在session中的验证码
        String sessionCode = (String) session.getAttribute("code");
//        if (code!=null&&sessionCode.equals(code)){
//            Subject subject = SecurityUtils.getSubject();
//            AuthenticationToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPassword());
//            try {
//                //对用户进行认证登陆
//                subject.login(token);
//                //通过subject获取以认证活动的user
//                ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
//                //将user存储到session中
//                WebUtils.getSession().setAttribute("user",activerUser.getUser());
//
//                return ResultObj.LOGIN_SUCCESS;
//            } catch (AuthenticationException e) {
//                e.printStackTrace();
//                return ResultObj.LOGIN_ERROR_PASS;
//            }
//        }else {
//            return ResultObj.LOGIN_ERROR_CODE;
//        }
        if (code!=null&&sessionCode.equals(code)){

            HashMap<String, Object> map = new HashMap<>();
            QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            queryWrapper.eq("userCode", user.getUserName());
            queryWrapper.eq("userPassword", user.getUserPassword());
            List<User> users =  userService.list(queryWrapper);
            users.forEach(u-> System.out.println(u.toString()));
            if (users != null){
                //将user存储到session中
                WebUtils.getSession().setAttribute("user",user);
                return ResultObj.LOGIN_SUCCESS;
            }else {
                return ResultObj.LOGIN_ERROR_PASS;
            }

        }else {
            return ResultObj.LOGIN_ERROR_CODE;
        }

    }

    /**
     * 得到登陆验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException{
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,5);
        session.setAttribute("code",lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
