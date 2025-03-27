package com.dao;

import com.entity.LajiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LajiCollectionView;

/**
 * 垃圾收藏 Dao 接口
 *
 * @author 
 */
public interface LajiCollectionDao extends BaseMapper<LajiCollectionEntity> {

   List<LajiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
