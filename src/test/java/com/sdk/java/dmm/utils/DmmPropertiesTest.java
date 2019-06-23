package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DmmPropertiesTest {

  @Test
  void 正常系_getValue_キーのみ指定_合致() {
    String actual = DmmProperties.getValue("API_ID");
    assertThat(!actual.isEmpty()).isTrue();
  }

  @Test
  void 正常系_getValue_キーのみ指定_非合致() {
    String actual = DmmProperties.getValue("NONE");
    assertThat(actual).isNull();
  }

}