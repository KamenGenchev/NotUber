package com.example.notuber.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractUser {
    @OneToMany
    private List<Ride> rideList;

    public User() {

    }

//    public User(List<Ride> rideList) {
//        this.rideList = rideList;
//    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }


}

