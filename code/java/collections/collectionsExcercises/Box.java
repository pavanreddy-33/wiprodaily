package com.wipro.day4;

public class Box<T> {
    public T item;
    public void add(T item) {
        this.item = item;
    }
    public T get() {
        return item;
    }
}
