package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 監督
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby"
})
public class Director {

  /** 監督ID */
  @JsonProperty("id")
  private String id;
  /** 監督名 */
  @JsonProperty("name")
  private String name;
  /** 監督名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;

}
