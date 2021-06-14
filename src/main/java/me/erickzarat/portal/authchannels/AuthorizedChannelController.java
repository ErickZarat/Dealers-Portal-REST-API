package me.erickzarat.portal.authchannels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authorized-channels")
public class AuthorizedChannelController {

    @Autowired
    private AuthorizedChannelRepository authorizedChannelRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<AuthorizedChannel> getAllAuthorizedChannels(@RequestParam(value = "dealerCode", required = false) Integer dealerCode) {
        return authorizedChannelRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/{code}")
    public @ResponseBody AuthorizedChannel getAuthorizedChannel(@PathVariable("code") Integer code) {
        Optional<AuthorizedChannel> response =  authorizedChannelRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/")
    public @ResponseBody AuthorizedChannel addAuthorizedChannel(@RequestBody AuthorizedChannel authorizedChannel){
        return authorizedChannelRepository.save(authorizedChannel);
    }

    @PutMapping("/{code}")
    public @ResponseBody AuthorizedChannel updateAuthorizedChannel(@RequestBody AuthorizedChannel authorizedChannel){
        if (authorizedChannelRepository.existsById(authorizedChannel.code)){
            return authorizedChannelRepository.save(authorizedChannel);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{code}")
    public @ResponseBody Boolean deleteAuthorizedChannel(@PathVariable("code") Integer code){
        if (authorizedChannelRepository.existsById(code)){
            authorizedChannelRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }

}
