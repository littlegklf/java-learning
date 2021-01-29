package com.example.demo.service.impl;

import com.example.demo.model.entity.LocationEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.enums.ResponseCode;
import com.example.demo.exceptions.GlobalRuntimeException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.req.AddUserLocationReq;
import com.example.demo.model.req.AddUserReq;
import com.example.demo.service.UserService;
import com.example.demo.model.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * @author kuanglifang
 * @date 2020/12/16 20:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private LocationRepository locationRepository;

    @Override
    public UserVO findById(Integer id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "用户不存在"));
        return new UserVO(entity.getUserName(), entity.getUserPassword(), entity.getSex(),
                entity.getMobile(), entity.getTrueName());
    }

    @Override
    public void addUser(AddUserReq req) {
        UserEntity entity = UserEntity.builder().userName(req.getUserName())
                .userPassword(req.getUserPassword()).sex(req.getSex())
                .mobile(req.getMobile()).trueName(req.getTrueName())
                .build();
        userRepository.save(entity);
    }

    @Override
    public void addUserLocation(Integer userId, AddUserLocationReq req) {
        LocationEntity locationEntity = LocationEntity.builder().locationAddress(req.getLocationAddress())
                .userId(userId).build();
        locationRepository.save(locationEntity);
    }

    @Override
    public UserVO getByUserName(String userName) {
        UserEntity entity = userRepository.findByUserName(userName).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "用户不存在"));
        return UserVO.builder().userName(entity.getUserName()).userPassword(entity.getUserPassword())
                .sex(entity.getSex()).mobile(entity.getMobile()).trueName(entity.getTrueName())
                .build();
    }

    @Override
    public void updateUserInfoById(Integer id, AddUserReq req) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该用户不存在"));
        entity.setMobile(req.getMobile());
        entity.setSex(req.getSex());
        entity.setTrueName(req.getTrueName());
        entity.setUserName(req.getUserName());
        entity.setUserPassword(req.getUserPassword());
        userRepository.save(entity);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该用户不存在"));
        userRepository.deleteById(id);
    }
}
