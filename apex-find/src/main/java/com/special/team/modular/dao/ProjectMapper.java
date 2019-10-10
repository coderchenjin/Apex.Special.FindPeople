package com.special.team.modular.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.special.team.modular.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> selectByUserId(@Param("userId")String userId);
}
