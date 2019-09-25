package com.special.team.modular.controller;

import com.special.team.modular.Service.IndexService;
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
