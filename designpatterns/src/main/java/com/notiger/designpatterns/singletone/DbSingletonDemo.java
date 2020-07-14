package com.notiger.designpatterns.singletone;

public class DbSingletonDemo {
    public static void main(String[] args){
        DbSingleton instance = DbSingleton.getInstance();
        DbSingleton instance2 = DbSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
