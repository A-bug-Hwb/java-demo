package com.demo.design.mode_c_behavior.i_state;

/**
 * ConcreteState: 具体状态类
 * 下訂單狀態類
 */
public class OrderState implements State {
    Context context;

    public OrderState(Context context) {
        this.context = context;
    }


    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public boolean lockNum(Integer num) {
        if(num > (context.product.num + context.product.lockNum)){
            System.out.println(String.format("操作失败，库存不足!需購買的數量%s,目前庫存%s",num,context.product.num + context.product.lockNum));
            return false;
        }
        context.product.setLockNum(num);
        return true;
    }

    @Override
    public void deductMoney() {

    }

    @Override
    public void deductNum() {

    }

    @Override
    public void deliverGoods() {

    }


}