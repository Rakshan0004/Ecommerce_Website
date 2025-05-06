package com.rakshan.store.mappers;

import com.rakshan.store.dtos.RegisterUserRequest;
import com.rakshan.store.dtos.UpdateUserRequest;
import com.rakshan.store.dtos.UserDto;
import com.rakshan.store.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T16:40:33+0530",
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

        UserDto userDto = new UserDto( id, name, email );

        return userDto;
    }

    @Override
    public User toEntity(RegisterUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( request.getName() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );

        return user.build();
    }

    @Override
    public void update(UpdateUserRequest request, User user) {
        if ( request == null ) {
            return;
        }

        user.setName( request.getName() );
        user.setEmail( request.getEmail() );
    }
}
