package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Data;

/**
 * リザルト
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "result_count",
    "total_count",
    "first_position",
    "actress"
})
public class Result {

  /** ステータスコード */
  @JsonProperty("status")
  private Integer status;
  /** 取得件数 */
  @JsonProperty("result_count")
  private Integer resultCount;
  /** 全体件数 */
  @JsonProperty("total_count")
  private Long totalCount;
  /** 検索開始位置 */
  @JsonProperty("first_position")
  private Long firstPosition;
  /** 女優情報 */
  @JsonProperty("actress")
  private List<Actress> actress = null;

}
