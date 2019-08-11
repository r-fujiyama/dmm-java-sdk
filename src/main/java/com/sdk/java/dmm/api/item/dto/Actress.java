package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 女優（アダルト作品のみ）
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby"
})
public class Actress {

  /** 女優ID */
  @JsonProperty("id")
  private String id;
  /** 女優名 */
  @JsonProperty("name")
  private String name;
  /** 女優名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;

}
