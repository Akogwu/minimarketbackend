package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Order;

public interface OrderService {

    public Order getOrderById(long id);

    public void deleteById(long id);

    public void save(Order order);

}
