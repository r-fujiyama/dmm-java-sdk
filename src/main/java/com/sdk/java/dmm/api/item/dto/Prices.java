package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "list_price",
    "price_all",
    "deliveries"
})
public class Prices {

  @JsonProperty("price_all")
  private String priceAll;
  @JsonProperty("price")
  private String price;
  @JsonProperty("list_price")
  private String listPrice;
  @JsonProperty("deliveries")
  private Deliveries deliveries;

}
