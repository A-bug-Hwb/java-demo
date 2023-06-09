package com.demo.design.mode_c_behavior.j_memorandum;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker: 负责人
 */
public class CareTaker {
    List<Memento> mementoList = new ArrayList<>();

    public void setBackup(Memento backup) {
        mementoList.add(backup);
    }

    public Memento getBackupByIndex(int i) {
        return mementoList.get(i);
    }
}