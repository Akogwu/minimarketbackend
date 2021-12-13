package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Order;
import edu.miu.minimarket.repository.product.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order getOrderById (long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById (long id) {
         orderRepository.deleteById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
