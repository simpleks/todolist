package com.example.hello;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "languages")
class Lang {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")

    private Integer id;
    @Column(name = "welcomemsg") //todo: WAŻNE w adnotacji kolumny pisz z małcyh
    private String welcomeMsg;
    private String code;

    /**
     * Hibernate (JPA) needs it
     */
    @SuppressWarnings("unused")
    Lang() {

    }

    public Lang(Integer id, String welcomeMsg, String code) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getwelcomeMsg() {
        return welcomeMsg;
    }

    public void setwelcomeMsg(String WelcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
