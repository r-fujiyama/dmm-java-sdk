package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.List;
import lombok.Value;

/**
 * サンプル（小）リスト
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image"
})
public class SampleS {

  /** サンプル画像（小） */
  @JsonProperty("image")
  private List<String> image = Collections.emptyList();

}
