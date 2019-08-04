package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "delivery"
})
public class Deliveries {

  @JsonProperty("delivery")
  private List<Delivery> delivery = null;

}
