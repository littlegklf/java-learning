package com.example.demo.service.impl;

import com.example.demo.model.entity.ShopEntity;
import com.example.demo.model.enums.ResponseCode;
import com.example.demo.exceptions.GlobalRuntimeException;
import com.example.demo.repository.ShopRepository;
import com.example.demo.model.req.AddShopReq;
import com.example.demo.service.ShopService;
import com.example.demo.model.vo.ShopVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:17
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;

    @Override
    public void addShop(AddShopReq req) {
        ShopEntity entity = ShopEntity.builder().name(req.getName()).count(req.getCount()).price(req.getPrice()).build();
        shopRepository.save(entity);
    }

    @Override
    public ShopVO getShopInfo(Integer id) {
        ShopEntity entity = shopRepository.findById(id).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该商品信息不存在"));
        return new ShopVO(entity.getName(), entity.getPrice(), entity.getCount());
    }

    @Override
    public void updateShop(Integer id, AddShopReq req) {
        ShopEntity entity = shopRepository.findById(id).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该商品不存在"));
        entity.setCount(req.getCount());
        entity.setName(req.getName());
        entity.setPrice(req.getPrice());
        shopRepository.save(entity);
    }

    @Override
    public void deleteShop(Integer id) {
        shopRepository.deleteById(id);
    }

    @Override
    public List<ShopEntity> getShop() {
        return shopRepository.findAll();
    }
}
