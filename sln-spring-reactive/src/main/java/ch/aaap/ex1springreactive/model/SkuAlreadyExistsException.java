package ch.aaap.ex1springreactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SkuAlreadyExistsException extends RuntimeException {
  private String sku;
}
