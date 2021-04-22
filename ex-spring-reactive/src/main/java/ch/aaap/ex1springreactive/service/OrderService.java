package ch.aaap.ex1springreactive.service;

import ch.aaap.ex1springreactive.model.*;
import ch.aaap.ex1springreactive.repository.OrderProductRepository;
import ch.aaap.ex1springreactive.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class OrderService {
  private final OrderRepository orderRepo;
  private final OrderProductRepository orderProductRepo;

  public Flux<OrderDTO> getOrdersBetween(ZonedDateTime from, ZonedDateTime to) {
    return orderRepo.getOrdersBetween(from, to).flatMap(retrieveProducts());
  }

  public Mono<Void> createOrder(NewOrderDTO dto) {
    val checkedProducts = ensureProducts(dto);
    return checkedProducts
        .flatMap(na -> orderRepo.addOrder(dto, ZonedDateTime.now()))
        // TODO 2 - Then add products for order

        // TODO 3 - Then check if number of product SKUs match the number of number of products added to the order
  }

  private Mono<Boolean> ensureProducts(NewOrderDTO dto) {
    if (dto.getProductSkus().isEmpty()) return Mono.error(new NoProductsException(dto.toString()));
    else return Mono.just(false);
  }

  private Function<Order, Publisher<? extends OrderDTO>> retrieveProducts() {
    return oe ->
        orderProductRepo
            .getProductsForOrder(oe.getId())
            .collectList()
            .map(
                products ->
                    new OrderDTO(
                        oe.getId(),
                        products,
                        oe.getBuyerEmail(),
                        oe.getPlacedTime(),
                        products.stream()
                            .map(ProductDTO::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)));
  }
}
