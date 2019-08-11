package com.sdk.java.dmm.api.maker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * リクエスト
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "parameters"
})
public class Request {

  /** リクエストパラメータ */
  @JsonProperty("parameters")
  private Parameters parameters;

}
