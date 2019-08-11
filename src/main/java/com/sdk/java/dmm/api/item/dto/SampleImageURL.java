package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

/**
 * サンプル画像URL
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sample_s"
})
public class SampleImageURL {

  /** サンプル（小）リスト */
  @JsonProperty("sample_s")
  private SampleS sampleS;

}
