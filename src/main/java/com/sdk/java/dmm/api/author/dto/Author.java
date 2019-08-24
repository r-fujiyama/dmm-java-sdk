package com.sdk.java.dmm.api.author.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 作者情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author_id",
    "name",
    "ruby",
    "list_url",
    "another_name"
})
public class Author {

  /** 作者ID */
  @JsonProperty("author_id")
  private String authorId;
  /** 作者名 */
  @JsonProperty("name")
  private String name;
  /** 作者名(読み仮名) */
  @JsonProperty("ruby")
  private String ruby;
  /** リストページURL（アフィリエイトID付き） */
  @JsonProperty("list_url")
  private String listUrl;
  /** 作者名別名 */
  @JsonProperty("another_name")
  private String anotherName;

}
