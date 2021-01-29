package com.example.demo.service;

import com.example.demo.model.req.AddUserLocationReq;
import com.example.demo.model.req.AddUserReq;
import com.example.demo.model.vo.UserVO;

/**
 * @author kuanglifang
 * @date 2020/12/16 20:00
 */
public interface UserService {
    /**
     * 通过id查用户信息
     *
     * @param id
     * @return
     */
    UserVO findById(Integer id);

    /**
     * 添加用户
     *
     * @param req
     */
    void addUser(AddUserReq req);

    /**
     * 添加用户地址
     *
     * @param userId
     * @param req
     */
    void addUserLocation(Integer userId, AddUserLocationReq req);

    /**
     * 根据用户名查用户信息
     *
     * @param userName
     * @return
     */
    UserVO getByUserName(String userName);

    /**
     * 修改用户信息
     *
     * @param id
     * @param req
     */
    void updateUserInfoById(Integer id, AddUserReq req);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Integer id);
}
