package com.demo.design.mode_c_behavior.e_visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectStructure 结构对象角色，这是使用访问者模式必备的角色。它具备以下特性：能枚举它的元素；可以提供一个高层接口以允许访问者访问它的元素；如有需要，可以设计成一个复合对象或者一个聚集（如一个列表或无序集合）。
 * 若结构简单，不一定要使用
 */
public class DogStructure {
    List<DogBirds> dogStructureList = new ArrayList<DogBirds>();

    public void accept(Vistor vistor){
        for (DogBirds dogBirds : dogStructureList){
            dogBirds.accept(vistor);
        }
    }

    public void add(DogBirds dogBirds){
        dogStructureList.add(dogBirds);
    }


}