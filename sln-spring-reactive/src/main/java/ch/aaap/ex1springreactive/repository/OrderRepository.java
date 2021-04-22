package ch.aaap.ex1springreactive.repository;

import ch.aaap.ex1springreactive.model.NewOrderDTO;
import ch.aaap.ex1springreactive.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

public interface OrderRepository {
  Mono<Long> addOrder(NewOrderDTO dto, ZonedDateTime placedTime);

  Flux<Order> getOrdersBetween(ZonedDateTime from, ZonedDateTime to);
}
