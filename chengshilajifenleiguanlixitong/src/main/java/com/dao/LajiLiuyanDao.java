package com.dao;

import com.entity.LajiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LajiLiuyanView;

/**
 * 垃圾留言 Dao 接口
 *
 * @author 
 */
public interface LajiLiuyanDao extends BaseMapper<LajiLiuyanEntity> {

   List<LajiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
