package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LajiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 垃圾
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("laji")
public class LajiView extends LajiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 所属分类的值
	*/
	@ColumnInfo(comment="所属分类的字典表值",type="varchar(200)")
	private String lajiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public LajiView() {

	}

	public LajiView(LajiEntity lajiEntity) {
		try {
			BeanUtils.copyProperties(this, lajiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 所属分类的值
	*/
	public String getLajiValue() {
		return lajiValue;
	}
	/**
	* 设置： 所属分类的值
	*/
	public void setLajiValue(String lajiValue) {
		this.lajiValue = lajiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "LajiView{" +
			", lajiValue=" + lajiValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
