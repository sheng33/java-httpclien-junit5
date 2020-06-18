package com.sheng.hrt.controller.api.Base;

import com.sheng.hrt.until.RtnData;
import org.springframework.ui.Model;

import java.util.Map;

public abstract class AbstractController<T, K>{

    /**
     * 新增
     * @param t
     * @return
     */
    public abstract RtnData insert(T t, Model model);

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
    public abstract RtnData queryPageList(int pageSize, int pageIndex, Map<String,Object> params, Model model);

    /**
     * 多条件查询
     * @return
     */
    public abstract RtnData queryList(Map<String,Object> params, Model model);

}