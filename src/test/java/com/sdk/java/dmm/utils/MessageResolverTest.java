package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.enums.Message;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

class MessageResolverTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<MessageResolver> constructor = MessageResolver.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(
            new AssertionError("com.sdk.java.dmm.utils.MessageProperties instances for you!"));
  }

  @Test
  void 正常系_getValue_キーのみ指定() {
    String actual = MessageResolver.getMessage(Message.M0004);
    assertThat(actual).isEqualTo("サイトを指定してください");
  }

  @Test
  void 正常系_getMsg_バインドする文字列あり() {
    String actual = MessageResolver.getMessage(Message.M0001, "test", "test");
    assertThat(actual).isEqualTo("test -> 50音の文字列ではありません -> value:test");
  }

}
