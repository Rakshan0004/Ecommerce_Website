package com.rakshan.store.Controllers;


import com.rakshan.store.dtos.RegisterUserRequest;
import com.rakshan.store.dtos.UpdateUserRequest;
import com.rakshan.store.dtos.UserDto;
import com.rakshan.store.mappers.UserMapper;
import com.rakshan.store.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()
    public Iterable<UserDto> getAllUsers(
            @RequestHeader(required = false, name="x-auth-token") String authToken,
            @RequestParam(required = false, defaultValue = "", name = "sort") String sortBy)
        {
            System.out.println(authToken);

        if(!Set.of("name", "email").contains(sortBy))
            sortBy = "name";


        return userRepository.findAll(Sort.by(sortBy))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        var user = userRepository.findById(id).orElse(null);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder){
        var user = userMapper.toEntity(request);
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        var uri= uriBuilder.path("users/{id}").buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") Long id,
                                              @RequestBody @Valid UpdateUserRequest request) {

        var user = userRepository.findById(id).orElse(null);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userMapper.update(request, user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
