package com.rakshitlabs.springbootangulartodo.service.dto;

public class TodoDTO {

    private long id;
    private String desc;
    private String status;
    private long logTime;


    public TodoDTO(long id, String desc, String status, long logTime) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.logTime = logTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getLogTime() {
        return logTime;
    }

    public void setLogTime(long logTime) {
        this.logTime = logTime;
    }


    @Override
    public String toString() {
        return "TodoDTO{" +
            "id=" + id +
            ", desc='" + desc + '\'' +
            ", status='" + status + '\'' +
            ", logTime=" + logTime +
            '}';
    }
}
