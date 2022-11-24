package com.zipbang.dotzipbang.service;

import com.zipbang.dotzipbang.entity.User;
import com.zipbang.dotzipbang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User join(User user){
        return userRepository.save(user);
    }
    public User login(User user) throws Exception {
        if (user.getEmail() == null || user.getPassword() == null)
            return null;
        return userRepository.login(user.getEmail(),user.getPassword());
    }

    public User userInfo(String userEmail) throws Exception {
        return userRepository.userInfo(userEmail);
    }

    public void saveRefreshToken(String userEmail, String refreshToken) throws Exception {
        userRepository.saveRefreshToken(userEmail,refreshToken);
    }

    public Object getRefreshToken(String userEmail) throws Exception {
        return userRepository.getRefreshToken(userEmail);
    }

    public void deleRefreshToken(String userEmail) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        userRepository.deleteRefreshToken(userEmail,null);
    }
    public User updateIntroduce(User user) throws Exception{
        User getUser = userRepository.findById(user.getId()).get();
        getUser.setIntroduce(user.getIntroduce());
        return userRepository.save(getUser);

    }
}
