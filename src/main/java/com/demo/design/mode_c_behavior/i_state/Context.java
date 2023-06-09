package com.demo.design.mode_c_behavior.i_state;

import java.util.ArrayList;
import java.util.List;

/**
 * Context: 环境类
 */
public class Context{
    List<Product> productList = new ArrayList<Product>();
    Product product ;//选择购买的产品
    SelectState selectState = new SelectState(this); //狀態一 選擇商品
    OrderState orderState = new OrderState(this);//狀態二 下訂單
    PayState payState = new PayState(this);//狀態三 付款
    DeliverState deliverState = new DeliverState(this);//狀態四 發貨

    State state ;//当前状态

    public void add(Product product){
        productList.add(product);

    }

    public Context(){

    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 下訂單
     * @param product
     * @param num
     * @return
     */
    public boolean orderProduct(Product product,Integer num){
        setState(selectState);
        state.selectProduct(product);
        setState(orderState);
        if(! state.lockNum(num)){//鎖定庫存失敗
            return false;
        }
        return true;
    }

    /**
     * 付款
     */
    public void payOrder(){
        if(state != orderState){
            System.out.println("操作失敗，不允許越權操作！");
            return;
        }
        setState(payState);
        state.deductMoney();
        state.deductNum();
    }

    /**
     * 發貨
     */
    public void deliverGoods(){
        if(state != payState){
            System.out.println("操作失敗，不允許越權操作！");
            return;
        }
        setState(deliverState);
        state.deliverGoods();
    }


}