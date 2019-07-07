package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Constructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class JsonUtilTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<JsonUtil> constructor = JsonUtil.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(new AssertionError("com.sdk.java.dmm.utils.JsonUtil instances for you!"));
  }

  @Test
  public void 正常系_readJson() {
    Dto actual = JsonUtil.read("{\"test\":\"test\"}", Dto.class);
    Dto expected = new Dto("test");
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_readWrite() {
    Dto dto = new Dto("test");
    String actual = JsonUtil.write(dto);
    assertThat(actual).isEqualTo("{\"test\":\"test\"}");
  }

  @EqualsAndHashCode
  @AllArgsConstructor
  @NoArgsConstructor
  private static class Dto {

    @JsonProperty("test")
    String test;

  }

}
