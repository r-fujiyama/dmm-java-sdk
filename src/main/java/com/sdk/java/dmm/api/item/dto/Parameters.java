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

  @JsonProperty("api_id")
  private String apiId;
  @JsonProperty("affiliate_id")
  private String affiliateId;
  @JsonProperty("site")
  private Site site;
  @JsonProperty("service")
  private String service;
  @JsonProperty("floor")
  private String floor;
  @JsonProperty("hits")
  private Integer hits;
  @JsonProperty("offset")
  private Integer offset;
  @JsonProperty("sort")
  private ItemSearchSort sort;
  @JsonProperty("keyword")
  private String keyword;
  @JsonProperty("cid")
  private String cid;
  @JsonProperty("article")
  private Article article;
  @JsonProperty("article_id")
  private Long articleId;
  @JsonProperty("gte_date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddTHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime gteDate;
  @JsonProperty("lte_date")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMddTHHmmss_HYPHEN)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime lteDate;
  @JsonProperty("mono_stock")
  private MonoStock monoStock;

}
