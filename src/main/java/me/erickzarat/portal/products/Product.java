package me.erickzarat.portal.products;

import me.erickzarat.portal.authchannels.AuthorizedChannel;
import me.erickzarat.portal.dealers.Dealer;
import me.erickzarat.portal.schedules.Schedule;
import me.erickzarat.portal.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer code;
    String name;
    String description;
    Double amount;

    @ManyToOne
    Dealer dealer;

    public Product() {
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
