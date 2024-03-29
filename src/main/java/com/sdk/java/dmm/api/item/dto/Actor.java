package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 出演者（一般作品のみ）
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby"
})
public class Actor {

  /** 出演者ID */
  @JsonProperty("id")
  private String id;
  /** 出演者名 */
  @JsonProperty("name")
  private String name;
  /** 出演者名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;

}
