package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * リクエストパラメータ
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "api_id",
    "affiliate_id",
    "output"
})
public class Parameters {

  /** API_ID */
  @JsonProperty("api_id")
  public String apiId;
  /** アフィリエイトID */
  @JsonProperty("affiliate_id")
  public String affiliateId;
  /** 出力形式 */
  @JsonProperty("output")
  public String output;

}
