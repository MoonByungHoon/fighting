package com.example.fighting.service;

import com.example.fighting.dto.UserDto;
import com.example.fighting.entity.User;
import com.example.fighting.mapper.UserMapper;
import com.example.fighting.presistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = {Exception.class})
@RequiredArgsConstructor
public class UserService {


  @Autowired
  UserRepository userRepository;

  public Long register(final UserDto userDto) {


    final User user = UserMapper.INSTANCE.dtoToEntity(userDto);

//    entityManager.persist(user);

    userRepository.save(user);

    return user.getId();
  }

  public boolean existsByUsername(final String username) {
    return userRepository.existsByUsername(username);
  }

  public boolean existsByNickname(final String Nickname) {
    return userRepository.existsByNickname(Nickname);
  }
}
