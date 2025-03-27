
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 垃圾收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lajiCollection")
public class LajiCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(LajiCollectionController.class);

    private static final String TABLE_NAME = "lajiCollection";

    @Autowired
    private LajiCollectionService lajiCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LajiService lajiService;//垃圾
    @Autowired
    private LajiLiuyanService lajiLiuyanService;//垃圾留言
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhengceService zhengceService;//政策
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = lajiCollectionService.queryPage(params);

        //字典表数据转换
        List<LajiCollectionView> list =(List<LajiCollectionView>)page.getList();
        for(LajiCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LajiCollectionEntity lajiCollection = lajiCollectionService.selectById(id);
        if(lajiCollection !=null){
            //entity转view
            LajiCollectionView view = new LajiCollectionView();
            BeanUtils.copyProperties( lajiCollection , view );//把实体数据重构到view中
            //级联表 垃圾
            //级联表
            LajiEntity laji = lajiService.selectById(lajiCollection.getLajiId());
            if(laji != null){
            BeanUtils.copyProperties( laji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLajiId(laji.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(lajiCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LajiCollectionEntity lajiCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lajiCollection:{}",this.getClass().getName(),lajiCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            lajiCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LajiCollectionEntity> queryWrapper = new EntityWrapper<LajiCollectionEntity>()
            .eq("laji_id", lajiCollection.getLajiId())
            .eq("yonghu_id", lajiCollection.getYonghuId())
            .eq("laji_collection_types", lajiCollection.getLajiCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LajiCollectionEntity lajiCollectionEntity = lajiCollectionService.selectOne(queryWrapper);
        if(lajiCollectionEntity==null){
            lajiCollection.setInsertTime(new Date());
            lajiCollection.setCreateTime(new Date());
            lajiCollectionService.insert(lajiCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LajiCollectionEntity lajiCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,lajiCollection:{}",this.getClass().getName(),lajiCollection.toString());
        LajiCollectionEntity oldLajiCollectionEntity = lajiCollectionService.selectById(lajiCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            lajiCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            lajiCollectionService.updateById(lajiCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LajiCollectionEntity> oldLajiCollectionList =lajiCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        lajiCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LajiCollectionEntity> lajiCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LajiCollectionEntity lajiCollectionEntity = new LajiCollectionEntity();
//                            lajiCollectionEntity.setLajiId(Integer.valueOf(data.get(0)));   //垃圾 要改的
//                            lajiCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            lajiCollectionEntity.setLajiCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            lajiCollectionEntity.setInsertTime(date);//时间
//                            lajiCollectionEntity.setCreateTime(date);//时间
                            lajiCollectionList.add(lajiCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        lajiCollectionService.insertBatch(lajiCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = lajiCollectionService.queryPage(params);

        //字典表数据转换
        List<LajiCollectionView> list =(List<LajiCollectionView>)page.getList();
        for(LajiCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LajiCollectionEntity lajiCollection = lajiCollectionService.selectById(id);
            if(lajiCollection !=null){


                //entity转view
                LajiCollectionView view = new LajiCollectionView();
                BeanUtils.copyProperties( lajiCollection , view );//把实体数据重构到view中

                //级联表
                    LajiEntity laji = lajiService.selectById(lajiCollection.getLajiId());
                if(laji != null){
                    BeanUtils.copyProperties( laji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLajiId(laji.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(lajiCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LajiCollectionEntity lajiCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,lajiCollection:{}",this.getClass().getName(),lajiCollection.toString());
        Wrapper<LajiCollectionEntity> queryWrapper = new EntityWrapper<LajiCollectionEntity>()
            .eq("laji_id", lajiCollection.getLajiId())
            .eq("yonghu_id", lajiCollection.getYonghuId())
            .eq("laji_collection_types", lajiCollection.getLajiCollectionTypes())
//            .notIn("laji_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LajiCollectionEntity lajiCollectionEntity = lajiCollectionService.selectOne(queryWrapper);
        if(lajiCollectionEntity==null){
            lajiCollection.setInsertTime(new Date());
            lajiCollection.setCreateTime(new Date());
        lajiCollectionService.insert(lajiCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

