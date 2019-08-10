package com.sdk.java.dmm.api.genre.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.enums.Output;
import lombok.Value;

@Value
@JsonIgnoreProperties("Genre")
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
  public String apiId;
  /** アフィリエイトID */
  @JsonProperty("affiliate_id")
  public String affiliateId;
  /** フロアID */
  @JsonProperty("floor_id")
  public Long floorId;
  /** 頭文字(50音) */
  @JsonProperty("initial")
  public String initial;
  /** 取得件数 */
  @JsonProperty("hits")
  public Integer hits;
  /** 検索開始位置 */
  @JsonProperty("offset")
  public Long offset;
  /** 出力形式 */
  @JsonProperty("output")
  public Output output;

}
