package me.erickzarat.portal.schedules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.erickzarat.portal.dealers.Dealer;

import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Integer id;

    Integer initialHour;
    Integer endHour;

    @OneToOne
    Dealer dealer;

    public Schedule() {
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Boolean isHourValid(Integer hour){
        return hour >= 0 && hour < 24;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitialHour() {
        return initialHour;
    }

    public void setInitialHour(Integer initialHour) {
        this.initialHour = initialHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
}
