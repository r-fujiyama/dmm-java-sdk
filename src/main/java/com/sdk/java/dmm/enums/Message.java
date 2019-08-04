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
  M0002("M0002"),
  /** yyyy-MM-ddTHH:mm:ssの形式ではない、または存在しない日付です:{} */
  M0003("M0003"),
  /** サイトを設定してください */
  M0004("M0004"),
  /** フロアを指定する場合は、サービスを設定してください */
  M0005("M0005"),
  /** 絞りこみ項目と絞り込みIDを指定してください */
  M0006("M0006");

  /** エラーコード */
  private String value;

}
