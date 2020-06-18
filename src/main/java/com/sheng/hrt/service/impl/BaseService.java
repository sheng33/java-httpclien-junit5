package com.sheng.hrt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.Page;
import com.sheng.hrt.dao.Mapper;
import com.sheng.hrt.service.IService;
import com.sheng.hrt.until.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseService<T,K> implements IService<T,K> {

    @Autowired
    protected Mapper<T, K> mapper;

    private Class<T> modelClass;//当前泛型的真实类型Class

    public BaseService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public Object insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public Object update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public Object delete(K id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T get(K id) {
        System.out.printf("id:"+ id);
        System.out.println(mapper.selectByPrimaryKey(id));
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Object queryPageList(int pageSize, int pageIndex, Map<String, Object> params) {
        PageHelper.startPage(pageIndex, pageSize);
        List<T> sysMenus = mapper.queryPageList(params);
        return new PageInfo<T>(sysMenus);
//        Page page = mapper.queryPageList(params);//Page本身是一个ArrayList对象，转换为json时不会保留分页信息
//        PageInfo pageInfo = page.toPageInfo();//将page转换成pageInfo会保存分页信息返回
//        return new PageModel(pageInfo);
    }

    @Override
    public List<T> findAll() {
        System.out.println('a');
        return mapper.selectALL();
    }

    @Override
    public Object queryList(Map<String, Object> params) {
        return mapper.queryList(params);
    }

}