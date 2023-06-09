package com.demo.design.mode_b_structure.f_combination;

public class Test {

    public static void main(String[] args) {
        Animal tiger = new Tiger("刀疤虎");
        Animal cat = new Cat("咖啡猫");
        Animal cat2 = new Cat("芭比猫");
        Animal dog = new Dog("华田狗");
        Animal dog2 = new Dog("单身狗");
        Animal chick = new Chick("黄花鸡");
        Animal chick2 = new Chick("雀斑鸡");
        Animal duck = new Duck("白羽鸭");
        tiger.add(cat);
        tiger.add(cat2);
        tiger.add(dog2);
        tiger.add(dog);
        dog.add(chick);
        dog.add(chick2);
        chick.add(duck);

        printInfo("/",tiger);//输出树级结构
    }

    /**
     * 迭代输出 树级结构
     * @param pre
     * @param a
     */
    public static void printInfo(String pre ,Animal a){
        System.out.println(String.format("%s 下属：%s",pre,a.getName()));

        if(null == a.getSubAnimal()){
            return;
        }
        for(Animal b : a.getSubAnimal()){
            printInfo(a.getName(),b);
        }

    }
}
