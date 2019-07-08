package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * リストページURL(アフィリエイトID付き)
 */
@Getter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "digital",
    "monthly",
    "ppm",
    "mono",
    "rental"
})
public class ListURL {

  /** 動画 */
  @JsonProperty("digital")
  private String digital;
  /** 月額動画 見放題chプレミアム */
  @JsonProperty("monthly")
  private String monthly;
  /** 10円動画 */
  @JsonProperty("ppm")
  private String ppm;
  /** DVD通販 */
  @JsonProperty("mono")
  private String mono;
  /** DVDレンタル */
  @JsonProperty("rental")
  private String rental;

}
