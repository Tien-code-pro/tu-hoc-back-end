package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data // to String
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductImageDTO {
    @JsonProperty("product_id")
    @Min(value = 1, message = "Product 's ID must be > 0 ")
    private Long productId;

    @Size(min = 5, max = 200, message = "Image name must be between 5 and 200 character")
    @JsonProperty("image_url")
    private String imageUrl;
}
