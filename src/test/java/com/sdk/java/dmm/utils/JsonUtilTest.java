package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class JsonUtilTest {

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
