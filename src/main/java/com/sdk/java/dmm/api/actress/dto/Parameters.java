package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.utils.DateFormat;
import java.time.LocalDate;
import lombok.Data;

/**
 * リクエストパラメータ
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "api_id",
    "affiliate_id",
    "site",
    "initial",
    "actress_id",
    "keyword",
    "gte_bust",
    "lte_bust",
    "gte_waist",
    "lte_waist",
    "gte_hip",
    "lte_hip",
    "gte_height",
    "lte_height",
    "gte_birthday",
    "lte_birthday",
    "hits",
    "offset",
    "sort",
    "output"
})
public class Parameters {

  /** API_ID */
  @JsonProperty("api_id")
  private String apiId;
  /** アフィリエイトID */
  @JsonProperty("affiliate_id")
  private String affiliateId;
  /** サイト */
  @JsonProperty("site")
  private String site;
  /** 女優名の頭文字50音 */
  @JsonProperty("initial")
  private String initial;
  /** 女優ID */
  @JsonProperty("actress_id")
  private Long actressId;
  /** キーワード */
  @JsonProperty("keyword")
  private String keyword;
  /** バスト(以上) */
  @JsonProperty("gte_bust")
  private Integer gteBust;
  /** バスト(以下) */
  @JsonProperty("lte_bust")
  private Integer lteBust;
  /** ウエスト(以上) */
  @JsonProperty("gte_waist")
  private Integer gteWaist;
  /** ウエスト(以下) */
  @JsonProperty("lte_waist")
  private Integer lteWaist;
  /** ヒップ(以上) */
  @JsonProperty("gte_hip")
  private Integer gteHip;
  /** ヒップ(以下) */
  @JsonProperty("lte_hip")
  private Integer lteHip;
  /** 身長(以上) */
  @JsonProperty("gte_height")
  private Integer gteHeight;
  /** 身長(以下) */
  @JsonProperty("lte_height")
  private Integer lteHeight;
  /** 生年月日(以上) */
  @JsonProperty("gte_birthday")
  @JsonFormat(pattern = DateFormat.CONST_uuuuMMdd_HYPHEN)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate gteBirthday;
  /** 生年月日_以下 */
  @JsonProperty("lte_birthday")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonFormat(pattern = DateFormat.CONST_uuuuMMdd_HYPHEN)
  private LocalDate lteBirthday;
  /** 取得件数 */
  @JsonProperty("hits")
  private Integer hits;
  /** 検索開始位置 */
  @JsonProperty("offset")
  private Long offset;
  /** ソート順 */
  @JsonProperty("sort")
  private ActressSearchSort sort;
  /** 出力形式 */
  @JsonProperty("output")
  private Output output;

}
