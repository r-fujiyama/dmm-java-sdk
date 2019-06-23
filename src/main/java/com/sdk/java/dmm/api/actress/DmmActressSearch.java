package com.sdk.java.dmm.api.actress;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.actress.dto.ActressInfo;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.DmmApi;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.utils.DateFormat;
import com.sdk.java.dmm.utils.StringUtil;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 女優検索を実行するためのクラス。<br>
 * 下記は使用方法になります。
 * <pre>
 * DmmActressSearch actressSearch = new DmmActressSearch();
 * actressSearch.setInitial("は");
 * actressSearch.setActressId(26225);
 * actressSearch.setKeyword("はたの");
 * ActressInfo result = actressSearch.execute();
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class DmmActressSearch extends AbstractDmm<ActressInfo> {

  /** 女優名の頭文字50音 */
  private String initial;
  /** 女優ID */
  private String actressId;
  /** キーワード */
  private String keyword;
  /** バスト(以上) */
  private String gteBust;
  /** バスト(以下) */
  private String lteBust;
  /** ウエスト(以上) */
  private String gteWaist;
  /** ウエスト(以下) */
  private String lteWaist;
  /** ヒップ(以上) */
  private String gteHip;
  /** ヒップ(以下) */
  private String lteHip;
  /** 身長(以上) */
  private String gteHeight;
  /** 身長(以下) */
  private String lteHeight;
  /** 生年月日(以上) */
  private String gteBirthday;
  /** 生年月日(以下) */
  private String lteBirthday;
  /** 取得件数 */
  private String hits;
  /** 検索開始位置 */
  private String offset;
  /** ソート順 */
  private ActressSearchSort sort;

  /**
   * 女優名の頭文字を設定する。<br>
   * 50音をUTF-8で指定。<br>
   * 例:あい
   *
   * @param initial 頭文字
   */
  public void setInitial(String initial) {
    if (!StringUtil.isJapaneseSyllabary(initial)) {
      throw new IllegalArgumentException(getMsg(Message.M0001, initial));
    }
    this.initial = initial;
  }

  /**
   * 女優IDを設定する。<br>
   * 例:15365
   *
   * @param actressId 女優ID
   */
  public void setActressId(long actressId) {
    this.actressId = String.valueOf(actressId);
  }

  /**
   * キーワードを設定する。<br>
   * 例:あさみ
   *
   * @param keyword キーワード
   */
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  /**
   * バスト(以上)を設定する。<br>
   * 例:80
   *
   * @param gteBust バスト(以上)
   */
  public void setGteBust(int gteBust) {
    this.gteBust = String.valueOf(gteBust);
  }

  /**
   * バスト(以下)を設定する。<br>
   * 例:80
   *
   * @param lteBust バスト(以下)
   */
  public void setLteBust(int lteBust) {
    this.lteBust = String.valueOf(lteBust);
  }

  /**
   * ウエスト(以上)を設定する。<br>
   * 例:60
   *
   * @param gteWaist ウエスト(以上)
   */
  public void setGteWaist(int gteWaist) {
    this.gteWaist = String.valueOf(gteWaist);
  }

  /**
   * ウエスト(以下)を設定する。<br>
   * 例:60
   *
   * @param lteWaist ウエスト(以下)
   */
  public void setLteWaist(int lteWaist) {
    this.lteWaist = String.valueOf(lteWaist);
  }

  /**
   * ヒップ(以上)を設定する。<br>
   * 例:90
   *
   * @param gteHip ヒップ(以上)
   */
  public void setGteHip(int gteHip) {
    this.gteHip = String.valueOf(gteHip);
  }

  /**
   * ヒップ(以下)を設定する。<br>
   * 例:90
   *
   * @param lteHip ヒップ(以下)
   */
  public void setLteHip(int lteHip) {
    this.lteHip = String.valueOf(lteHip);
  }

  /**
   * 身長(以上)を設定する。<br>
   * 例:160
   *
   * @param gteHeight ヒップ(以上)
   */
  public void setGteHeight(int gteHeight) {
    this.gteHeight = String.valueOf(gteHeight);
  }

  /**
   * 身長(以下)を設定する。<br>
   * 例:160
   *
   * @param lteHeight ヒップ(以下)
   */
  public void setLteHeight(int lteHeight) {
    this.lteHeight = String.valueOf(lteHeight);
  }

  /**
   * 生年月日(以上)を設定する。<br>
   *
   * @param gteBirthday 生年月日(以上)
   */
  public void setGteBirthday(LocalDate gteBirthday) {
    this.gteBirthday = DateFormat.uuuuMMdd_HYPHEN.format(gteBirthday);
  }

  /**
   * 生年月日(以上)を設定する。<br>
   * 例:1980-01-01
   *
   * @param gteBirthday 生年月日(以上)
   */
  public void setGteBirthday(String gteBirthday) {
    if (!DateFormat.uuuuMMdd_HYPHEN.isFormatCheck(gteBirthday)) {
      throw new IllegalArgumentException(getMsg(Message.M0002, gteBirthday));
    }
    this.lteBirthday = gteBirthday;
  }

  /**
   * 生年月日(以下)を設定する。<br>
   *
   * @param lteBirthday 生年月日(以下)
   */
  public void setLteBirthday(LocalDate lteBirthday) {
    this.lteBirthday = DateFormat.uuuuMMdd_HYPHEN.format(lteBirthday);
  }

  /**
   * 生年月日(以下)を設定する。<br>
   * 例:1980-01-01
   *
   * @param lteBirthday 生年月日(以下)
   */
  public void setLteBirthday(String lteBirthday) {
    if (!DateFormat.uuuuMMdd_HYPHEN.isFormatCheck(lteBirthday)) {
      throw new IllegalArgumentException(getMsg(Message.M0002, lteBirthday));
    }
    this.lteBirthday = lteBirthday;
  }

  /**
   * 取得件数を設定する。<br>
   * 初期値：20 <br>
   * 最大値:100<br>
   * 例:80
   *
   * @param hits 取得件数
   */
  public void setHits(int hits) {
    this.hits = String.valueOf(hits);
  }

  /**
   * 検索開始位置を設定する。<br>
   * 初期値:1<br>
   * 例:10
   *
   * @param offset 検索開始位置
   */
  public void setOffset(int offset) {
    this.offset = String.valueOf(offset);
  }

  /**
   * ソート順を設定する
   *
   * @param sort 検索開始位置
   */
  public void setSort(ActressSearchSort sort) {
    this.sort = sort;
  }

  /**
   * APIを実行するためのパラメータを取得する
   *
   * @return パラメータ
   */
  @Override
  protected String getParam() {
    String param = "";
    // 女優名の頭文字50音
    param = addParam(param, "initial", this.initial);
    // 女優ID
    param = addParam(param, "actress_id", this.actressId);
    // キーワード
    param = addParam(param, "keyword", this.keyword);
    // バスト_以上
    param = addParam(param, "gte_bust", this.gteBust);
    // バスト_以下
    param = addParam(param, "lte_bust", this.lteBust);
    // ウエスト_以上
    param = addParam(param, "gte_waist", this.gteWaist);
    // ウエスト_以下
    param = addParam(param, "lte_waist", this.lteWaist);
    // ヒップ_以上
    param = addParam(param, "gte_hip", this.gteHip);
    // ヒップ_以下
    param = addParam(param, "lte_hip", this.lteHip);
    // 身長_以上
    param = addParam(param, "gte_height", this.gteHeight);
    // 身長_以下
    param = addParam(param, "lte_height", this.lteHeight);
    // 生年月日_以上
    param = addParam(param, "gte_birthday", this.gteBirthday);
    // 生年月日_以下
    param = addParam(param, "lte_birthday", this.lteBirthday);
    // 取得件数
    param = addParam(param, "hits", this.hits);
    // 検索開始位置
    param = addParam(param, "offset", this.offset);
    // ソート順
    if (this.sort != null) {
      param = addParam(param, "sort", this.sort.getValue());
    }
    // 出力形式
    param = addParam(param, "output", Output.JSON.getValue());
    return param;
  }

  /**
   * パラメータをクリアする
   */
  @Override
  public void clear() {
    // 女優名の頭文字50音
    this.initial = null;
    // 女優ID
    this.actressId = null;
    // キーワード
    this.keyword = null;
    // バスト_以上
    this.gteBust = null;
    // バスト_以下
    this.lteBust = null;
    // ウエスト_以上
    this.gteWaist = null;
    // ウエスト_以下
    this.lteWaist = null;
    // ヒップ_以上
    this.gteHip = null;
    // ヒップ_以下
    this.lteHip = null;
    // 身長_以上
    this.gteHeight = null;
    // 身長_以下
    this.lteHeight = null;
    // 生年月日_以上
    this.gteBirthday = null;
    // 生年月日_以下
    this.lteBirthday = null;
    // 取得件数
    this.hits = null;
    // 検索開始位置
    this.offset = null;
    // ソート順
    this.sort = null;
  }

  /**
   * DMM_APIを実行するためのURLを管理するenumを返却
   *
   * @return DMM_APIを実行するためのURLを管理するenum
   */
  @Override
  protected DmmApi getDmmAPI() {
    return DmmApi.ACTRESS_SEARCH;
  }

  /**
   * APIより返却されるJSONのマッピング対象となるDTOのclassオブジェクトを取得する
   *
   * @return classオブジェクト
   */
  @Override
  protected Class<ActressInfo> getInfoClass() {
    return ActressInfo.class;
  }

}
