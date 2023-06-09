package com.demo.design.mode_b_structure.g_flyweight;

public class Test {

    public static void main(String[] args) {
        Pet pet = CatPetFlyWeightFactory.getPet("黑色");
        Pet pet2 = CatPetFlyWeightFactory.getPet("黑色");
        Pet pet3 = CatPetFlyWeightFactory.getPet("黄色");
//        System.out.println(pet);
//        System.out.println(pet2);
//        System.out.println(pet3);

        //-----增加外部状态-------
        pet.display(new Animal("波斯猫","虾米"));
        pet2.display(new Animal("短毛猫","软骨鱼"));
        pet3.display(new Animal("虎斑猫","飞禽"));

//        打印内容
//        flyweight_method_mod.CatPet@506c589e
//        flyweight_method_mod.CatPet@506c589e
//        flyweight_method_mod.CatPet@69d0a921
//        黑色 的 波斯猫 love eat 虾米
//        黑色 的 短毛猫 love eat 软骨鱼
//        黄色 的 虎斑猫 love eat 飞禽
    }
}
