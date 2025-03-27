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
 * 垃圾
 *
 * @author 
 * @email
 */
@TableName("laji")
public class LajiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LajiEntity() {

	}

	public LajiEntity(T t) {
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
     * 垃圾名称
     */
    @ColumnInfo(comment="垃圾名称",type="varchar(200)")
    @TableField(value = "laji_name")

    private String lajiName;


    /**
     * 垃圾编号
     */
    @ColumnInfo(comment="垃圾编号",type="varchar(200)")
    @TableField(value = "laji_uuid_number")

    private String lajiUuidNumber;


    /**
     * 垃圾照片
     */
    @ColumnInfo(comment="垃圾照片",type="varchar(200)")
    @TableField(value = "laji_photo")

    private String lajiPhoto;


    /**
     * 所属分类
     */
    @ColumnInfo(comment="所属分类",type="int(11)")
    @TableField(value = "laji_types")

    private Integer lajiTypes;


    /**
     * 词条热度
     */
    @ColumnInfo(comment="词条热度",type="int(11)")
    @TableField(value = "laji_clicknum")

    private Integer lajiClicknum;


    /**
     * 垃圾介绍
     */
    @ColumnInfo(comment="垃圾介绍",type="text")
    @TableField(value = "laji_content")

    private String lajiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "laji_delete")

    private Integer lajiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：垃圾名称
	 */
    public String getLajiName() {
        return lajiName;
    }
    /**
	 * 设置：垃圾名称
	 */

    public void setLajiName(String lajiName) {
        this.lajiName = lajiName;
    }
    /**
	 * 获取：垃圾编号
	 */
    public String getLajiUuidNumber() {
        return lajiUuidNumber;
    }
    /**
	 * 设置：垃圾编号
	 */

    public void setLajiUuidNumber(String lajiUuidNumber) {
        this.lajiUuidNumber = lajiUuidNumber;
    }
    /**
	 * 获取：垃圾照片
	 */
    public String getLajiPhoto() {
        return lajiPhoto;
    }
    /**
	 * 设置：垃圾照片
	 */

    public void setLajiPhoto(String lajiPhoto) {
        this.lajiPhoto = lajiPhoto;
    }
    /**
	 * 获取：所属分类
	 */
    public Integer getLajiTypes() {
        return lajiTypes;
    }
    /**
	 * 设置：所属分类
	 */

    public void setLajiTypes(Integer lajiTypes) {
        this.lajiTypes = lajiTypes;
    }
    /**
	 * 获取：词条热度
	 */
    public Integer getLajiClicknum() {
        return lajiClicknum;
    }
    /**
	 * 设置：词条热度
	 */

    public void setLajiClicknum(Integer lajiClicknum) {
        this.lajiClicknum = lajiClicknum;
    }
    /**
	 * 获取：垃圾介绍
	 */
    public String getLajiContent() {
        return lajiContent;
    }
    /**
	 * 设置：垃圾介绍
	 */

    public void setLajiContent(String lajiContent) {
        this.lajiContent = lajiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLajiDelete() {
        return lajiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLajiDelete(Integer lajiDelete) {
        this.lajiDelete = lajiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Laji{" +
            ", id=" + id +
            ", lajiName=" + lajiName +
            ", lajiUuidNumber=" + lajiUuidNumber +
            ", lajiPhoto=" + lajiPhoto +
            ", lajiTypes=" + lajiTypes +
            ", lajiClicknum=" + lajiClicknum +
            ", lajiContent=" + lajiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", lajiDelete=" + lajiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
