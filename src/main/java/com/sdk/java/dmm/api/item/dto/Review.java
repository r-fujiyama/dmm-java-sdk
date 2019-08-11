package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * レビュー平均点
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "average"
})
public class Review {

  /** レビュー数 */
  @JsonProperty("count")
  private Integer count;
  /** レビュー平均点 */
  @JsonProperty("average")
  private Double average;

}
