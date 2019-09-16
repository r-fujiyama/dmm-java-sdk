package com.sdk.java.dmm.api.floor.dto;

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
    "site",
    "status",
    "message"
})
public class Result {

  /** ステータスコード */
  @JsonProperty("status")
  private Integer status;
  /** メッセージ */
  @JsonProperty("message")
  private String message;
  /** サイト情報 */
  @JsonProperty("site")
  private List<Site> site = Collections.emptyList();

}
