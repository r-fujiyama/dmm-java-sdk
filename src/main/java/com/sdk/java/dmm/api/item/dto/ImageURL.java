package com.sdk.java.dmm.api.item.dto;

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
    "list",
    "small",
    "large"
})
public class ImageURL {

  /** リストページ用 */
  @JsonProperty("list")
  private String list;
  /** 末端用（小） */
  @JsonProperty("small")
  private String small;
  /** 末端用（大） */
  @JsonProperty("large")
  private String large;

}
