package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

public class DmmPropertiesTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<DmmProperties> constructor = DmmProperties.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(new AssertionError("com.sdk.java.dmm.utils.DmmProperties instances for you!"));
  }

  @Test
  public void 正常系_getValue_キーのみ指定_合致() {
    String actual = DmmProperties.getValue("API_ID");
    assertThat(!actual.isEmpty()).isTrue();
  }

  @Test
  public void 正常系_getValue_キーのみ指定_非合致() {
    String actual = DmmProperties.getValue("NONE");
    assertThat(actual).isNull();
  }

}
