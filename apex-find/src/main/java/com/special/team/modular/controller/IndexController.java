package com.special.team.modular.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.special.team.modular.Service.IndexService;
import com.special.team.modular.constant.Constant;
import com.special.team.modular.constant.SuccessResponseData;
import com.special.team.modular.vo.HotVo;
import com.special.team.modular.vo.ResultVo;
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
    private IndexService indexService;


    /**
     * 微信授权
     */
    @RequestMapping(value = "/weChatAuthorization")
    @ResponseBody
    public Object weChatAuthorization(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + Constant.APP_ID +
                "&secret=" + Constant.APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String packages = HttpUtil.get(url);
        if(packages!=null&&packages!=""){
            JSONObject jo = JSONObject.parseObject(packages);
            if(jo.get("errcode") != null) {
                return "";
            } else {
                String openid = jo.get("openid").toString();
                String str= openid.replace("\"", "");
                return openid;
            }
        }
        return new SuccessResponseData(200,"success",null);
    }

    /**
     * 热搜
     */
    @RequestMapping(value = "/hotSeach")
    @ResponseBody
    public Object hotSeach(String name) {
        List<HotVo> hotVoList = indexService.hotSeach(name);
        return new SuccessResponseData(200,"success",hotVoList);
    }

    /**
     * 热搜
     */
    @RequestMapping(value = "/seach")
    @ResponseBody
    public Object seach(String id) {
        ResultVo vo = indexService.seach(id);
        return new SuccessResponseData(200,"success",vo);
    }



}
