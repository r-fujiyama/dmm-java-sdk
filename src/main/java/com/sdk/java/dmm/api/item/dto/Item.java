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

  @JsonProperty("service_code")
  private String serviceCode;
  @JsonProperty("service_name")
  private String serviceName;
  @JsonProperty("floor_code")
  private String floorCode;
  @JsonProperty("floor_name")
  private String floorName;
  @JsonProperty("category_name")
  private String categoryName;
  @JsonProperty("detail_category")
  private DetailCategory detailCategory;
  @JsonProperty("content_id")
  private String contentId;
  @JsonProperty("product_id")
  private String productId;
  @JsonProperty("title")
  private String title;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("number")
  private String number;
  @JsonProperty("review")
  private Review review;
  @JsonProperty("URL")
  private String URL;
  @JsonProperty("affiliateURL")
  private String affiliateURL;
  @JsonProperty("URLsp")
  private String URLsp;
  @JsonProperty("affiliateURLsp")
  private String affiliateURLsp;
  @JsonProperty("imageURL")
  private ImageURL imageURL;
  @JsonProperty("tachiyomi")
  private Tachiyomi tachiyomi;
  @JsonProperty("sampleImageURL")
  private SampleImageURL sampleImageURL;
  @JsonProperty("sampleMovieURL")
  private SampleMovieURL sampleMovieURL;
  @JsonProperty("prices")
  private Prices prices;
  @JsonProperty("date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime date;
  @JsonProperty("iteminfo")
  private ItemInfo iteminfo;
  @JsonProperty("jancode")
  private String jancode;
  @JsonProperty("maker_product")
  private String makerProduct;
  @JsonProperty("isbn")
  private String isbn;
  @JsonProperty("stock")
  private String stock;
  @JsonProperty("cdinfo")
  private Cdinfo cdinfo;

}
