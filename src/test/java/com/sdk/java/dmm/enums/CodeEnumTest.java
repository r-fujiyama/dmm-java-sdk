package com.sdk.java.dmm.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

public class CodeEnumTest {

  @Test
  public void 正常系_ofメソッド() {
    Animal lion = Animal.of("lion");
    assertThat(lion).isEqualTo(Animal.LION);
    Animal zebra = Animal.of("zebra");
    assertThat(zebra).isEqualTo(Animal.ZEBRA);
    Animal elephant = Animal.of("elephant");
    assertThat(elephant).isEqualTo(Animal.ELEPHANT);
  }

  @Test
  public void 異常系_ofメソッド() {
    assertThatThrownBy(() -> Animal.of("none"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("com.sdk.java.dmm.enums.CodeEnumTest$Animal:none");
  }

  @Getter
  @AllArgsConstructor
  public enum Animal implements CodeEnum<String> {

    LION("lion"),
    ZEBRA("zebra"),
    ELEPHANT("elephant");

    private String value;

    public static Animal of(String value) {
      return CodeEnum.of(Animal.class, value);
    }

  }

}
