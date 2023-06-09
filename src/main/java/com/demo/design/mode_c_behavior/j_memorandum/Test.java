package com.demo.design.mode_c_behavior.j_memorandum;

public class Test {
    public static void main(String[] args) {
        Gamer gamer = new Gamer("1",10,"布藝頭盔");
        CareTaker careTaker = new CareTaker();
        careTaker.setBackup(gamer.backup());//第零次
        System.out.println(gamer.toString());

        gamer.setLife("10");
        gamer.setLevel(2);
        gamer.setEquipage("生鐵頭盔");
        System.out.println(gamer.toString());
        careTaker.setBackup(gamer.backup());//第一次

        gamer.setLife("80");
        gamer.setLevel(25);
        gamer.setEquipage("粗鋼頭盔");
        System.out.println(gamer.toString());
        careTaker.setBackup(gamer.backup());//第二次

        gamer.setLife("120");
        gamer.setLevel(30);
        gamer.setEquipage("黃金頭盔");
        System.out.println(gamer.toString());
        careTaker.setBackup(gamer.backup());//第三次

        System.out.println(String.format("還原為第一次備份"));
        gamer.recovery(careTaker.getBackupByIndex(1));
        System.out.println(gamer.toString());
    }
}
