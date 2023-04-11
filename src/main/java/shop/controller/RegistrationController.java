package shop.controller;

import org.springframework.web.bind.annotation.*;
import shop.model.User;
import shop.service.UserService;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:8000")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User saveNewUser(@RequestBody User user) {
        System.out.println("новый user: " + user);

        if (userService.saveUser(user)) {
            return userService.loadUserByUsername(user.getUsername());
        }

        return new User();
    }


}
