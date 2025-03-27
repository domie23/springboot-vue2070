package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhengceEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 政策
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhengce")
public class ZhengceView extends ZhengceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 政策类型的值
	*/
	@ColumnInfo(comment="政策类型的字典表值",type="varchar(200)")
	private String zhengceValue;




	public ZhengceView() {

	}

	public ZhengceView(ZhengceEntity zhengceEntity) {
		try {
			BeanUtils.copyProperties(this, zhengceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 政策类型的值
	*/
	public String getZhengceValue() {
		return zhengceValue;
	}
	/**
	* 设置： 政策类型的值
	*/
	public void setZhengceValue(String zhengceValue) {
		this.zhengceValue = zhengceValue;
	}




	@Override
	public String toString() {
		return "ZhengceView{" +
			", zhengceValue=" + zhengceValue +
			"} " + super.toString();
	}
}
