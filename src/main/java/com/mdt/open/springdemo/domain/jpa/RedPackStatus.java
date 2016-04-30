package com.mdt.open.springdemo.domain.jpa;

public enum RedPackStatus {
    CREATED(0),
    FINISH(1);

    private int status;

    RedPackStatus(int status){
        this.status = status;
    }

    public int getStatus(){return status;}
}
