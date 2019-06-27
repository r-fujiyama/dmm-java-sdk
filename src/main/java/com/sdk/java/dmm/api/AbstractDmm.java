package com.sdk.java.dmm.api;

import com.sdk.java.dmm.enums.DmmApi;
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
  /** JSON */
  private String json;

  /**
   * JSONを取得する。<br>
   * {@code execute()}を実行後、JSONが取得可能。
   *
   * @return JSON
   */
  public String getJson() {
    return this.json;
  }

  /**
   * APIを実行するためのパラメータを取得する。
   *
   * @return パラメータ
   */
  protected abstract String getParam();

  /**
   * パラメータをクリアする。
   */
  public abstract void clear();

  /**
   * DMM_APIを実行するためのURLを管理するenumを返却
   *
   * @return DMM_APIを実行するためのURLを管理するenum
   */
  protected abstract DmmApi getDmmAPI();

  /**
   * APIより返却されるJSONのマッピング対象となるDTOのClassオブジェクトを取得する。
   *
   * @return classオブジェクト
   */
  protected abstract Class<T> getInfoClass();

  /**
   * APIを実行し結果を取得する。
   *
   * @return 実行結果
   */
  public T execute() {
    log.info("execution start {}_API", this.getDmmAPI());
    String executeURL = StringUtil.addParam(this.getDmmAPI().getValue(), "api_id", API_ID);
    executeURL = StringUtil.addParam(executeURL, "affiliate_id", AFFILIATE_ID);
    executeURL += this.getParam();
    URL objURL;
    try {
      objURL = new URL(executeURL);
    } catch (MalformedURLException e) {
      throw new UncheckedIOException("不正なURLです:" + executeURL, e);
    }
    log.info("execute {}_API URL:{}", this.getDmmAPI(), executeURL);
    try (InputStream is = objURL.openStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr)) {
      this.json = "";
      String line = reader.readLine();
      while (line != null) {
        this.json += line;
        line = reader.readLine();
      }
      T result = JsonUtil.read(this.json, getInfoClass());
      log.info("execution end {}_API", this.getDmmAPI());
      return result;
    } catch (IOException e) {
      throw new UncheckedIOException("APIの実行に失敗しました:" + executeURL, e);
    }
  }

}
