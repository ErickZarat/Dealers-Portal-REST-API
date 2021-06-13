package me.erickzarat.portal.dealers;

import me.erickzarat.portal.authchannels.AuthorizedChannel;
import me.erickzarat.portal.products.Product;
import me.erickzarat.portal.schedules.Schedule;
import me.erickzarat.portal.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer code;
    String name;
    String notificationEmail;
    String alertEmail;

    @OneToMany(fetch = FetchType.LAZY)
    List<AuthorizedChannel> authorizedChannels;

    @OneToOne(fetch = FetchType.EAGER)
    Schedule schedule;

    @OneToMany(fetch = FetchType.LAZY)
    List<Product> products;

    @OneToMany(fetch = FetchType.LAZY)
    List<User> users;

    public Dealer() {
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<AuthorizedChannel> getAuthorizedChannels() {
        return authorizedChannels;
    }

    public void setAuthorizedChannels(List<AuthorizedChannel> authorizedChannels) {
        this.authorizedChannels = authorizedChannels;
    }

    public Dealer(Integer code, String name, String notificationEmail, String alertEmail) {
        this.code = code;
        this.name = name;
        this.notificationEmail = notificationEmail;
        this.alertEmail = alertEmail;
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

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getAlertEmail() {
        return alertEmail;
    }

    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }
}
