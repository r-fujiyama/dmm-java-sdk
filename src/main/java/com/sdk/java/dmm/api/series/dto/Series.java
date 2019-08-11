package com.sdk.java.dmm.api.series.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * シリーズ情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "series_id",
    "name",
    "ruby",
    "list_url"
})
public class Series {

  /** シリーズID */
  @JsonProperty("series_id")
  private String seriesId;
  /** シリーズ名 */
  @JsonProperty("name")
  private String name;
  /** シリーズ名(読み仮名) */
  @JsonProperty("ruby")
  private String ruby;
  /** リストページURL（アフィリエイトID付き） */
  @JsonProperty("list_url")
  private String listUrl;

}
