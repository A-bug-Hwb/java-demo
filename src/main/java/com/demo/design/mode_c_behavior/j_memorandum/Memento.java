package com.demo.design.mode_c_behavior.j_memorandum;

/**
 * Memento: 备忘录
 */
public class Memento {
    private String life;
    private int level;
    private String equipage;

    public Memento(String life, int level, String equipage) {
        this.life = life;
        this.level = level;
        this.equipage = equipage;
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