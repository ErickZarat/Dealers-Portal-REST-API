package me.erickzarat.portal.schedules;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/schedules")
@Api(value = "Schedules", description = "REST API for Schedules", tags = { "Schedules" })
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/{code}")
    public @ResponseBody Schedule getSchedule(@PathVariable("code") Integer code) {
        Optional<Schedule> response =  scheduleRepository.findById(code);
        return response.orElse(null);
    }

    @GetMapping
    public @ResponseBody Iterable<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @PostMapping
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
