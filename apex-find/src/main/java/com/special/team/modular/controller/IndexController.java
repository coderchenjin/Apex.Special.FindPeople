package com.special.team.modular.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.special.team.modular.Service.IndexService;
import com.special.team.modular.constant.Constant;
import com.special.team.modular.constant.ErrorResponseData;
import com.special.team.modular.constant.SuccessResponseData;
import com.special.team.modular.dao.UserMapper;
import com.special.team.modular.dao.WeChatUserMapper;
import com.special.team.modular.model.User;
import com.special.team.modular.model.WeChatUser;
import com.special.team.modular.vo.HotVo;
import com.special.team.modular.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/index")
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IndexService indexService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WeChatUserMapper weChatUserMapper;


    /**
     * 微信授权
     */
    @RequestMapping(value = "/weChatAuthorization")
    @ResponseBody
    public Object weChatAuthorization(String code,String name) {
        List<User> userList = userMapper.selectList(new EntityWrapper<User>().eq("Name", name));
        if(userList!=null&&userList.size()>0){
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + Constant.APP_ID +
                    "&secret=" + Constant.APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
            String packages = HttpUtil.get(url);
            if(packages!=null&&packages!=""){
                JSONObject jo = JSONObject.parseObject(packages);
                if(jo.get("errcode") != null) {
                    logger.info("登录授权失败："+packages);
                    return new ErrorResponseData(500,"failed",jo.get("errmsg"));
                } else {
                    String openid = jo.get("openid").toString();
                    String str= openid.replace("\"", "");
//                    List<WeChatUser> chatUsers = weChatUserMapper.selectList(new EntityWrapper<WeChatUser>().eq("open_id", str));
//                    if(chatUsers==null||chatUsers.size()==0){
//                        WeChatUser wu=new WeChatUser();
//                        wu.setOpenId(str);
//                        weChatUserMapper.insert(wu);
//                    }
                    User user=userList.get(0);
                    if(user.getOpenId()==null||user.getOpenId()==""){
                        user.setOpenId(str);
                        userMapper.updateById(user);
                    }
                    return new SuccessResponseData(200,"success",openid);
                }
            }else{
                logger.info("登录授权失败："+packages);
                return new ErrorResponseData(500,"failed","授权失败");
            }
        }else{
            logger.info("登录授权失败，该用户不存在");
            return new ErrorResponseData(400,"该用户不存在","");
        }

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
     * 搜索
     */
    @RequestMapping(value = "/seach")
    @ResponseBody
    public Object seach(String id) {
        ResultVo vo = indexService.seach(id);
        return new SuccessResponseData(200,"success",vo);
    }



}
