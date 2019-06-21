package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.api.DmmInfo;
import lombok.Data;

/**
 * 女優検索API実行結果
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "result"
})
public class ActressInfo implements DmmInfo<Request, Result> {

  /** リクエスト */
  @JsonProperty("request")
  private Request request;
  /** リザルト */
  @JsonProperty("result")
  private Result result;

}
