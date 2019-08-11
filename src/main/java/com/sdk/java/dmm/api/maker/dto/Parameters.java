package com.sdk.java.dmm.api.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.enums.Output;
import lombok.Value;

/**
 * リクエストパラメータ
 */
@Value
@JsonIgnoreProperties("Maker")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "api_id",
    "affiliate_id",
    "floor_id",
    "initial",
    "hits",
    "offset",
    "output"
})
public class Parameters {

  /** API_ID */
  @JsonProperty("api_id")
  private String apiId;
  /** アフィリエイトID */
  @JsonProperty("affiliate_id")
  private String affiliateId;
  /** フロアID */
  @JsonProperty("floor_id")
  private String floorId;
  /** 頭文字(50音) */
  @JsonProperty("initial")
  private String initial;
  /** 取得件数 */
  @JsonProperty("hits")
  private Integer hits;
  /** 検索開始位置 */
  @JsonProperty("offset")
  private Long offset;
  /** 出力形式 */
  @JsonProperty("output")
  private Output output;

}
