package edu.miu.minimarket.model.product;

public enum OrderStatusEnum {

    Shipped("Shipped"),
    Returned("Returned"),
    OnTheWay("On the way"),
    Cancelled("Cancelled"),
    Delivered("Delivered"),
    Pending("Pending");

    private String orderStatusEnum;

    OrderStatusEnum(String status){this.orderStatusEnum=status;}

    public String getOrderStatusEnum(){
        return this.orderStatusEnum;
    }
}
