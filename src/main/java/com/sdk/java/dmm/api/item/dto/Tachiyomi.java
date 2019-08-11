package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * 立ち読み
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "URL",
    "affiliateURL"
})
public class Tachiyomi {

  /** 立ち読みページURL */
  @JsonProperty("URL")
  private String URL;
  /** 立ち読みアフィリエイトリンクURL */
  @JsonProperty("affiliateURL")
  private String affiliateURL;

}
