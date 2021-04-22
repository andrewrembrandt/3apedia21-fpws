package ch.aaap.ex1springreactive.repository;

import ch.aaap.ex1springreactive.model.NewOrderDTO;
import ch.aaap.ex1springreactive.model.Order;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
  @Autowired private R2dbcEntityTemplate template;

  @Override
  public Mono<Long> addOrder(NewOrderDTO dto, ZonedDateTime placedTime) {
    val o = new Order(null, dto.getBuyerEmail(), placedTime);
    return template
        .insert(Order.class)
        .into("customer_order")
        .using(o)
        .map(Order::getId);
  }

  @Override
  public Flux<Order> getOrdersBetween(ZonedDateTime from, ZonedDateTime to) {
    return template
        .select(Order.class)
        .from("customer_order")
        .matching(query(
            where("placed_time").greaterThanOrEquals(from).and("placed_time").lessThanOrEquals(to)))
        .all();
  }
}
