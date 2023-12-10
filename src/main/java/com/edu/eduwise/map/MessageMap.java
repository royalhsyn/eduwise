package com.edu.eduwise.map;

import com.edu.eduwise.dto.ExamResultDto;
import com.edu.eduwise.dto.MessageDto;
import com.edu.eduwise.model.ExamResult;
import com.edu.eduwise.model.Message;
import com.edu.eduwise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MessageMap {

    @Mapping(target = "userId", expression = "java(toSetUser(message.getUser()))")
    MessageDto toDto(Message message);


    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    Message toEntity(MessageDto messageDto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() Message message, MessageDto messageDto);

    default Long toSetUser(User user){
        return user.getId();
    }
}
