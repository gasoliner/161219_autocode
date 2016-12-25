package cn.wan.autocode.controller;

import cn.wan.autocode.po.ResultCode;
import cn.wan.autocode.po.User;
import cn.wan.autocode.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 万洪基 on 2016/12/24.
 */
@Controller
public class GetCode {
    @Autowired
    CodeService codeService;

    @RequestMapping("/getcode")
    public String getcode(User user, HttpSession session) throws Exception {

//        test
        System.out.println(user);

        ResultCode resultCode=codeService.getCoreCode(user.getCookie(),user.getUrl());

//        test
        System.out.println(resultCode.getCorecode());

        if (resultCode.getPage()!=0){
            session.setAttribute("codes",resultCode.getCorecode());
            session.setAttribute("page",resultCode.getPage());
        }else{
            session.setAttribute("codes","there is no your codes here!");
            session.setAttribute("page","none");
        }
        return "redirect:index.jsp";
    }
}
