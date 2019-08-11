package com.sdk.java.dmm.api.floor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.List;
import lombok.Value;

/**
 * サイト情報
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "code",
    "service"
})
public class Site {

  /** サイト名 */
  @JsonProperty("name")
  private String name;
  /** サイトコード */
  @JsonProperty("code")
  private String code;
  /** サービス情報 */
  @JsonProperty("service")
  private List<Service> service = Collections.emptyList();

}
