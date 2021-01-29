package com.example.demo.controller;

import com.example.demo.model.ServerResponse;
import com.example.demo.model.req.AddUserLocationReq;
import com.example.demo.model.req.AddUserReq;
import com.example.demo.service.UserService;
import com.example.demo.model.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kuanglifang
 * @date 2020/12/16 19:59
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/")
    public ServerResponse addUser(@RequestBody @Validated AddUserReq req) {
        userService.addUser(req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "添加用户地址", notes = "添加用户地址")
    @PostMapping("/{id}/location")
    public ServerResponse addUserLocation(@PathVariable("id") Integer userId, @RequestBody @Validated AddUserLocationReq req) {
        userService.addUserLocation(userId, req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "根据id查找用户", notes = "根据id查找用户")
    @GetMapping("/{id}")
    public ServerResponse<UserVO> getUserInfo(@PathVariable("id") Integer id) {
        UserVO userVO = userService.findById(id);
        return ServerResponse.ok(userVO);
    }

    @ApiOperation(value = "根据用户名查找用户", notes = "根据用户名查找用户")
    @GetMapping("/get-user-by-name")
    public ServerResponse<UserVO> getUserInfoByName(@RequestParam("userName") String userName) {
        UserVO userVO = userService.getByUserName(userName);
        return ServerResponse.ok(userVO);
    }

    @ApiOperation(value = "修改用户信息", notes = "根据id修改用户信息")
    @PutMapping("/{id}")
    public ServerResponse updateUserInfo(@PathVariable("id") Integer id, @RequestBody @Validated AddUserReq req) {
        userService.updateUserInfoById(id, req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/{id}")
    public ServerResponse deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ServerResponse.ok();
    }
}
