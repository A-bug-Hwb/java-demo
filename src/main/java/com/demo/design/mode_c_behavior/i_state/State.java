package com.demo.design.mode_c_behavior.i_state;

/**
 * State: 抽象状态类
 */
public interface State {
    public void selectProduct(Product product);

    public boolean lockNum(Integer num);

    public void deductMoney();

    public void deductNum();

    public void deliverGoods();
}