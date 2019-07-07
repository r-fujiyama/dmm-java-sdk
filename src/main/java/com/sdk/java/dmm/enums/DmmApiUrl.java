package com.sdk.java.dmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DMM_APIを実行するためのURLを管理するenum
 */
@AllArgsConstructor
@Getter
public enum DmmApiUrl {

  /** 女優検索URL */
  ACTRESS_SEARCH("https://api.dmm.com/affiliate/v3/ActressSearch?");

  /** URL */
  private String value;

}
