package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.enums.Message;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

class MessagePropertiesTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<MessageProperties> constructor = MessageProperties.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(
            new AssertionError("com.sdk.java.dmm.utils.MessageProperties instances for you!"));
  }

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
