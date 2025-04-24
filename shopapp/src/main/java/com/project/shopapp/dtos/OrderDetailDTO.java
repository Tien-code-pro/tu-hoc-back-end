package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data // to String
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {

    @JsonProperty("order_id")
    @Min(value = 1, message = "Order's ID must be > 0")
    private Long orderId;

    @JsonProperty("product_id ")
    @Min(value = 1, message = "Product's ID must be > 0")
    private Long productId;

    @JsonProperty("price")
    @Min(value = 0, message = "Price money must be >= 0")
    private Long price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "Number_of_products money must be >= 1")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "Total money must be >= 0")
    private int totalMoney;

    private String color;
}
