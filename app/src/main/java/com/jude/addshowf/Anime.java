package com.jude.addshowf;

public class Anime {

    private String name;
    private int year;
    private double rate;

    public Anime() {
    }

    public Anime(String name, int year, double rate) {
        this.name = name;
        this.year = year;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
