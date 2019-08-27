package com.sdk.java.dmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * message.propertiesのキーを管理する列挙型
 */
@AllArgsConstructor
@Getter
public enum Message {

  /** {} -&gt; 50音の文字列ではありません -&gt; value:{} */
  M0001("M0001"),
  /** {} -&gt; yyyy-mm-ddの形式ではない、または存在しない日付です -&gt; value:{} */
  M0002("M0002"),
  /** {} -&gt; yyyy-MM-ddTHH:mm:ssの形式ではない、または存在しない日付です -&gt; value:{} */
  M0003("M0003"),
  /** サイトを指定してください */
  M0004("M0004"),
  /** フロアを指定する場合は、サービスを設定してください */
  M0005("M0005"),
  /** 絞りこみ項目と絞り込みIDを指定してください */
  M0006("M0006"),
  /** フロアIDを指定してください */
  M0007("M0007"),
  /** {} -&gt; 0は指定できません */
  M0008("M0008");

  /** 値 */
  private String value;

}
