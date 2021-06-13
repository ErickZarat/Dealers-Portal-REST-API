package me.erickzarat.portal.authchannels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class AuthorizedChannelController {

    @Autowired
    private AuthorizedChannelRepository authorizedChannelRepository;

    @GetMapping("/dealers/{dealerCode}/authorized-channels")
    public @ResponseBody Iterable<AuthorizedChannel> getAllAuthorizedChannels(@PathVariable("dealerCode") Integer dealerCode) {
        return authorizedChannelRepository.findAllByDealer_Code(dealerCode);
    }

    @GetMapping("/authorized-channels/{code}")
    public @ResponseBody AuthorizedChannel getAuthorizedChannel(@PathVariable("code") Integer code) {
        Optional<AuthorizedChannel> response =  authorizedChannelRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/dealers/{dealerCode}/authorized-channels/")
    public @ResponseBody AuthorizedChannel addAuthorizedChannel(@RequestBody AuthorizedChannel authorizedChannel){
        return authorizedChannelRepository.save(authorizedChannel);
    }

    @PutMapping("/authorized-channels/{code}")
    public @ResponseBody AuthorizedChannel updateAuthorizedChannel(@RequestBody AuthorizedChannel authorizedChannel){
        if (authorizedChannelRepository.existsById(authorizedChannel.code)){
            return authorizedChannelRepository.save(authorizedChannel);
        } else {
            return null;
        }
    }

    @DeleteMapping("/authorized-channels/{code}")
    public @ResponseBody Boolean deleteAuthorizedChannel(@PathVariable("code") Integer code){
        if (authorizedChannelRepository.existsById(code)){
            authorizedChannelRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }

}
