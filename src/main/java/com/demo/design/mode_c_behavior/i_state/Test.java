package com.demo.design.mode_c_behavior.i_state;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        Product product = new Product("天地一号", 15F, 100);
        Product product2 = new Product("天地二号", 18F, 200);
        context.add(product);//添加货物，上架商品一
        context.add(product2);//添加货物，上架商品二

        //下订单一
        if(! context.orderProduct(product,5)){//选择购买的商品及数量，下单
            return;//下单失败
        }
        context.payOrder();//付款
        context.deliverGoods();//发货

        System.out.println("===========================");

        //下订单二
        if(! context.orderProduct(product,100)){//选择购买的商品及数量，下单
            return;//下单失败
        }
        context.payOrder();//付款
        context.deliverGoods();//发货
    }
}
