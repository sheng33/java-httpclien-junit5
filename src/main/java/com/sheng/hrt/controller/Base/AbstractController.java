package com.sheng.hrt.controller.Base;

import com.sheng.hrt.until.RtnData;

import java.util.Map;

public abstract class AbstractController<T, K>{

    /**
     * 新增
     * @param t
     * @return
     */
    public abstract RtnData insert(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    public abstract RtnData update(T t);

    /**
     * 删除
     * @param
     * @return
     */
    public abstract RtnData delete(K id);

    /**
     * 按主键查询
     * @param
     * @return
     */
    public abstract RtnData get(K Id);

    /**
     * 分页查询
     * @return
     */
    public abstract RtnData queryPageList(int pageSize, int pageIndex, Map<String,Object> params);

    /**
     * 多条件查询
     * @return
     */
    public abstract RtnData queryList(Map<String,Object> params);

}