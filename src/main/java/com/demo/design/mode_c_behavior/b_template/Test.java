package com.demo.design.mode_c_behavior.b_template;

public class Test {
    public static void main(String[] args) {
        System.out.println("海洋公馆旅游");
        Trip oceanarium = new Oceanarium();
        oceanarium.play();

        System.out.println("------------------------");

        System.out.println("动物园旅游");
        Trip zoo = new Zoo();
        zoo.play();
    }
}
