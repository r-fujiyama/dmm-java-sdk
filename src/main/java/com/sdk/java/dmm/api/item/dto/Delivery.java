package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 配信
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "price"
})
public class Delivery {

  /** 配信タイプ */
  @JsonProperty("type")
  private String type;
  /** 配信価格 */
  @JsonProperty("price")
  private String price;

}
