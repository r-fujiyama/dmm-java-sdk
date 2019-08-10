package com.sdk.java.dmm.api.genre.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.api.DmmInfo;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "result"
})
public class GenreSearchResult implements DmmInfo<Request, Result> {

  /** リクエスト */
  @JsonProperty("request")
  public Request request;
  /** リザルト */
  @JsonProperty("result")
  public Result result;

}
