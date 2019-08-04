package com.sdk.java.dmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DMM_APIを実行するためのURLを管理するEnum。
 */
@AllArgsConstructor
@Getter
public enum BaseURL {

  /** 商品検索API */
  ITEM_SEARCH("https://api.dmm.com/affiliate/v3/ItemList?", "商品検索API"),
  /** 女優検索API */
  ACTRESS_SEARCH("https://api.dmm.com/affiliate/v3/ActressSearch?", "女優検索API");

  /** URL */
  private String value;
  /** 名前 */
  private String name;

}
