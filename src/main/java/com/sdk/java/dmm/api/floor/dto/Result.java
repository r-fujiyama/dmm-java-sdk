package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Value;

/**
 * リザルト
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "site"
})
public class Result {

  /** サイト情報 */
  @JsonProperty("site")
  public List<Site> site = null;

}
