package ch.aaap.ex1springreactive.repository;

import ch.aaap.ex1springreactive.model.ProductDTO;
import ch.aaap.ex1springreactive.model.ProductDataDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
  Flux<ProductDTO> findAllActiveProductDTO();

  Mono<Integer> addProduct(String sku, ProductDataDTO dto);

  Mono<Integer> updateBySku(String sku, ProductDataDTO dto);

  Mono<Integer> softDeleteBySku(String sku);
}
