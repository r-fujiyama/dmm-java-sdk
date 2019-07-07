package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

class DateTimeFormatConstantsTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<DateTimeFormatConstants> constructor = DateTimeFormatConstants.class
        .getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(new AssertionError(
            "com.sdk.java.dmm.utils.DateTimeFormatConstants instances for you!"));
  }

}
