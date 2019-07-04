package com.sdk.java.dmm.api.actress.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sdk.java.dmm.utils.DateTimeFormatConstants;
import java.time.LocalDate;
import lombok.Data;

/**
 * 女優情報
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ruby",
    "bust",
    "cup",
    "waist",
    "hip",
    "height",
    "birthday",
    "blood_type",
    "hobby",
    "prefectures",
    "imageURL",
    "listURL"
})
public class Actress {

  /** 女優ID */
  @JsonProperty("id")
  private Long id;
  /** 女優名 */
  @JsonProperty("name")
  private String name;
  /** 女優名（読み仮名） */
  @JsonProperty("ruby")
  private String ruby;
  /** バスト */
  @JsonProperty("bust")
  private Integer bust;
  /** カップ数 */
  @JsonProperty("cup")
  private String cup;
  /** ウェスト */
  @JsonProperty("waist")
  private Integer waist;
  /** ヒップ */
  @JsonProperty("hip")
  private Integer hip;
  /** 身長 */
  @JsonProperty("height")
  private Integer height;
  /** 生年月日 */
  @JsonProperty("birthday")
  @JsonFormat(pattern = DateTimeFormatConstants.uuuuMMdd_HYPHEN)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate birthday;
  /** 血液型 */
  @JsonProperty("blood_type")
  private String bloodType;
  /** 趣味 */
  @JsonProperty("hobby")
  private String hobby;
  /** 出身地 */
  @JsonProperty("prefectures")
  private String prefectures;
  /** 画像URL */
  @JsonProperty("imageURL")
  private ImageURL imageURL;
  /** リストページURL(アフィリエイトID付き) */
  @JsonProperty("listURL")
  private ListURL listURL;

}
