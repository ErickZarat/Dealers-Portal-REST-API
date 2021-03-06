package me.erickzarat.portal.authchannels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.erickzarat.portal.dealers.Dealer;

import javax.persistence.*;

@Entity
public class AuthorizedChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    Integer code;
    String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Dealer dealer;

    public AuthorizedChannel() { }

    public AuthorizedChannel(Integer code, String name, Dealer dealer) {
        this.code = code;
        this.name = name;
        this.dealer = dealer;
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
}
