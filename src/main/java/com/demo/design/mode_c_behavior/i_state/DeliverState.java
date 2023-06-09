package com.demo.design.mode_c_behavior.i_state;

/**
 * ConcreteState: 具体状态类
 * 發貨狀態類
 */
public class DeliverState implements State {
    Context context;

    public DeliverState(Context context) {
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

    }

    @Override
    public void deductNum() {

    }

    @Override
    public void deliverGoods() {
        System.out.println(String.format("%s产品已经发货",context.product.name));
    }
}