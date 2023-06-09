package com.demo.design.mode_c_behavior.i_state;

import java.util.List;

/**
 * ConcreteState: 具体状态类
 * 選擇商品狀態類
 */
public class SelectState implements State {
    Context context;

    public SelectState(Context context){
        this.context = context;
    }

    @Override
    public void selectProduct(Product product) {
        context.product = product;
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

    }
}