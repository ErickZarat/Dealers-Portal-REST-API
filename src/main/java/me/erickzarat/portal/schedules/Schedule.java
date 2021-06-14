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

    String initialHour;
    String endHour;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
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

    public String getInitialHour() {
        return initialHour;
    }

    public void setInitialHour(String initialHour) {
        this.initialHour = initialHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
