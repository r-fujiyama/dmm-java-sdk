package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sdk.java.dmm.utils.DateTimeFormatConstants;
import java.time.LocalDateTime;
import lombok.Value;

/**
 * 商品情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceCode",
    "serviceName",
    "floorCode",
    "floorName",
    "categoryName",
    "detailCategory",
    "contentId",
    "productId",
    "title",
    "volume",
    "number",
    "review",
    "URL",
    "affiliateURL",
    "URLsp",
    "affiliateURLsp",
    "imageURL",
    "tachiyomi",
    "sampleImageURL",
    "sampleMovieURL",
    "prices",
    "date",
    "iteminfo",
    "jancode",
    "makerProduct",
    "isbn",
    "stock",
    "cdinfo"
})
public class Item {

  /** サービスコード */
  @JsonProperty("service_code")
  private String serviceCode;
  /** サービス名 */
  @JsonProperty("service_name")
  private String serviceName;
  /** フロアコード */
  @JsonProperty("floor_code")
  private String floorCode;
  /** フロア名 */
  @JsonProperty("floor_name")
  private String floorName;
  /** カテゴリ名 */
  @JsonProperty("category_name")
  private String categoryName;
  /** カテゴリー詳細 */
  @JsonProperty("detail_category")
  private DetailCategory detailCategory;
  /** 商品ID */
  @JsonProperty("content_id")
  private String contentId;
  /** 品番 */
  @JsonProperty("product_id")
  private String productId;
  /** タイトル */
  @JsonProperty("title")
  private String title;
  /** 収録時間 or ページ数 */
  @JsonProperty("volume")
  private String volume;
  /** 巻数 */
  @JsonProperty("number")
  private String number;
  /** レビュー平均点 */
  @JsonProperty("review")
  private Review review;
  /** 商品ページURL */
  @JsonProperty("URL")
  private String URL;
  /** アフィリエイトリンクURL */
  @JsonProperty("affiliateURL")
  private String affiliateURL;
  /** スマホ向け商品ページURL */
  @JsonProperty("URLsp")
  private String URLsp;
  /** スマホ向けアフィリエイトリンクURL */
  @JsonProperty("affiliateURLsp")
  private String affiliateURLsp;
  /** 画像URL */
  @JsonProperty("imageURL")
  private ImageURL imageURL;
  /** 立ち読み */
  @JsonProperty("tachiyomi")
  private Tachiyomi tachiyomi;
  /** サンプル画像URL */
  @JsonProperty("sampleImageURL")
  private SampleImageURL sampleImageURL;
  /** サンプル動画URL */
  @JsonProperty("sampleMovieURL")
  private SampleMovieURL sampleMovieURL;
  /** 価格 */
  @JsonProperty("prices")
  private Prices prices;
  /** 発売日、配信開始日、貸出開始日 */
  @JsonProperty("date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime date;
  /** 商品詳細 */
  @JsonProperty("iteminfo")
  private ItemInfo iteminfo;
  /** JANコード */
  @JsonProperty("jancode")
  private String jancode;
  /** メーカー品番 */
  @JsonProperty("maker_product")
  private String makerProduct;
  /** ISBN */
  @JsonProperty("isbn")
  private String isbn;
  /** 在庫状況 */
  @JsonProperty("stock")
  private String stock;
  /** CD情報 */
  @JsonProperty("cdinfo")
  private CdInfo cdInfo;

}
