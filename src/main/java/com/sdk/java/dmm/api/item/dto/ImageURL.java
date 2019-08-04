package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "list",
    "small",
    "large"
})
public class ImageURL {

  @JsonProperty("list")
  private String list;
  @JsonProperty("small")
  private String small;
  @JsonProperty("large")
  private String large;

}
