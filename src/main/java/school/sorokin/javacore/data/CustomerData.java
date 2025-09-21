package school.sorokin.javacore.data;

import school.sorokin.javacore.entity.Customer;
import school.sorokin.javacore.entity.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomerData {
    private final OrderData orderData = new OrderData();
    private final List<Order> orders = orderData.getOrders();
    private final List<Customer> customers;
    {
        Customer customer1 = new Customer(1L, "Alex", 2L,
                new HashSet<>(List.of(orders.get(0), orders.get(1), orders.get(2), orders.get(3), orders.get(4))));

        Customer customer2 = new Customer(2L, "Bob", 1L,
                new HashSet<>(List.of(orders.get(5), orders.get(6), orders.get(7), orders.get(8), orders.get(9))));

        Customer customer3 = new Customer(3L, "Denis", 2L,
                new HashSet<>(List.of(orders.get(10), orders.get(11), orders.get(12), orders.get(13), orders.get(14))));

        Customer customer4 = new Customer(4L, "Alise", 4L,
                new HashSet<>(List.of(orders.get(15), orders.get(16), orders.get(17), orders.get(18), orders.get(19))));

        Customer customer5 = new Customer(5L, "Olga", 1L,
                new HashSet<>(List.of(orders.get(20), orders.get(21), orders.get(22), orders.get(23), orders.get(24))));

        customers = new ArrayList<>(List.of(customer1, customer2, customer3, customer4, customer5));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
