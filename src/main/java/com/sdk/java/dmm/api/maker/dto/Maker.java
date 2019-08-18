package com.sdk.java.dmm.api.maker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * メーカー情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maker_id",
    "name",
    "ruby",
    "list_url",
    "another_name"
})
public class Maker {

  /** メーカーID */
  @JsonProperty("maker_id")
  private String makerId;
  /** メーカー名 */
  @JsonProperty("name")
  private String name;
  /** メーカー名(読み仮名) */
  @JsonProperty("ruby")
  private String ruby;
  /** リストページURL（アフィリエイトID付き） */
  @JsonProperty("list_url")
  private String listUrl;
  /** メーカー名別名 */
  @JsonProperty("another_name")
  private String anotherName;

}
