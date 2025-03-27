package com.entity.model;

import com.entity.LajiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 垃圾
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LajiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 垃圾名称
     */
    private String lajiName;


    /**
     * 垃圾编号
     */
    private String lajiUuidNumber;


    /**
     * 垃圾照片
     */
    private String lajiPhoto;


    /**
     * 所属分类
     */
    private Integer lajiTypes;


    /**
     * 词条热度
     */
    private Integer lajiClicknum;


    /**
     * 垃圾介绍
     */
    private String lajiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer lajiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
