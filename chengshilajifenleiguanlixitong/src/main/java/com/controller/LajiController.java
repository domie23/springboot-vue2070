
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
 * 垃圾
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laji")
public class LajiController {
    private static final Logger logger = LoggerFactory.getLogger(LajiController.class);

    private static final String TABLE_NAME = "laji";

    @Autowired
    private LajiService lajiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LajiCollectionService lajiCollectionService;//垃圾收藏
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
        params.put("lajiDeleteStart",1);params.put("lajiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = lajiService.queryPage(params);

        //字典表数据转换
        List<LajiView> list =(List<LajiView>)page.getList();
        for(LajiView c:list){
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
        LajiEntity laji = lajiService.selectById(id);
        if(laji !=null){
            //entity转view
            LajiView view = new LajiView();
            BeanUtils.copyProperties( laji , view );//把实体数据重构到view中
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
    public R save(@RequestBody LajiEntity laji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laji:{}",this.getClass().getName(),laji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LajiEntity> queryWrapper = new EntityWrapper<LajiEntity>()
            .eq("laji_name", laji.getLajiName())
            .eq("laji_types", laji.getLajiTypes())
            .eq("shangxia_types", laji.getShangxiaTypes())
            .eq("laji_delete", laji.getLajiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LajiEntity lajiEntity = lajiService.selectOne(queryWrapper);
        if(lajiEntity==null){
            laji.setLajiClicknum(1);
            laji.setShangxiaTypes(1);
            laji.setLajiDelete(1);
            laji.setInsertTime(new Date());
            laji.setCreateTime(new Date());
            lajiService.insert(laji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LajiEntity laji, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,laji:{}",this.getClass().getName(),laji.toString());
        LajiEntity oldLajiEntity = lajiService.selectById(laji.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(laji.getLajiPhoto()) || "null".equals(laji.getLajiPhoto())){
                laji.setLajiPhoto(null);
        }

            lajiService.updateById(laji);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<LajiEntity> oldLajiList =lajiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<LajiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LajiEntity lajiEntity = new LajiEntity();
            lajiEntity.setId(id);
            lajiEntity.setLajiDelete(2);
            list.add(lajiEntity);
        }
        if(list != null && list.size() >0){
            lajiService.updateBatchById(list);
        }

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
            List<LajiEntity> lajiList = new ArrayList<>();//上传的东西
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
                            LajiEntity lajiEntity = new LajiEntity();
//                            lajiEntity.setLajiName(data.get(0));                    //垃圾名称 要改的
//                            lajiEntity.setLajiUuidNumber(data.get(0));                    //垃圾编号 要改的
//                            lajiEntity.setLajiPhoto("");//详情和图片
//                            lajiEntity.setLajiTypes(Integer.valueOf(data.get(0)));   //所属分类 要改的
//                            lajiEntity.setLajiClicknum(Integer.valueOf(data.get(0)));   //词条热度 要改的
//                            lajiEntity.setLajiContent("");//详情和图片
//                            lajiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            lajiEntity.setLajiDelete(1);//逻辑删除字段
//                            lajiEntity.setInsertTime(date);//时间
//                            lajiEntity.setCreateTime(date);//时间
                            lajiList.add(lajiEntity);


                            //把要查询是否重复的字段放入map中
                                //垃圾编号
                                if(seachFields.containsKey("lajiUuidNumber")){
                                    List<String> lajiUuidNumber = seachFields.get("lajiUuidNumber");
                                    lajiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> lajiUuidNumber = new ArrayList<>();
                                    lajiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("lajiUuidNumber",lajiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //垃圾编号
                        List<LajiEntity> lajiEntities_lajiUuidNumber = lajiService.selectList(new EntityWrapper<LajiEntity>().in("laji_uuid_number", seachFields.get("lajiUuidNumber")).eq("laji_delete", 1));
                        if(lajiEntities_lajiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LajiEntity s:lajiEntities_lajiUuidNumber){
                                repeatFields.add(s.getLajiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [垃圾编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        lajiService.insertBatch(lajiList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<LajiView> returnLajiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = lajiCollectionService.queryPage(params1);
        List<LajiCollectionView> collectionViewsList =(List<LajiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(LajiCollectionView collectionView:collectionViewsList){
            Integer lajiTypes = collectionView.getLajiTypes();
            if(typeMap.containsKey(lajiTypes)){
                typeMap.put(lajiTypes,typeMap.get(lajiTypes)+1);
            }else{
                typeMap.put(lajiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("lajiTypes",type);
            PageUtils pageUtils1 = lajiService.queryPage(params2);
            List<LajiView> lajiViewList =(List<LajiView>)pageUtils1.getList();
            returnLajiViewList.addAll(lajiViewList);
            if(returnLajiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = lajiService.queryPage(params);
        if(returnLajiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnLajiViewList.size();//要添加的数量
            List<LajiView> lajiViewList =(List<LajiView>)page.getList();
            for(LajiView lajiView:lajiViewList){
                Boolean addFlag = true;
                for(LajiView returnLajiView:returnLajiViewList){
                    if(returnLajiView.getId().intValue() ==lajiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnLajiViewList.add(lajiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnLajiViewList = returnLajiViewList.subList(0, limit);
        }

        for(LajiView c:returnLajiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnLajiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = lajiService.queryPage(params);

        //字典表数据转换
        List<LajiView> list =(List<LajiView>)page.getList();
        for(LajiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LajiEntity laji = lajiService.selectById(id);
            if(laji !=null){

                //点击数量加1
                laji.setLajiClicknum(laji.getLajiClicknum()+1);
                lajiService.updateById(laji);

                //entity转view
                LajiView view = new LajiView();
                BeanUtils.copyProperties( laji , view );//把实体数据重构到view中

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
    public R add(@RequestBody LajiEntity laji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,laji:{}",this.getClass().getName(),laji.toString());
        Wrapper<LajiEntity> queryWrapper = new EntityWrapper<LajiEntity>()
            .eq("laji_name", laji.getLajiName())
            .eq("laji_uuid_number", laji.getLajiUuidNumber())
            .eq("laji_types", laji.getLajiTypes())
            .eq("laji_clicknum", laji.getLajiClicknum())
            .eq("shangxia_types", laji.getShangxiaTypes())
            .eq("laji_delete", laji.getLajiDelete())
//            .notIn("laji_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LajiEntity lajiEntity = lajiService.selectOne(queryWrapper);
        if(lajiEntity==null){
            laji.setLajiClicknum(1);
            laji.setLajiDelete(1);
            laji.setInsertTime(new Date());
            laji.setCreateTime(new Date());
        lajiService.insert(laji);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

