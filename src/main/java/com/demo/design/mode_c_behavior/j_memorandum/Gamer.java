package com.demo.design.mode_c_behavior.j_memorandum;

/**
 * Originator: 原发器
 * 游戏角色
 */
public class Gamer {
    private String life;//生命值
    private int level;//等级
    private String equipage;//头盔

    public Memento backup() {
        Memento memento = new Memento(this.life,this.level,this.equipage);
        return memento;
    }

    public Gamer(String life, int level, String equipage) {
        this.life = life;
        this.level = level;
        this.equipage = equipage;
    }

    public void recovery(Memento memento) {
        this.life = memento.getLife();
        this.level = memento.getLevel();
        this.equipage = memento.getEquipage();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "life='" + life + '\'' +
                ", level=" + level +
                ", equipage='" + equipage + '\'' +
                '}';
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEquipage() {
        return equipage;
    }

    public void setEquipage(String equipage) {
        this.equipage = equipage;
    }





}