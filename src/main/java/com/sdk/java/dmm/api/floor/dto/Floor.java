package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * フロア情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "code"
})
public class Floor {

  /** フロアID */
  @JsonProperty("id")
  private Long id;
  /** フロア名 */
  @JsonProperty("name")
  private String name;
  /** フロアコード */
  @JsonProperty("code")
  private String code;

}
