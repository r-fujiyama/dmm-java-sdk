package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.enums.Flag;
import lombok.Value;

/**
 * サンプル動画URL
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "size_476_306",
    "size_560_360",
    "size_644_414",
    "size_720_480",
    "pc_flag",
    "sp_flag"
})
public class SampleMovieURL {

  /** 476×306 */
  @JsonProperty("size_476_306")
  private String size_476_306;
  /** 560×360 */
  @JsonProperty("size_560_360")
  private String size_560_360;
  /** 644×414 */
  @JsonProperty("size_644_414")
  private String size_644_414;
  /** 720×480 */
  @JsonProperty("size_720_480")
  private String size_720_480;
  /** PC対応しているか */
  @JsonProperty("pc_flag")
  private Flag pcFlag;
  /** スマホ対応しているか */
  @JsonProperty("sp_flag")
  private Flag spFlag;

}
