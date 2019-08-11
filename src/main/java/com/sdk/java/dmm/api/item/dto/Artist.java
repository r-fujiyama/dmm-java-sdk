package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * アーティスト
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby"
})
public class Artist {

  /** アーティストID */
  @JsonProperty("id")
  private String id;
  /** アーティスト名 */
  @JsonProperty("name")
  private String name;
  /** アーティスト名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;

}
