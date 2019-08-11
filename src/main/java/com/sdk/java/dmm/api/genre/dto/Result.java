package com.sdk.java.dmm.api.genre.dto;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "result_count",
    "total_count",
    "first_position",
    "site_name",
    "site_code",
    "service_name",
    "service_code",
    "floor_id",
    "floor_name",
    "floor_code",
    "genre"
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
  /** サイト名 */
  @JsonProperty("site_name")
  private String siteName;
  /** サイトコード */
  @JsonProperty("site_code")
  private String siteCode;
  /** サービス名 */
  @JsonProperty("service_name")
  private String serviceName;
  /** サービスコード */
  @JsonProperty("service_code")
  private String serviceCode;
  /** フロアID */
  @JsonProperty("floor_id")
  private String floorId;
  /** フロア名 */
  @JsonProperty("floor_name")
  private String floorName;
  /** フロアコード */
  @JsonProperty("floor_code")
  private String floorCode;
  /** ジャンル情報 */
  @JsonProperty("genre")
  private List<Genre> genre = Collections.emptyList();

}
