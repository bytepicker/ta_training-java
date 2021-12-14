package com.epam.training.aleksandr_preobrazhenskiy.classes.main_task;

import java.util.Objects;

public class Date {
    private final int dd;
    private final int mm;
    private final int yyyy;

    public Date(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }

    public Date(String str){
        String[] data = str.split("\\.");
        this.dd = Integer.parseInt(data[0]);
        this.mm = Integer.parseInt(data[1]);
        this.yyyy = Integer.parseInt(data[2]);
    }

    @Override
    public String toString() {
        return "Date{" +
                "dd=" + dd +
                ", mm=" + mm +
                ", yyyy=" + yyyy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return dd == date.dd && mm == date.mm && yyyy == date.yyyy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dd, mm, yyyy);
    }

    public int getYyyy() {
        return yyyy;
    }
}
