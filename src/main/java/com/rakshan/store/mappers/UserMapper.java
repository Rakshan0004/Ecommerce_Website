package com.rakshan.store.mappers;
import com.rakshan.store.dtos.UserDto;
import com.rakshan.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface UserMapper {

    public UserDto toDto(User user);
}
