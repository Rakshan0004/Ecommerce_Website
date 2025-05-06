package com.rakshan.store.mappers;

import com.rakshan.store.dtos.RegisterUserRequest;
import com.rakshan.store.dtos.UpdateUserRequest;
import com.rakshan.store.dtos.UserDto;
import com.rakshan.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel= "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);
}
