package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.sdk.java.dmm.enums.Message;
import org.junit.jupiter.api.Test;

class MessagePropertiesTest {

  @Test
  void 正常系_getValue_キーのみ指定() {
    String actual = MessageProperties.getMsg(Message.M0001);
    assertThat(actual).isEqualTo("50音の文字列ではありません:{}");
  }

  @Test
  void 正常系_getMsg_バインドする文字列あり() {
    String actual = MessageProperties.getMsg(Message.M0001, "BIND");
    assertThat(actual).isEqualTo("50音の文字列ではありません:BIND");
  }

}