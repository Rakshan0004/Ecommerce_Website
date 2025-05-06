package com.rakshan.store.mappers;

import com.rakshan.store.dtos.UserDto;
import com.rakshan.store.entities.User;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T01:09:34+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();

        LocalDateTime createdAt = java.time.LocalDateTime.now();

        UserDto userDto = new UserDto( id, name, email, createdAt );

        return userDto;
    }
}
