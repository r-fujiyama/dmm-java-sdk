package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 作家、原作者、著者
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby"
})
public class Author {

  /** 作家、原作者、著者ID */
  @JsonProperty("id")
  private String id;
  /** 作家、原作者、著者名 */
  @JsonProperty("name")
  private String name;
  /** 作家、原作者、著者名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;

}
