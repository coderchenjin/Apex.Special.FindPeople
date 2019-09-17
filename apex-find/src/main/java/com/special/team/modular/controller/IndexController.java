package com.special.team.modular.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.special.team.modular.dao.UserMapper;
import com.special.team.modular.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取待办列表
     */
    @RequestMapping(value = "/hello/{account}")
    @ResponseBody
    public Object hello(@PathVariable String account) {
        List<User> accountList = userMapper.selectList(new EntityWrapper<User>().eq("account", account));
        return accountList.get(0);
    }



}
