package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 画像URL
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "small",
    "large"
})
public class ImageURL {

  /** 画像（小） */
  @JsonProperty("small")
  private String small;
  /** 画像（大） */
  @JsonProperty("large")
  private String large;

}
