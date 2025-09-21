package school.sorokin.javacore;

import school.sorokin.javacore.data.CustomerData;
import school.sorokin.javacore.entity.Customer;
import school.sorokin.javacore.entity.Order;
import school.sorokin.javacore.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        CustomerData customerData = new CustomerData();
        List<Customer> customers = customerData.getCustomers();

        //Task 1 - get list of Products from category "Books" with price >100
        List<Product> productList1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(p -> p.getCategory().equals("Books") && p.getPrice().compareTo(BigDecimal.valueOf(100)) > 0)
                .distinct()
                .collect(Collectors.toList());

        //Task 2 - get the list of orders with ""Children's product
        List<Order> orders1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Children's products")))
                .collect(Collectors.toList());

        //Task 3 - get sum the price of Products from category "Toys" and apply 10% discount
        BigDecimal sum1 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(p -> p.getCategory().equals("Toys"))
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(0.9)))
                .distinct()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Task 4 - get list of Products from customer level 2 between 01-feb-2021 и 01-apr-2021
        List<Product> productList2 = customers.stream()
                .filter(c -> c.getLevel() == 2L)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)))
                .filter(o -> o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        //Task 5 - get 2 cheaper products
        List<Product> productList3 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .sorted(Comparator.comparing(Product::getPrice))
                .distinct()
                .limit(2)
                .collect(Collectors.toList());

        //Task 6 - get 3 last orders
        List<Order> orderList = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .distinct()
                .limit(3)
                .collect(Collectors.toList());

        //Task 7 - show orders id  15-march-2021
        List<Product> productList4 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(p -> System.out.println(p.getId()))
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.toList());

        //Task 8 - show order's sum in february 2021
        BigDecimal sum = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> !o.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)))
                .filter(o -> !o.getOrderDate().isAfter(LocalDate.of(2021, 2, 28)))
                .flatMap(o -> o.getProducts().stream())
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //Task 9 - show average payment in 14-march-2021
        double avg = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .flatMap(o -> o.getProducts().stream())
                .map(p -> p.getPrice())
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0);

        //Task 10
        DoubleSummaryStatistics statistics = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getCategory().equals("Books"))
                .distinct()
                .collect(Collectors.summarizingDouble(p -> p.getPrice().doubleValue()));
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());

        //Task 11 average quantity products in order
        Map<Long, Integer> averageProductsInOrder = customers.stream()
                .flatMap(o -> o.getOrders().stream())
                .collect(Collectors.toMap(
                        Order::getId,
                        o -> o.getProducts().size()
                ));

        //Task 12 average quantity products in order
        Map<Long, List<Order>> mapCustomerWithOrders = customers.stream()
                .collect(Collectors.toMap(
                        Customer::getId,
                        o -> o.getOrders().stream().toList()
                ));

        //Task 13 map with orders and total sum of products
        Map<Order, Double> mapOrders = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .sorted(Comparator.comparing(Order::getId))
                .collect(Collectors.toMap(
                        o -> o,
                        o -> o.getProducts().stream()
                                .map(p -> p.getPrice())
                                .mapToDouble(BigDecimal::doubleValue)
                                .reduce(0, (a, b) -> a + b),
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
        //Task 14 map with Category and list of name's products
        Map<String, List<String>> mapName = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.groupingBy(
                        p -> p.getCategory(),
                        Collectors.collectingAndThen(
                                Collectors.mapping(Product::getName, Collectors.toCollection(LinkedHashSet::new)),
                                ArrayList::new
                        )
                ));
        //Task 15 map with Category and most expensive product
        Map<String, Product> mapWithPrice = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                Optional::get)
                ));
    }
}