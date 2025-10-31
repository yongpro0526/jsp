package com.example.basic.chap04.di;

public class Hotel {
    // 호텔 클래스가 동작하는데 chef가 필요한 상황 -> 호텔이 셰프에 의존적임
    private Chef chef;

    // 생성자를 통해 chef 주입
    public Hotel(Chef chef) {
        this.chef = chef;
    }

    // getter / setter

    public Chef getChef() {
        return chef;
    }

    // setter 메서드를 통해서 chef 주입
    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
