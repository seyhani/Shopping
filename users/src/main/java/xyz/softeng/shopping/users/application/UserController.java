package xyz.softeng.shopping.users.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.softeng.shopping.users.domain.User;
import xyz.softeng.shopping.users.domain.UserRepository;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;
    private final UserMapper mapper;

    @PostMapping
    public User create(@RequestBody UserDto dto) {
        User user = mapper.fromDto(dto);
        return repository.save(user);
    }

    @GetMapping
    public String test() {
        return "users";
    }
}