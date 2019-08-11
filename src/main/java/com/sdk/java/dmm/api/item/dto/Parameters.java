package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sdk.java.dmm.enums.Article;
import com.sdk.java.dmm.enums.ItemSearchSort;
import com.sdk.java.dmm.enums.MonoStock;
import com.sdk.java.dmm.enums.Site;
import com.sdk.java.dmm.utils.DateTimeFormatConstants;
import java.time.LocalDateTime;
import lombok.Value;

/**
 * リクエストパラメータ
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "api_id",
    "affiliate_id",
    "site",
    "service",
    "floor",
    "hits",
    "offset",
    "sort",
    "keyword",
    "cid",
    "article",
    "articleId",
    "gte_date",
    "lte_date",
    "mono_stock"
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
  private Site site;
  /** サービス */
  @JsonProperty("service")
  private String service;
  /** フロア */
  @JsonProperty("floor")
  private String floor;
  /** 取得件数 */
  @JsonProperty("hits")
  private Integer hits;
  /** 検索開始位置 */
  @JsonProperty("offset")
  private Integer offset;
  /** ソート順 */
  @JsonProperty("sort")
  private ItemSearchSort sort;
  /** キーワード */
  @JsonProperty("keyword")
  private String keyword;
  /** 商品ID */
  @JsonProperty("cid")
  private String cid;
  /** 絞りこみ項目 */
  @JsonProperty("article")
  private Article article;
  /** 絞り込みID */
  @JsonProperty("article_id")
  private String articleId;
  /** 発売日絞り込み_以上 */
  @JsonProperty("gte_date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddTHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime gteDate;
  /** 発売日絞り込み_以下 */
  @JsonProperty("lte_date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddTHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime lteDate;
  /** 在庫絞り込み */
  @JsonProperty("mono_stock")
  private MonoStock monoStock;

}
