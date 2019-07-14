package com.sdk.java.dmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * message.propertiesのキーを管理するEnum。
 */
@AllArgsConstructor
@Getter
public enum Message {

  /** 50音の文字列ではありません:{} */
  M0001("M0001"),
  /** yyyy-mm-ddの形式ではない、または存在しない日付です:{} */
  M0002("M0002");

  /** エラーコード */
  private String value;

}
