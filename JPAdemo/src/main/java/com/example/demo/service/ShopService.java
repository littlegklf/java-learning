package com.example.demo.service;

import com.example.demo.model.entity.ShopEntity;
import com.example.demo.model.req.AddShopReq;
import com.example.demo.model.vo.ShopVO;

import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:16
 */
public interface ShopService {
    /**
     * 添加商品信息
     *
     * @param req
     */
    void addShop(AddShopReq req);

    /**
     * 查询所有商品
     *
     * @return
     */
    List<ShopEntity> getShop();

    /**
     * 根据id查找商品信息
     *
     * @param id
     * @return
     */
    ShopVO getShopInfo(Integer id);

    /**
     * 修改商品信息
     *
     * @param id
     * @param req
     */
    void updateShop(Integer id, AddShopReq req);

    /**
     * 删除商品
     *
     * @param id
     */
    void deleteShop(Integer id);
}
