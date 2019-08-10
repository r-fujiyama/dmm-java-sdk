package com.sdk.java.dmm.api.genre.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * ジャンル情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "genre_id",
    "name",
    "ruby",
    "list_url"
})
public class Genre {

  /** ジャンルID */
  @JsonProperty("genre_id")
  public Long genreId;
  /** ジャンル名 */
  @JsonProperty("name")
  public String name;
  /** ジャンル名(読み仮名) */
  @JsonProperty("ruby")
  public String ruby;
  /** リストページURL（アフィリエイトID付き） */
  @JsonProperty("list_url")
  public String listUrl;

}
