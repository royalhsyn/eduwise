package com.edu.eduwise.service;

import com.edu.eduwise.dto.UserDto;
import com.edu.eduwise.exception.NotFoundException;
import com.edu.eduwise.map.UserMap;
import com.edu.eduwise.model.Category;
import com.edu.eduwise.model.User;
import com.edu.eduwise.repo.CategoryRepo;
import com.edu.eduwise.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    private final UserMap userMap;

    private final CategoryRepo categoryRepo;



    public UserDto findById(Long id){
        return userRepo.findById(id)
                .map(userMap::toDto)
                .orElseThrow(()-> new NotFoundException("Bele id li user yoxdur"));
    }


    public List<UserDto> list(){
        return userRepo.findAll()
                .stream()
                .map(userMap::toDto)
                .toList();
    }

    public UserDto save(UserDto userDto){
        User user=userMap.toEntity(userDto);
        Optional<Category> category=categoryRepo.findById(userDto.getCategoryId());
        category.ifPresent(user::setCategory);
        userRepo.save(user);
        return userDto;
    }

    public void update(Long id, UserDto userDto){
        Optional<User> ent=userRepo.findById(id);
        User user=null;
        if(ent.isPresent()){
            user=ent.get();
        }
        Optional<Category> category=categoryRepo.findById(userDto.getCategoryId());
        if(category.isPresent()){
            assert user != null;
            user.setCategory(category.get());
        }
        userMap.updateEntityFromDto(user,userDto);

        userRepo.save(user);

    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElse(null);
    }

    public void increaseAttemptCount(String username) {
        userRepo.findByUsername(username)
                .ifPresent(user -> {
                    int attemptCount = user.getAttemptCount();
                    if (attemptCount > 2) {
                        user.setAccountNonLocked(false);
                    }
                    user.setAttemptCount(attemptCount + 1);

                    userRepo.save(user);
                });
    }

    public void resetAttempts(String username) {
        userRepo.findByUsername(username)
                .ifPresent(user -> {
                    user.setAttemptCount(0);
                    userRepo.save(user);
                });
    }
}
