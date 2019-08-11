package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DMM_APIを実行するためのURLを管理するEnum。
 */
@AllArgsConstructor
@Getter
public enum BaseURL implements CodeEnum<String> {

  /** 商品検索API */
  ITEM_SEARCH("https://api.dmm.com/affiliate/v3/ItemList?", "商品検索API"),
  /** 女優検索API */
  ACTRESS_SEARCH("https://api.dmm.com/affiliate/v3/ActressSearch?", "女優検索API"),
  /** ジャンル検索API */
  GENRE_SEARCH("https://api.dmm.com/affiliate/v3/GenreSearch?", "ジャンル検索API"),
  /** メーカー検索API */
  MAKER_SEARCH("https://api.dmm.com/affiliate/v3/MakerSearch?", "ジャンル検索API"),
  /** シリーズ検索API */
  SERIES_SEARCH("https://api.dmm.com/affiliate/v3/SeriesSearch?", "シリーズ検索API"),
  /** フロア検索API */
  FLOOR_SEARCH("https://api.dmm.com/affiliate/v3/FloorList?", "フロア検索API");

  /** URL */
  private String value;
  /** ラベル */
  private String label;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static BaseURL of(String value) {
    return CodeEnum.of(BaseURL.class, value);
  }

}
