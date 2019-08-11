package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 価格
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "list_price",
    "price_all",
    "deliveries"
})
public class Prices {

  /** 金額 */
  @JsonProperty("price")
  private String price;
  /** 定価 */
  @JsonProperty("list_price")
  private String listPrice;
  /** 全ての価格 */
  @JsonProperty("price_all")
  private String priceAll;
  /** 配信リスト */
  @JsonProperty("deliveries")
  private Deliveries deliveries;

}
