package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

  @Test
  public void 異常系_コンストラクタ() throws Exception {
    Constructor<StringUtil> constructor = StringUtil.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    assertThatThrownBy(() -> constructor.newInstance())
        .hasCause(new AssertionError("com.sdk.java.dmm.utils.StringUtil instances for you!"));
  }

  @Nested
  public class isNullOrEmpty {

    @Test
    public void 正常系_NULLの場合はTRUE() {
      assertThat(StringUtil.isNullOrEmpty(null)).isTrue();
    }

    @Test
    public void 正常系_空文字の場合はTRUE() {
      assertThat(StringUtil.isNullOrEmpty("")).isTrue();
    }

    @Test
    public void 正常系_半角スペースの場合はFALSE() {
      assertThat(StringUtil.isNullOrEmpty(" ")).isFalse();
    }

    @Test
    public void 正常系_NULLまたは空文字でない場合はFALSE() {
      assertThat(StringUtil.isNullOrEmpty("test")).isFalse();
    }

  }

  @Nested
  public class isAnyNullOrEmpty {

    @Test
    public void 正常系_NULLの場合はTRUE() {
      String[] strArray = null;
      assertThat(StringUtil.isAnyNullOrEmpty(strArray)).isTrue();
    }

    @Test
    public void 正常系_配列が0の場合() {
      assertThat(StringUtil.isAnyNullOrEmpty()).isTrue();
    }

    @Test
    public void 正常系_NULLが含まれる場合はTRUE() {
      assertThat(StringUtil.isAnyNullOrEmpty("test", null)).isTrue();
    }

    @Test
    public void 正常系_空文字が含まれる場合はTRUE() {
      assertThat(StringUtil.isAnyNullOrEmpty("test", "")).isTrue();
    }

    @Test
    public void 正常系_半角スペースが含まれる場合はTRUE() {
      assertThat(StringUtil.isAnyNullOrEmpty("test", " ")).isFalse();
    }

    @Test
    public void 正常系_NULLまたは空文字でない場合はFALSE() {
      assertThat(StringUtil.isAnyNullOrEmpty("test1", "test2")).isFalse();
    }

  }

  @Nested
  public class isBlank {

    @Test
    public void 正常系_NULLの場合はTRUE() {
      assertThat(StringUtil.isBlank(null)).isTrue();
    }

    @Test
    public void 正常系_空文字の場合はTRUE() {
      assertThat(StringUtil.isBlank("")).isTrue();
    }

    @Test
    public void 正常系_空白の場合はTRUE() {
      assertThat(StringUtil.isBlank(" ")).isTrue();
    }

    @Test
    public void 正常系_NULLまたは空白でない場合はFALSE() {
      assertThat(StringUtil.isBlank("test")).isFalse();
    }

  }

  @Nested
  public class isAnyBlank {

    @Test
    public void 正常系_NULLの場合はTRUE() {
      String[] strArray = null;
      assertThat(StringUtil.isAnyBlank(strArray)).isTrue();
    }

    @Test
    public void 正常系_配列が0の場合() {
      assertThat(StringUtil.isAnyBlank()).isTrue();
    }

    @Test
    public void 正常系_NULLが含まれる場合はTRUE() {
      assertThat(StringUtil.isAnyBlank("test", null)).isTrue();
    }

    @Test
    public void 正常系_空白の場合はTRUE() {
      assertThat(StringUtil.isAnyBlank("test", " ")).isTrue();
    }

    @Test
    public void 正常系_半角スペースの場合はTRUE() {
      assertThat(StringUtil.isAnyBlank("test", " ")).isTrue();
    }

    @Test
    public void 正常系_NULLまたは空白でない場合はFALSE() {
      assertThat(StringUtil.isAnyBlank("test1", "test2")).isFalse();
    }
  }

  @Nested
  public class isJapaneseSyllabary {

    @Test
    public void 正常系_50音の場合はTRUE() {
      assertThat(StringUtil.isJapaneseSyllabary("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん"))
          .isTrue();
    }

    @Test
    public void 正常系_NULLの場合はFALSE() {
      assertThat(StringUtil.isJapaneseSyllabary(null)).isFalse();
    }

    @Test
    public void 正常系_空文字の場合はFALSE() {
      assertThat(StringUtil.isJapaneseSyllabary("")).isFalse();
    }

    @Test
    public void 正常系_半角スペースの場合はFALSE() {
      assertThat(StringUtil.isJapaneseSyllabary(" ")).isFalse();
    }

    @Test
    public void 正常系_50音以外の場合はTRUE() {
      assertThat(StringUtil.isJapaneseSyllabary("aiueo")).isFalse();
    }

  }

  @Nested
  public class addParam {

    @Test
    public void 正常系_パラメータが付与されること() {
      assertThat(StringUtil.addParam("", "paramName", "paramVal")).isEqualTo("&paramName=paramVal");
    }

    @Test
    public void 正常系_パラメータが付与されないこと_paramNameがBlankの場合() {
      assertThat(StringUtil.addParam("NONE", " ", "paramVal")).isEqualTo("NONE");
    }

    @Test
    public void 正常系_パラメータが付与されないこと_paramValがBlankの場合() {
      assertThat(StringUtil.addParam("NONE", "paramName", " ")).isEqualTo("NONE");
    }

  }

}
