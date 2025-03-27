package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LajiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 垃圾收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("laji_collection")
public class LajiCollectionView extends LajiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String lajiCollectionValue;

	//级联表 垃圾
		/**
		* 垃圾名称
		*/

		@ColumnInfo(comment="垃圾名称",type="varchar(200)")
		private String lajiName;
		/**
		* 垃圾编号
		*/

		@ColumnInfo(comment="垃圾编号",type="varchar(200)")
		private String lajiUuidNumber;
		/**
		* 垃圾照片
		*/

		@ColumnInfo(comment="垃圾照片",type="varchar(200)")
		private String lajiPhoto;
		/**
		* 所属分类
		*/
		@ColumnInfo(comment="所属分类",type="int(11)")
		private Integer lajiTypes;
			/**
			* 所属分类的值
			*/
			@ColumnInfo(comment="所属分类的字典表值",type="varchar(200)")
			private String lajiValue;
		/**
		* 词条热度
		*/

		@ColumnInfo(comment="词条热度",type="int(11)")
		private Integer lajiClicknum;
		/**
		* 垃圾介绍
		*/

		@ColumnInfo(comment="垃圾介绍",type="text")
		private String lajiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer lajiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public LajiCollectionView() {

	}

	public LajiCollectionView(LajiCollectionEntity lajiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, lajiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getLajiCollectionValue() {
		return lajiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setLajiCollectionValue(String lajiCollectionValue) {
		this.lajiCollectionValue = lajiCollectionValue;
	}


	//级联表的get和set 垃圾

		/**
		* 获取： 垃圾名称
		*/
		public String getLajiName() {
			return lajiName;
		}
		/**
		* 设置： 垃圾名称
		*/
		public void setLajiName(String lajiName) {
			this.lajiName = lajiName;
		}

		/**
		* 获取： 垃圾编号
		*/
		public String getLajiUuidNumber() {
			return lajiUuidNumber;
		}
		/**
		* 设置： 垃圾编号
		*/
		public void setLajiUuidNumber(String lajiUuidNumber) {
			this.lajiUuidNumber = lajiUuidNumber;
		}

		/**
		* 获取： 垃圾照片
		*/
		public String getLajiPhoto() {
			return lajiPhoto;
		}
		/**
		* 设置： 垃圾照片
		*/
		public void setLajiPhoto(String lajiPhoto) {
			this.lajiPhoto = lajiPhoto;
		}
		/**
		* 获取： 所属分类
		*/
		public Integer getLajiTypes() {
			return lajiTypes;
		}
		/**
		* 设置： 所属分类
		*/
		public void setLajiTypes(Integer lajiTypes) {
			this.lajiTypes = lajiTypes;
		}


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

		/**
		* 获取： 词条热度
		*/
		public Integer getLajiClicknum() {
			return lajiClicknum;
		}
		/**
		* 设置： 词条热度
		*/
		public void setLajiClicknum(Integer lajiClicknum) {
			this.lajiClicknum = lajiClicknum;
		}

		/**
		* 获取： 垃圾介绍
		*/
		public String getLajiContent() {
			return lajiContent;
		}
		/**
		* 设置： 垃圾介绍
		*/
		public void setLajiContent(String lajiContent) {
			this.lajiContent = lajiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getLajiDelete() {
			return lajiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setLajiDelete(Integer lajiDelete) {
			this.lajiDelete = lajiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "LajiCollectionView{" +
			", lajiCollectionValue=" + lajiCollectionValue +
			", lajiName=" + lajiName +
			", lajiUuidNumber=" + lajiUuidNumber +
			", lajiPhoto=" + lajiPhoto +
			", lajiClicknum=" + lajiClicknum +
			", lajiContent=" + lajiContent +
			", lajiDelete=" + lajiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
