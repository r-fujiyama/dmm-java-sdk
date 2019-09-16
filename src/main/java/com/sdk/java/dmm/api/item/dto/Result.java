package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.List;
import lombok.Value;

/**
 * リザルト
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "message",
    "result_count",
    "total_count",
    "first_position",
    "items"
})
public class Result {

  /** ステータスコード */
  @JsonProperty("status")
  private Integer status;
  /** メッセージ */
  @JsonProperty("message")
  private String message;
  /** 取得件数 */
  @JsonProperty("result_count")
  private Integer resultCount;
  /** 全体件数 */
  @JsonProperty("total_count")
  private Long totalCount;
  /** 検索開始位置 */
  @JsonProperty("first_position")
  private Long firstPosition;
  /** 商品情報 */
  @JsonProperty("items")
  private List<Item> items = Collections.emptyList();

}
