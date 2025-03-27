package com.dao;

import com.entity.ZhengceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengceView;

/**
 * 政策 Dao 接口
 *
 * @author 
 */
public interface ZhengceDao extends BaseMapper<ZhengceEntity> {

   List<ZhengceView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
