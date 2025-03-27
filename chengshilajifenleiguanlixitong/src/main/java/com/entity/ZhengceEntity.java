package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 政策
 *
 * @author 
 * @email
 */
@TableName("zhengce")
public class ZhengceEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhengceEntity() {

	}

	public ZhengceEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 政策名称
     */
    @ColumnInfo(comment="政策名称",type="varchar(200)")
    @TableField(value = "zhengce_name")

    private String zhengceName;


    /**
     * 政策图片
     */
    @ColumnInfo(comment="政策图片",type="varchar(200)")
    @TableField(value = "zhengce_photo")

    private String zhengcePhoto;


    /**
     * 政策类型
     */
    @ColumnInfo(comment="政策类型",type="int(11)")
    @TableField(value = "zhengce_types")

    private Integer zhengceTypes;


    /**
     * 政策发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="政策发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 政策详情
     */
    @ColumnInfo(comment="政策详情",type="text")
    @TableField(value = "zhengce_content")

    private String zhengceContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：政策名称
	 */
    public String getZhengceName() {
        return zhengceName;
    }
    /**
	 * 设置：政策名称
	 */

    public void setZhengceName(String zhengceName) {
        this.zhengceName = zhengceName;
    }
    /**
	 * 获取：政策图片
	 */
    public String getZhengcePhoto() {
        return zhengcePhoto;
    }
    /**
	 * 设置：政策图片
	 */

    public void setZhengcePhoto(String zhengcePhoto) {
        this.zhengcePhoto = zhengcePhoto;
    }
    /**
	 * 获取：政策类型
	 */
    public Integer getZhengceTypes() {
        return zhengceTypes;
    }
    /**
	 * 设置：政策类型
	 */

    public void setZhengceTypes(Integer zhengceTypes) {
        this.zhengceTypes = zhengceTypes;
    }
    /**
	 * 获取：政策发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：政策发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：政策详情
	 */
    public String getZhengceContent() {
        return zhengceContent;
    }
    /**
	 * 设置：政策详情
	 */

    public void setZhengceContent(String zhengceContent) {
        this.zhengceContent = zhengceContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhengce{" +
            ", id=" + id +
            ", zhengceName=" + zhengceName +
            ", zhengcePhoto=" + zhengcePhoto +
            ", zhengceTypes=" + zhengceTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", zhengceContent=" + zhengceContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
