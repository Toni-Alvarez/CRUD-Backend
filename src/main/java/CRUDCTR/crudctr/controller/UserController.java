package CRUDCTR.crudctr.controller;

import CRUDCTR.crudctr.exception.UserNotFoundException;
import CRUDCTR.crudctr.model.User;
import CRUDCTR.crudctr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{Id}")
    User getUserById(@PathVariable Long Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new UserNotFoundException(Id));
    }

   @PutMapping("/user/{Id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long Id){
        return userRepository.findById(Id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(Id));



   }

    @DeleteMapping("/user/{Id}")
    String deleteUser(@PathVariable Long Id) {
        if (!userRepository.existsById(Id)) {
            throw new UserNotFoundException(Id);

        }
        userRepository.deleteById(Id);
        return "User with Id" + Id + "has been deleted.";

    }
}