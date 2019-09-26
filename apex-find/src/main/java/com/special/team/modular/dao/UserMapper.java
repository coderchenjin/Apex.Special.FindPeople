package com.special.team.modular.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.special.team.modular.model.User;
import com.special.team.modular.vo.HotVo;
import com.special.team.modular.vo.ResultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<HotVo> selectHot(@Param("key")String key);

    List<HotVo> selectHot1(@Param("key")String key);

    ResultVo selectUserById(@Param("id")String id);
}
