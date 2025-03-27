package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.ZhengceDao;
import com.entity.ZhengceEntity;
import com.service.ZhengceService;
import com.entity.view.ZhengceView;

/**
 * 政策 服务实现类
 */
@Service("zhengceService")
@Transactional
public class ZhengceServiceImpl extends ServiceImpl<ZhengceDao, ZhengceEntity> implements ZhengceService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ZhengceView> page =new Query<ZhengceView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
