package com.example.hello;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name = "languages")
class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")

    private Integer id;
    @Column(name = "WelcomeMsg")
    private String WelcomeMsg;
    private String code;

    /**
    *Hibernate (JPA) needs it
     */
    @SuppressWarnings("unused")
    Lang() {

    }
    public Lang(Integer id, String WelcomeMsg, String code) {
        this.id = id;
        this.WelcomeMsg = WelcomeMsg;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return WelcomeMsg;
    }

    public void setWelcomeMsg(String WelcomeMsg) {
        this.WelcomeMsg = WelcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
