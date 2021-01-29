package com.example.demo.controller;

import com.example.demo.model.ServerResponse;
import com.example.demo.model.entity.ShopEntity;
import com.example.demo.model.req.AddShopReq;
import com.example.demo.service.ShopService;
import com.example.demo.model.vo.ShopVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:06
 */
@RestController
@RequestMapping("shop")
@Api(tags = "商品管理")
public class ShopController {

    @Resource
    private ShopService shopService;

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @PostMapping("/")
    public ServerResponse addShop(@RequestBody @Validated AddShopReq req) {
        shopService.addShop(req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "查询所有商品", notes = "查询所有商品")
    @GetMapping("/")
    public ServerResponse<List<ShopEntity>> getShop() {
        return ServerResponse.ok(shopService.getShop());
    }

    @ApiOperation(value = "根据id查找商品信息", notes = "根据id查找商品信息")
    @GetMapping("/{id}")
    public ServerResponse<ShopVO> addShop(@PathVariable("id") Integer id) {
        return ServerResponse.ok(shopService.getShopInfo(id));
    }

    @ApiOperation(value = "修改商品信息", notes = "修改商品信息")
    @PutMapping("/{id}")
    public ServerResponse updateShop(@PathVariable("id") Integer id, @RequestBody @Validated AddShopReq req) {
        shopService.updateShop(id, req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "删除商品", notes = "删除商品")
    @DeleteMapping("/{id}")
    public ServerResponse<ShopVO> deleteShop(@PathVariable("id") Integer id) {
        shopService.deleteShop(id);
        return ServerResponse.ok();
    }
}
