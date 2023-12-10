package com.edu.eduwise.service;

import com.edu.eduwise.dto.UserDto;
import com.edu.eduwise.map.UserMap;
import com.edu.eduwise.model.Category;
import com.edu.eduwise.model.User;
import com.edu.eduwise.repo.CategoryRepo;
import com.edu.eduwise.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepo userRepo;

    @Mock
    private UserMap userMap;

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private UserService userService;

    @Test
    public void findByIdUserDtoIdExists() {
        Long id = 1L;
        User user = new User();
        UserDto userDto = new UserDto();

        when(userRepo.findById(id)).thenReturn(Optional.of(user));
        when(userMap.toDto(user)).thenReturn(userDto);

        UserDto result = userService.findById(id);

        assertNotNull(result);
        verify(userRepo, times(1)).findById(id);
        verify(userMap, times(1)).toDto(user);
    }

    @Test
    public void listUserDto() {
        List<User> userList = List.of(new User(), new User());
        List<UserDto> userDtoList = List.of(new UserDto(), new UserDto());

        when(userRepo.findAll()).thenReturn(userList);
        when(userMap.toDto(any())).thenReturn(userDtoList.get(0), userDtoList.get(1));

        List<UserDto> result = userService.list();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userRepo, times(1)).findAll();
        verify(userMap, times(2)).toDto(any());
    }

    @Test
    public void saveUserDto() {
        UserDto userDto = new UserDto();
        userDto.setCategoryId(1L);
        User user = new User();
        Category category = new Category();

        when(userMap.toEntity(userDto)).thenReturn(user);
        when(categoryRepo.findById(userDto.getCategoryId())).thenReturn(Optional.of(category));

        userService.save(userDto);

        verify(categoryRepo, times(1)).findById(userDto.getCategoryId());
        verify(userRepo, times(1)).save(user);
        assertEquals(category, user.getCategory());
    }



    @Test
    public void resetAttempts() {
        String username = "testUser";
        User user = new User();
        user.setUsername(username);
        user.setAttemptCount(2);

        when(userRepo.findByUsername(username)).thenReturn(Optional.of(user));

        userService.resetAttempts(username);

        verify(userRepo, times(1)).save(user);
        assertEquals(0, user.getAttemptCount());
    }
}
