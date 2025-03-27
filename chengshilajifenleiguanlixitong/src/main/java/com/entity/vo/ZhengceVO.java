package com.entity.vo;

import com.entity.ZhengceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 政策
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhengce")
public class ZhengceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 政策名称
     */

    @TableField(value = "zhengce_name")
    private String zhengceName;


    /**
     * 政策图片
     */

    @TableField(value = "zhengce_photo")
    private String zhengcePhoto;


    /**
     * 政策类型
     */

    @TableField(value = "zhengce_types")
    private Integer zhengceTypes;


    /**
     * 政策发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 政策详情
     */

    @TableField(value = "zhengce_content")
    private String zhengceContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：政策名称
	 */
    public String getZhengceName() {
        return zhengceName;
    }


    /**
	 * 获取：政策名称
	 */

    public void setZhengceName(String zhengceName) {
        this.zhengceName = zhengceName;
    }
    /**
	 * 设置：政策图片
	 */
    public String getZhengcePhoto() {
        return zhengcePhoto;
    }


    /**
	 * 获取：政策图片
	 */

    public void setZhengcePhoto(String zhengcePhoto) {
        this.zhengcePhoto = zhengcePhoto;
    }
    /**
	 * 设置：政策类型
	 */
    public Integer getZhengceTypes() {
        return zhengceTypes;
    }


    /**
	 * 获取：政策类型
	 */

    public void setZhengceTypes(Integer zhengceTypes) {
        this.zhengceTypes = zhengceTypes;
    }
    /**
	 * 设置：政策发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：政策发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：政策详情
	 */
    public String getZhengceContent() {
        return zhengceContent;
    }


    /**
	 * 获取：政策详情
	 */

    public void setZhengceContent(String zhengceContent) {
        this.zhengceContent = zhengceContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
