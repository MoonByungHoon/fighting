package com.example.fighting.controller;

import com.example.fighting.dto.ResponseDto;
import com.example.fighting.dto.UserDto;
import com.example.fighting.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto) {
    try {
      if (userService.existsByUsername(userDto.getUsername()) || userService.existsByNickname(userDto.getNickname())) {

        return ResponseEntity.badRequest().body("중복된 아이디 혹은 닉네임.");
      } else {

//        final UserDto dto = UserMapper.INSTANCE.entityToDto(userService.register(userDto));

        return ResponseEntity.ok().body(userService.register(userDto));
      }
    } catch (Exception e) {
      ResponseDto responseDto = ResponseDto.builder().error(e.getMessage()).build();

      return ResponseEntity.badRequest().body(responseDto);
    }
  }
}
