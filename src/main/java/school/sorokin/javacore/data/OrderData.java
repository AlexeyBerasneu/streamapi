package school.sorokin.javacore.data;

import school.sorokin.javacore.entity.Order;
import school.sorokin.javacore.entity.Product;
import school.sorokin.javacore.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OrderData {
    private final ProductData productData = new ProductData();
    private final List<Product> products = productData.getProducts();
    private static List<Order> orders = new ArrayList<>();

    {
        orders.add(new Order(1L, LocalDate.now().minusDays(3), LocalDate.now().plusDays(1), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(0), products.get(5), products.get(10)))));

        orders.add(new Order(2L, LocalDate.now().minusDays(5), LocalDate.now().plusDays(2), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(1), products.get(6)))));

        orders.add(new Order(3L, LocalDate.now().minusDays(1), LocalDate.now().plusDays(4), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(2)))));

        orders.add(new Order(4L, LocalDate.now().minusDays(7), LocalDate.now().plusDays(2), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(3), products.get(7), products.get(11)))));

        orders.add(new Order(5L, LocalDate.now().minusDays(10), LocalDate.now().plusDays(3), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(4), products.get(5), products.get(9)))));

        orders.add(new Order(6L, LocalDate.now().minusDays(2), LocalDate.now().plusDays(5), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(0), products.get(8), products.get(12), products.get(14)))));

        orders.add(new Order(7L, LocalDate.now().minusDays(8), LocalDate.now().plusDays(1), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(1), products.get(2), products.get(10)))));

        orders.add(new Order(8L, LocalDate.now().minusDays(4), LocalDate.now().plusDays(6), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(6)))));

        orders.add(new Order(9L, LocalDate.now().minusDays(12), LocalDate.now().plusDays(2), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(13), products.get(14)))));

        orders.add(new Order(10L, LocalDate.now().minusDays(6), LocalDate.now().plusDays(4), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(4), products.get(8), products.get(9), products.get(11)))));

        orders.add(new Order(11L, LocalDate.now().minusDays(9), LocalDate.now().plusDays(7), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(5), products.get(10), products.get(13)))));

        orders.add(new Order(12L, LocalDate.of(2021,2,2), LocalDate.now().plusDays(3), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(0), products.get(3)))));

        orders.add(new Order(13L, LocalDate.now().minusDays(11), LocalDate.now().plusDays(5), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(1), products.get(7), products.get(12)))));

        orders.add(new Order(14L, LocalDate.of(2022,3,1), LocalDate.now().plusDays(2), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(2), products.get(6), products.get(9), products.get(11), products.get(14)))));

        orders.add(new Order(15L, LocalDate.of(2021,3,15), LocalDate.now().plusDays(3), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(4)))));

        orders.add(new Order(16L, LocalDate.of(2021,3,14), LocalDate.now().plusDays(4), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(5), products.get(8)))));

        orders.add(new Order(17L, LocalDate.now().minusDays(13), LocalDate.now().plusDays(6), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(3), products.get(7), products.get(10)))));

        orders.add(new Order(18L, LocalDate.now().minusDays(20), LocalDate.now().plusDays(5), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(0), products.get(2), products.get(11), products.get(13)))));

        orders.add(new Order(19L, LocalDate.of(2025,3,15), LocalDate.now().plusDays(1), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(1), products.get(4), products.get(6)))));

        orders.add(new Order(20L, LocalDate.now().minusDays(22), LocalDate.now().plusDays(8), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(9), products.get(12)))));

        orders.add(new Order(21L, LocalDate.now().minusDays(19), LocalDate.now().plusDays(2), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(10), products.get(13), products.get(14)))));

        orders.add(new Order(22L, LocalDate.now().minusDays(25), LocalDate.now().plusDays(9), Status.IN_PROGRESS.toString(),
                new HashSet<>(List.of(products.get(5)))));

        orders.add(new Order(23L, LocalDate.now().minusDays(5), LocalDate.now().plusDays(10), Status.DELIVERED.toString(),
                new HashSet<>(List.of(products.get(2), products.get(8), products.get(11)))));

        orders.add(new Order(24L, LocalDate.now().minusDays(21), LocalDate.now().plusDays(2), Status.CANCELLED.toString(),
                new HashSet<>(List.of(products.get(0), products.get(1), products.get(3), products.get(7)))));

        orders.add(new Order(25L, LocalDate.now().minusDays(23), LocalDate.now().plusDays(3), Status.NEW.toString(),
                new HashSet<>(List.of(products.get(4), products.get(5), products.get(6), products.get(9), products.get(10)))));

    }

    public static List<Order> getOrders() {
        return orders;
    }
}
