package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.api.DmmInfo;
import lombok.Value;

/**
 * フロアAPI実行結果
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "result"
})
public class FloorSearchResult implements DmmInfo<Request, Result> {

  /** リクエスト */
  @JsonProperty("request")
  private Request request;
  /** リザルト */
  @JsonProperty("result")
  private Result result;

}
