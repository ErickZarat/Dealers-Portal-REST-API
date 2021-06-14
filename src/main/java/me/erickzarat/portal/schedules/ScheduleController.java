package me.erickzarat.portal.schedules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/{code}")
    public @ResponseBody Schedule getSchedule(@PathVariable("code") Integer code) {
        Optional<Schedule> response =  scheduleRepository.findById(code);
        return response.orElse(null);
    }

    @PostMapping("/")
    public @ResponseBody Schedule saveSchedule(@RequestBody Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    @PutMapping("/{code}")
    public @ResponseBody Schedule updateProduct(@RequestBody Schedule schedule){
        if (scheduleRepository.existsById(schedule.id)){
            return scheduleRepository.save(schedule);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{code}")
    public @ResponseBody Boolean deleteSchedule(@PathVariable("code") Integer code){
        if (scheduleRepository.existsById(code)){
            scheduleRepository.deleteById(code);
            return true;
        } else {
            return false;
        }
    }
}
