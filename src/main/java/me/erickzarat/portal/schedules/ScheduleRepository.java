package me.erickzarat.portal.schedules;

import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    Schedule findScheduleByDealer_Code(Integer dealerCode);
}
