package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用するサイトEnum。
 */
@AllArgsConstructor
@Getter
public enum Site implements CodeEnum<String> {

  /** DMM.com */
  DMM("DMM.com", "DMM.com"),
  /** FANZA */
  FANZA("FANZA", "FANZA");

  /** サイト */
  private String value;
  /** 名前 */
  private String name;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static Site of(String value) throws IllegalArgumentException {
    return CodeEnum.of(Site.class, value);
  }

}
