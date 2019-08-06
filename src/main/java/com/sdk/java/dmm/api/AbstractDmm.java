package com.sdk.java.dmm.api;

import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.utils.DmmProperties;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

/**
 * 全てのDMM_API実行クラスが継承しなければならない抽象クラス。
 *
 * @param <T> APIより返却されるJSONのマッピング対象となるDTO
 */
@Slf4j
public abstract class AbstractDmm<T extends DmmInfo> {

  /** API_ID */
  private static final String API_ID = DmmProperties.getValue("API_ID");
  /** アフェリエイトID */
  private static final String AFFILIATE_ID = DmmProperties.getValue("AFFILIATE_ID");

  /**
   * APIを実行しJSONを取得する。<br>
   *
   * @return JSON
   */
  public String getJson() {
    String json = this.connectToUrl();
    log.info("execution end {}_API JSON:{}", this.getBaseURL(), json);
    return json;
  }

  /**
   * APIを実行し結果を取得する。
   *
   * @return API実行結果DTO
   */
  public T execute() {
    T result = JsonUtil.read(this.connectToUrl(), this.getResultClass());
    log.info("execution end {}_API dto-info:<{}>", this.getBaseURL(), result.toString());
    return result;
  }

  /**
   * 　URLのHTMLを文字列で取得する。
   *
   * @return 指定されたURLのHTML文字列
   */
  private String connectToUrl() {
    log.info("execution start {}_API", this.getBaseURL());
    String executeURL = StringUtil.addParam(this.getBaseURL().getValue(), "api_id", API_ID);
    executeURL = StringUtil.addParam(executeURL, "affiliate_id", AFFILIATE_ID);
    executeURL += this.getParam();
    URL objURL;
    try {
      objURL = new URL(executeURL);
    } catch (MalformedURLException e) {
      throw new UncheckedIOException("不正なURLです:" + executeURL, e);
    }
    log.info("execute {}_API URL:{}", this.getBaseURL(), executeURL);
    try (InputStream is = objURL.openStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr)) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      return json;
    } catch (IOException e) {
      throw new UncheckedIOException("APIの実行に失敗しました:" + executeURL, e);
    }
  }

  /**
   * パラメータをクリアする。
   */
  public abstract void clear();

  /**
   * APIを実行するためのパラメータを取得する。
   *
   * @return パラメータ
   */
  protected abstract String getParam();

  /**
   * DMM_APIを実行するためのURLを管理するEnumを返却する。
   *
   * @return BaseURL
   */
  protected abstract BaseURL getBaseURL();

  /**
   * APIより返却されるJSONのマッピング対象となるDTOのClassオブジェクトを取得する。
   *
   * @return classオブジェクト
   */
  protected abstract Class<T> getResultClass();

}
