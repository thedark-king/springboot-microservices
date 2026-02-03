package com.learn.withravi.service;

import com.learn.withravi.dto.UserDto;
import com.learn.withravi.entity.User;
import com.learn.withravi.mapper.AutoUserMapper;
import com.learn.withravi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
       //covert UserDto to User entity
//        User newUser = UserMapper.mapToUser(user);
//        User newUser = modelMapper.map(userDto, User.class);
        User newUser = AutoUserMapper.MAPPER.maptoUser(userDto);

       User savedUser = userRepository.save(newUser);
       //Convert User entity to UserDto
//         UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.maptoUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
//       return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.MAPPER.maptoUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
//        List<UserDto> userDtosList = users.stream()
//                .map(user -> UserMapper.mapToUserDto(user))
//                .collect(Collectors.toList());
//        List<UserDto> userDtosList = users.stream().map(
//                user -> modelMapper.map(user, UserDto.class)
//        ).collect(Collectors.toList());
        List<UserDto> userDtosList = users.stream().map(
                user -> AutoUserMapper.MAPPER.maptoUserDto(user)
        ).collect(Collectors.toList());
        return userDtosList;
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.maptoUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
