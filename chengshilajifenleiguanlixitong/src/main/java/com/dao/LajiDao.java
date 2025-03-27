package com.dao;

import com.entity.LajiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LajiView;

/**
 * 垃圾 Dao 接口
 *
 * @author 
 */
public interface LajiDao extends BaseMapper<LajiEntity> {

   List<LajiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
