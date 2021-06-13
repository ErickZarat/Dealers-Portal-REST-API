package me.erickzarat.portal.dealers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/dealers")
public class DealerController {
    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping("/")
    public @ResponseBody
    Iterable<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @GetMapping("/{code}")
    public @ResponseBody Dealer getDealer(@PathVariable("code") Integer code) {
        Optional<Dealer> response =  dealerRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/")
    public @ResponseBody Dealer addDealer(@RequestBody Dealer dealer){
        return dealerRepository.save(dealer);
    }

    @PutMapping("/{code}")
    public @ResponseBody Dealer updateDealer(@RequestBody Dealer dealer){
        if (dealerRepository.existsById(dealer.code)){
            return dealerRepository.save(dealer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{code}")
    public @ResponseBody Boolean deleteDealer(@PathVariable("code") Integer code){
        if (dealerRepository.existsById(code)){
            dealerRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
