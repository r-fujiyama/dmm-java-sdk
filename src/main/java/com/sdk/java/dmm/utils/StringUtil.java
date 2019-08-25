package com.sdk.java.dmm.utils;

import com.sdk.java.dmm.enums.CodeEnum;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文字列操作のためのクラスです。
 */
public final class StringUtil {

  /** 五十音 */
  public static final String JAPANESE_SYLLABARY_MATCHES = "^[\\u3042\\u3044\\u3046\\u3048\\u304A"
      + "\\u304B\\u304D\\u304F\\u3051\\u3053\\u3055\\u3057\\u3059\\u305B\\u305D\\u305F\\u3061"
      + "\\u3064\\u3066\\u3068\\u306A\\u306B\\u306C\\u306D\\u306E\\u306F\\u3072\\u3075\\u3078"
      + "\\u307B\\u307E\\u307F\\u3080\\u3081\\u3082\\u3084\\u3086\\u3088\\u3089\\u308A\\u308B"
      + "\\u308C\\u308D\\u308F\\u3092\\u3093]+$";

  /**
   * コンストラクタ
   */
  private StringUtil() {
    throw new AssertionError("com.sdk.java.dmm.utils.StringUtil instances for you!");
  }

  /**
   * 文字列が{@code null}または空文字であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   * <pre>
   * StringUtil.isEmpty(null)      = true
   * StringUtil.isEmpty("")        = true
   * StringUtil.isEmpty(" ")       = false
   * StringUtil.isEmpty("bob")     = false
   * StringUtil.isEmpty("  bob  ") = false
   * </pre>
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  /**
   * 何れかの文字列が{@code null}または空文字であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   * <pre>
   * StringUtil.isAnyNullOrEmpty(null, "bob")           = true
   * StringUtil.isAnyNullOrEmpty("", "bob")             = true
   * StringUtil.isAnyNullOrEmpty(" ", "bob")            = false
   * StringUtil.isAnyNullOrEmpty("bob", "john")         = false
   * StringUtil.isAnyNullOrEmpty("  bob  ", "  john  ") = false
   * </pre>
   *
   * @param strArray 文字列
   * @return boolean
   */
  public static boolean isAnyNullOrEmpty(String... strArray) {
    if (strArray == null || strArray.length == 0) {
      return true;
    }
    for (String str : strArray) {
      if (isNullOrEmpty(str)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 文字列が{@code null}、空文字、空白であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   * <pre>
   * StringUtil.isBlank(null, "bob")       = true
   * StringUtil.isBlank("", "bob")         = true
   * StringUtil.isBlank(" ", "bob")        = true
   * StringUtil.isBlank("bob", "john")     = false
   * StringUtil.isBlank("  bob  ", "john") = false
   * </pre>
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isBlank(String str) {
    if (isNullOrEmpty(str)) {
      return true;
    }
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isWhitespace(str.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * 何れかの文字列が{@code null}、空文字、空白であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   *
   * <pre>
   * StringUtil.isAnyBlank(null)      = true
   * StringUtil.isAnyBlank("")        = true
   * StringUtil.isAnyBlank(" ")       = true
   * StringUtil.isAnyBlank("bob")     = false
   * StringUtil.isAnyBlank("  bob  ") = false
   * </pre>
   *
   * @param strArray 文字列
   * @return boolean
   */
  public static boolean isAnyBlank(String... strArray) {
    if (strArray == null || strArray.length == 0) {
      return true;
    }
    for (String str : strArray) {
      if (isBlank(str)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 文字列が五十音の場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   * <pre>
   * StringUtil.isJapaneseSyllabary("あいうえお") = true
   * StringUtil.isJapaneseSyllabary("aiueo")     = false
   * StringUtil.isJapaneseSyllabary("")          = false
   * StringUtil.isJapaneseSyllabary(" ")         = false
   * StringUtil.isJapaneseSyllabary(null)        = false
   * </pre>
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isJapaneseSyllabary(String str) {
    if (str == null) {
      return false;
    }
    return str.matches(JAPANESE_SYLLABARY_MATCHES);
  }

  /**
   * パラメータを付与する。<br>
   * <pre>
   * StringUtil.addParam("&amp;paramName1=paramVal1", "paramName2", "paramVal2") = "&amp;paramName1=paramVal1&amp;paramName2=paramVal2"
   * StringUtil.addParam("", "paramName", "paramVal")                        = "&amp;paramName=paramVal"
   * StringUtil.addParam(" ", "paramName", "paramVal")                       = " &amp;paramName=paramVal"
   * StringUtil.addParam(null, "paramName", "paramVal")                      = "null&amp;paramName=paramVal"
   * StringUtil.addParam("not add", null, "paramVal")                        = "not add"
   * StringUtil.addParam("not add", "paramName", null)                       = "not add"
   * </pre>
   *
   * @param str       パラメータを付与する文字列
   * @param paramName パラメータ名
   * @param paramVal  パラメータ値
   * @return パラーメタを付与した文字列
   */
  public static String addParam(String str, String paramName, String paramVal) {
    if (isAnyBlank(paramName, paramVal)) {
      return str;
    }
    return str + "&" + paramName + "=" + paramVal;
  }

  /**
   * パラメータを付与する。<br>
   * <pre>
   * StringUtil.addParam("&amp;paramName1=paramVal1", "paramName2", "paramVal2") = "&amp;paramName1=paramVal1&amp;paramName2=paramVal2"
   * StringUtil.addParam("", "paramName", "paramVal")                        = "&amp;paramName=paramVal"
   * StringUtil.addParam(" ", "paramName", "paramVal")                       = " &amp;paramName=paramVal"
   * StringUtil.addParam(null, "paramName", "paramVal")                      = "null&amp;paramName=paramVal"
   * StringUtil.addParam("not add", null, "paramVal")                        = "not add"
   * StringUtil.addParam("not add", "paramName", null)                       = "not add"
   * </pre>
   *
   * @param str       パラメータを付与する文字列
   * @param paramName パラメータ名
   * @param paramVal  パラメータ値
   * @return パラーメタを付与した文字列
   */
  public static String addParam(String str, String paramName, Number paramVal) {
    if (isBlank(paramName) || paramVal == null) {
      return str;
    }
    return str + "&" + paramName + "=" + paramVal;
  }

  /**
   * パラメータを付与する。<br>
   * <pre>
   * StringUtil.addParam("&amp;paramName1=paramVal1", "paramName2", "paramVal2") = "&amp;paramName1=paramVal1&amp;paramName2=paramVal2"
   * StringUtil.addParam("", "paramName", "paramVal")                        = "&amp;paramName=paramVal"
   * StringUtil.addParam(" ", "paramName", "paramVal")                       = " &amp;paramName=paramVal"
   * StringUtil.addParam(null, "paramName", "paramVal")                      = "null&amp;paramName=paramVal"
   * StringUtil.addParam("not add", null, "paramVal")                        = "not add"
   * StringUtil.addParam("not add", "paramName", null)                       = "not add"
   * </pre>
   *
   * @param str       パラメータを付与する文字列
   * @param paramName パラメータ名
   * @param paramVal  パラメータ値
   * @return パラーメタを付与した文字列
   */
  public static String addParam(String str, String paramName, CodeEnum paramVal) {
    if (isBlank(paramName) || paramVal == null) {
      return str;
    }
    return str + "&" + paramName + "=" + paramVal.getValue();
  }

  /**
   * 文字列をUTF8にエンコードする。
   *
   * @param str 文字列
   * @return UTF8にエンコードされた文字列
   */
  public static String URLEncode(String str) {
    if (isNullOrEmpty(str)) {
      return str;
    }
    return URLEncoder.encode(str, StandardCharsets.UTF_8);
  }

}
