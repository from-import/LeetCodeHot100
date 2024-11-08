package com.xxx;

public class Test {
    public static class Dog {
        // 定义一个静态成员变量
        public static String breed = "Labrador";
    }

    public static void main(String[] args) {
        // 通过类名访问静态变量
        System.out.println(Dog.breed);

        // 通过对象访问静态变量
        Dog dog = new Dog();
        System.out.println(dog.breed); // 不推荐，但可以这样访问
    }
}