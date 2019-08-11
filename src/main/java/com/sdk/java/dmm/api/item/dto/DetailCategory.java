package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * カテゴリー詳細
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
public class DetailCategory {

  /** カテゴリーID */
  @JsonProperty("id")
  private String id;
  /** カテゴリー名 */
  @JsonProperty("name")
  private String name;

}
