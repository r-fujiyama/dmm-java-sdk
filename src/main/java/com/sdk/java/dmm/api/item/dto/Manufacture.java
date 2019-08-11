package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 出版社、制作会社
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
public class Manufacture {

  /** 出版社、制作会社ID */
  @JsonProperty("id")
  private String id;
  /** 出版社、制作会社名 */
  @JsonProperty("name")
  private String name;

}
