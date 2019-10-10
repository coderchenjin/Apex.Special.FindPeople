package com.special.team.modular.Service;

import com.special.team.modular.dao.ProjectMapper;
import com.special.team.modular.dao.UserMapper;
import com.special.team.modular.model.Project;
import com.special.team.modular.vo.HotVo;
import com.special.team.modular.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    private final static Logger logger = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProjectMapper projectMapper;

    public List<HotVo>  hotSeach(String key){
        List<HotVo> hotVos = userMapper.selectHot(key);
        List<HotVo> hotVos1 = userMapper.selectHot1(key);
        hotVos.addAll(hotVos1);
        return hotVos;
    }

    public ResultVo seach(String id){
        ResultVo resultVo = userMapper.selectUserById(id);
        List<Project> projects = projectMapper.selectByUserId(id);
        StringBuffer sb=new StringBuffer();
        for (Project project : projects) {
            sb.append(project.getProjectName()+",");
        }
        if(sb.length()>0){
           String s=sb.toString();
            resultVo.setProject(s.substring(0,s.length()-1));
        }
        return resultVo;
    }
}
