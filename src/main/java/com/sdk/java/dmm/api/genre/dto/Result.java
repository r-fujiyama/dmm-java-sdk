package com.sdk.java.dmm.api.genre.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Value;

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
  public Integer status;
  /** 取得件数 */
  @JsonProperty("result_count")
  public Integer resultCount;
  /** 全体件数 */
  @JsonProperty("total_count")
  public Long totalCount;
  /** 検索開始位置 */
  @JsonProperty("first_position")
  public Long firstPosition;
  /** サイト名 */
  @JsonProperty("site_name")
  public String siteName;
  /** サイトコード */
  @JsonProperty("site_code")
  public String siteCode;
  /** サービス名 */
  @JsonProperty("service_name")
  public String serviceName;
  /** サービスコード */
  @JsonProperty("service_code")
  public String serviceCode;
  /** フロアID */
  @JsonProperty("floor_id")
  public Long floorId;
  /** フロア名 */
  @JsonProperty("floor_name")
  public String floorName;
  /** フロアコード */
  @JsonProperty("floor_code")
  public String floorCode;
  /** ジャンル情報 */
  @JsonProperty("genre")
  public List<Genre> genre = null;

}
