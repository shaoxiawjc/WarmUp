package com.teamtwo.warmup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamtwo.warmup.pojo.Task;
import com.teamtwo.warmup.dto.TaskSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.mapper
 **/
@Mapper
@Repository
public interface TaskMapper extends BaseMapper<Task> {
	List<TaskSelect> selectAllTask(@Param("userId") Long userId);
}
