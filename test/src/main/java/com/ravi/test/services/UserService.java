package com.ravi.test.services;

import com.ravi.test.data.model.User;
import com.ravi.test.data.repository.UserRepository;
import com.ravi.test.pojo.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void updateUser(String userId, UserRequest userRequest){
        List<User> userList = userRepository.findAll();
        User user = userRepository.findByUserId(userId);
        if(userList.isEmpty()) {
            User temp = userRequest.convertToUser(userId);
            userRepository.save(temp);
        }else{
            Long sid = user.getSid();
            User temp = userRequest.convertToUser(sid, userId);
            userRepository.save(temp);
        }
    }
}
