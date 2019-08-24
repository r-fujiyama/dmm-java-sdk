package com.sdk.java.dmm.api.author.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.api.DmmInfo;
import lombok.Value;

/**
 * 作者検索API実行結果
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "result"
})
public class AuthorSearchResult implements DmmInfo {

  /** リクエスト */
  @JsonProperty("request")
  private Request request;
  /** リザルト */
  @JsonProperty("result")
  private Result result;

}
