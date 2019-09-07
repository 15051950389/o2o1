package cn.azzhu.o2o.controller;


import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.entity.LogLogin;
import cn.azzhu.o2o.entity.PersonInfo;
import cn.azzhu.o2o.service.LocalAuthService;
import cn.azzhu.o2o.service.LogLoginService;
import cn.azzhu.o2o.service.PersonInfoService;
import cn.azzhu.o2o.utils.SysConstants;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("shop")
public class LoaclAuthController {

    @Autowired
    private LocalAuthService localAuthService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private LogLoginService logLoginService;

    //初始页面
    @GetMapping("login.html")
    public String toLogin() {
        return "login";
    }

    //跳转到注册
    @GetMapping("register.html")
    public String toRegister() {
        return "register";
    }



    //跳转到主页
    @PostMapping("login")
    public String login(LocalAuth localAuth, HttpSession session, String code) {
        LocalAuth loginUser = localAuthService.login(localAuth);
        //加入验证码
        String sessCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //一次性验证码，使用完后移除
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);



        if (code.equalsIgnoreCase(sessCode)) {
            if (loginUser != null) {
                //查询出personinfo的信息
                PersonInfo personInfo = new PersonInfo();
                personInfo.setUserId(loginUser.getUserId());
                personInfo = personInfoService.getPersonInfo(personInfo);

                //传到session域中
                session.setAttribute(SysConstants.PERSON_INFO, personInfo);
                session.setAttribute(SysConstants.SESSION_USER, loginUser);

                //登陆日志表插入顺序
                LogLogin logLogin = new LogLogin();
                logLogin.setLoginname(loginUser.getUserName() + "-" + personInfo.getName());
                logLogin.setLoginip("");
                logLogin.setLogintime(new Date());
                logLoginService.addLoginfo(logLogin);
                return "index";
            } else {
                return "redirect:login.html";
            }
        }else {
            return "redirect:login.html";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
}


