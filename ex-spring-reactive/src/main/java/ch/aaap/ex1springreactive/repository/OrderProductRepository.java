package ch.aaap.ex1springreactive.repository;

import ch.aaap.ex1springreactive.model.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderProductRepository {
  Flux<ProductDTO> getProductsForOrder(long orderId);

  Mono<Integer> addProductsForOrder(long orderId, List<String> skus);
}
