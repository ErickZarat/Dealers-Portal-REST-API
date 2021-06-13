package me.erickzarat.portal.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dealers/{dealerCode}/users")
    public @ResponseBody
    Iterable<User> getAllUsers(@PathVariable("dealerCode") Integer dealerCode) {
        return userRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/users/{code}")
    public @ResponseBody User getUser(@PathVariable("code") Integer code) {
        Optional<User> response =  userRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/dealers/{dealerCode}/users/")
    public @ResponseBody User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/users/{code}")
    public @ResponseBody User updateUser(@RequestBody User user){
        if (userRepository.existsById(user.code)){
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @DeleteMapping("/users/{code}")
    public @ResponseBody Boolean deleteUser(@PathVariable("code") Integer code){
        if (userRepository.existsById(code)){
            userRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
