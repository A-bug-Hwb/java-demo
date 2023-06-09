package com.demo.design.mode_c_behavior.i_state;

/**
 * ConcreteState: 具体状态类
 * 付款狀態類
 */
public class PayState implements State {
    Context context;

    public PayState(Context context) {
        this.context = context;
    }

    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public boolean lockNum(Integer num) {
        return false;
    }

    @Override
    public void deductMoney() {
        System.out.println(String.format("购买%s产品%s件花费%s",context.product.name,context.product.lockNum,context.product.lockNum * context.product.price));
    }

    @Override
    public void deductNum() {
        context.product.num = context.product.num - context.product.lockNum;
        System.out.println(String.format("扣减%s产品库存%s件，所剩%s件",context.product.name,context.product.lockNum,context.product.num));

        context.product.lockNum = 0;
    }

    @Override
    public void deliverGoods() {

    }
}