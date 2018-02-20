package com.rakshitlabs.springbootangulartodo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name ="activity")
public class Todo implements Serializable{

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "description", length = 255)
    private String desc;

    @NotNull
    @Column(name= "status", length = 10)
    private String status;

    @ManyToOne
    @JsonIgnore
    private User user;


    private long logTime;


    public Todo(String desc, String status, User user) {
        this.desc = desc;
        this.status = status;
        this.user = user;
        this.logTime = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getLogTime() {
        return logTime;
    }

    public void setLogTime(long logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "Todo{" +
            "id=" + id +
            ", desc='" + desc + '\'' +
            ", status='" + status + '\'' +
            ", user=" + user +
            ", logtime=" + logTime +
            '}';
    }
}
