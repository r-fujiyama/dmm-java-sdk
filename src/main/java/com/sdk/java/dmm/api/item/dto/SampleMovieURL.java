package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sdk.java.dmm.enums.Flag;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "size_476_306",
    "size_560_360",
    "size_644_414",
    "size_720_480",
    "pc_flag",
    "sp_flag"
})
public class SampleMovieURL {

  @JsonProperty("size_476_306")
  private String size_476_306;
  @JsonProperty("size_560_360")
  private String size_560_360;
  @JsonProperty("size_644_414")
  private String size_644_414;
  @JsonProperty("size_720_480")
  private String size_720_480;
  @JsonProperty("pc_flag")
  private Flag pcFlag;
  @JsonProperty("sp_flag")
  private Flag spFlag;

}
