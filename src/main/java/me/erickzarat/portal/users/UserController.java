package me.erickzarat.portal.users;

import io.swagger.annotations.Api;
import me.erickzarat.portal.dealers.Dealer;
import me.erickzarat.portal.dealers.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(value = "Users", description = "REST API for Users", tags = { "Users" })
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping
    public @ResponseBody
    Iterable<User> getAllUsers(@RequestParam(value = "dealerCode", required = false) Integer dealerCode) {
        return userRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/{code}")
    public @ResponseBody User getUser(@PathVariable("code") Integer code) {
        Optional<User> response =  userRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping
    public @ResponseBody User addUser(@RequestParam("dealerCode") Integer dealerCode, @RequestBody User user){
        Dealer dealer = dealerRepository.findById(dealerCode).orElse(null);
        if (dealer != null) {
            user = userRepository.save(user);
            dealer.getUsers().add(user);
            dealerRepository.save(dealer);
        }
        return user;
    }

    @PutMapping("/{code}")
    public @ResponseBody User updateUser(@RequestBody User user){
        if (userRepository.existsById(user.code)){
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{code}")
    public @ResponseBody Boolean deleteUser(@PathVariable("code") Integer code){
        if (userRepository.existsById(code)){
            userRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
