package com.teamtwo.warmup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamtwo.warmup.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.mapper
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
