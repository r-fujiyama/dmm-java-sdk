package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * ジャンルカテゴリー
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
public class GenreCategory {

  /** ジャンルカテゴリーID */
  @JsonProperty("id")
  private String id;
  /** ジャンルカテゴリー名 */
  @JsonProperty("name")
  private String name;

}
