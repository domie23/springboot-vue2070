package com.entity.vo;

import com.entity.LajiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 垃圾
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laji")
public class LajiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 垃圾名称
     */

    @TableField(value = "laji_name")
    private String lajiName;


    /**
     * 垃圾编号
     */

    @TableField(value = "laji_uuid_number")
    private String lajiUuidNumber;


    /**
     * 垃圾照片
     */

    @TableField(value = "laji_photo")
    private String lajiPhoto;


    /**
     * 所属分类
     */

    @TableField(value = "laji_types")
    private Integer lajiTypes;


    /**
     * 词条热度
     */

    @TableField(value = "laji_clicknum")
    private Integer lajiClicknum;


    /**
     * 垃圾介绍
     */

    @TableField(value = "laji_content")
    private String lajiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "laji_delete")
    private Integer lajiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：垃圾名称
	 */
    public String getLajiName() {
        return lajiName;
    }


    /**
	 * 获取：垃圾名称
	 */

    public void setLajiName(String lajiName) {
        this.lajiName = lajiName;
    }
    /**
	 * 设置：垃圾编号
	 */
    public String getLajiUuidNumber() {
        return lajiUuidNumber;
    }


    /**
	 * 获取：垃圾编号
	 */

    public void setLajiUuidNumber(String lajiUuidNumber) {
        this.lajiUuidNumber = lajiUuidNumber;
    }
    /**
	 * 设置：垃圾照片
	 */
    public String getLajiPhoto() {
        return lajiPhoto;
    }


    /**
	 * 获取：垃圾照片
	 */

    public void setLajiPhoto(String lajiPhoto) {
        this.lajiPhoto = lajiPhoto;
    }
    /**
	 * 设置：所属分类
	 */
    public Integer getLajiTypes() {
        return lajiTypes;
    }


    /**
	 * 获取：所属分类
	 */

    public void setLajiTypes(Integer lajiTypes) {
        this.lajiTypes = lajiTypes;
    }
    /**
	 * 设置：词条热度
	 */
    public Integer getLajiClicknum() {
        return lajiClicknum;
    }


    /**
	 * 获取：词条热度
	 */

    public void setLajiClicknum(Integer lajiClicknum) {
        this.lajiClicknum = lajiClicknum;
    }
    /**
	 * 设置：垃圾介绍
	 */
    public String getLajiContent() {
        return lajiContent;
    }


    /**
	 * 获取：垃圾介绍
	 */

    public void setLajiContent(String lajiContent) {
        this.lajiContent = lajiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLajiDelete() {
        return lajiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLajiDelete(Integer lajiDelete) {
        this.lajiDelete = lajiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
