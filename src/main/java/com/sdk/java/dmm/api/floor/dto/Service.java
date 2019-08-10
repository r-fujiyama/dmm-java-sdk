package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Value;

/**
 * サービス情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "code",
    "floor"
})
public class Service {

  /** サービス名 */
  @JsonProperty("name")
  private String name;
  /** サービスコード */
  @JsonProperty("code")
  private String code;
  /** フロア情報 */
  @JsonProperty("floor")
  private List<Floor> floor = null;

}
