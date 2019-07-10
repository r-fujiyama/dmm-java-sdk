package com.sdk.java.dmm.api.actress;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.actress.dto.ActressInfo;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.DmmApiUrl;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.utils.DateFormat;
import com.sdk.java.dmm.utils.MessageProperties;
import com.sdk.java.dmm.utils.StringUtil;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 女優検索を実行するためのクラス。<br>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * DmmActressSearch actressSearch = new DmmActressSearch();
 * actressSearch.setInitial("は");
 * actressSearch.setKeyword("はたの");
 * actressSearch.setGteBust(88);
 * actressSearch.setGteWaist(59);
 * ActressInfo result = actressSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class DmmActressSearch extends AbstractDmm<ActressInfo> {

  /** 女優名の頭文字50音 */
  private String initial;
  /** 女優ID */
  private Long actressId;
  /** キーワード */
  private String keyword;
  /** バスト(以上) */
  private Integer gteBust;
  /** バスト(以下) */
  private Integer lteBust;
  /** ウエスト(以上) */
  private Integer gteWaist;
  /** ウエスト(以下) */
  private Integer lteWaist;
  /** ヒップ(以上) */
  private Integer gteHip;
  /** ヒップ(以下) */
  private Integer lteHip;
  /** 身長(以上) */
  private Integer gteHeight;
  /** 身長(以下) */
  private Integer lteHeight;
  /** 生年月日(以上) */
  private LocalDate gteBirthday;
  /** 生年月日(以下) */
  private LocalDate lteBirthday;
  /** 取得件数 */
  private Integer hits;
  /** 検索開始位置 */
  private Integer offset;
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
      throw new IllegalArgumentException(MessageProperties.getMsg(Message.M0001, initial));
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
    this.actressId = actressId;
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
    this.gteBust = gteBust;
  }

  /**
   * バスト(以下)を設定する。<br>
   * 例:80
   *
   * @param lteBust バスト(以下)
   */
  public void setLteBust(int lteBust) {
    this.lteBust = lteBust;
  }

  /**
   * ウエスト(以上)を設定する。<br>
   * 例:60
   *
   * @param gteWaist ウエスト(以上)
   */
  public void setGteWaist(int gteWaist) {
    this.gteWaist = gteWaist;
  }

  /**
   * ウエスト(以下)を設定する。<br>
   * 例:60
   *
   * @param lteWaist ウエスト(以下)
   */
  public void setLteWaist(int lteWaist) {
    this.lteWaist = lteWaist;
  }

  /**
   * ヒップ(以上)を設定する。<br>
   * 例:90
   *
   * @param gteHip ヒップ(以上)
   */
  public void setGteHip(int gteHip) {
    this.gteHip = gteHip;
  }

  /**
   * ヒップ(以下)を設定する。<br>
   * 例:90
   *
   * @param lteHip ヒップ(以下)
   */
  public void setLteHip(int lteHip) {
    this.lteHip = lteHip;
  }

  /**
   * 身長(以上)を設定する。<br>
   * 例:160
   *
   * @param gteHeight ヒップ(以上)
   */
  public void setGteHeight(int gteHeight) {
    this.gteHeight = gteHeight;
  }

  /**
   * 身長(以下)を設定する。<br>
   * 例:160
   *
   * @param lteHeight ヒップ(以下)
   */
  public void setLteHeight(int lteHeight) {
    this.lteHeight = lteHeight;
  }

  /**
   * 生年月日(以上)を設定する。<br>
   *
   * @param gteBirthday 生年月日(以上)
   */
  public void setGteBirthday(LocalDate gteBirthday) {
    this.gteBirthday = gteBirthday;
  }

  /**
   * 生年月日(以上)を設定する。<br>
   * 例:1980-01-01
   *
   * @param gteBirthday 生年月日(以上)
   */
  public void setGteBirthday(String gteBirthday) {
    if (!DateFormat.uuuuMMdd_HYPHEN.check(gteBirthday)) {
      throw new DateTimeException(MessageProperties.getMsg(Message.M0002, gteBirthday));
    }
    this.gteBirthday = DateFormat.uuuuMMdd_HYPHEN.parse(gteBirthday);
  }

  /**
   * 生年月日(以下)を設定する。<br>
   *
   * @param lteBirthday 生年月日(以下)
   */
  public void setLteBirthday(LocalDate lteBirthday) {
    this.lteBirthday = lteBirthday;
  }

  /**
   * 生年月日(以下)を設定する。<br>
   * 例:1980-01-01
   *
   * @param lteBirthday 生年月日(以下)
   */
  public void setLteBirthday(String lteBirthday) {
    if (!DateFormat.uuuuMMdd_HYPHEN.check(lteBirthday)) {
      throw new DateTimeException(MessageProperties.getMsg(Message.M0002, lteBirthday));
    }
    this.lteBirthday = DateFormat.uuuuMMdd_HYPHEN.parse(lteBirthday);
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
    this.hits = hits;
  }

  /**
   * 検索開始位置を設定する。<br>
   * 初期値:1<br>
   * 例:10
   *
   * @param offset 検索開始位置
   */
  public void setOffset(int offset) {
    this.offset = offset;
  }

  /**
   * ソート順を設定する。
   *
   * @param sort ソート順
   */
  public void setSort(ActressSearchSort sort) {
    this.sort = sort;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getParam() {
    String param = "";
    // 女優名の頭文字50音
    param = StringUtil.addParam(param, "initial", this.initial);
    // 女優ID
    param = StringUtil.addParam(param, "actress_id", Objects.toString(this.actressId, null));
    // キーワード
    param = StringUtil.addParam(param, "keyword", this.keyword);
    // バスト_以上
    param = StringUtil.addParam(param, "gte_bust", Objects.toString(this.gteBust, null));
    // バスト_以下
    param = StringUtil.addParam(param, "lte_bust", Objects.toString(this.lteBust, null));
    // ウエスト_以上
    param = StringUtil.addParam(param, "gte_waist", Objects.toString(this.gteWaist, null));
    // ウエスト_以下
    param = StringUtil.addParam(param, "lte_waist", Objects.toString(this.lteWaist, null));
    // ヒップ_以上
    param = StringUtil.addParam(param, "gte_hip", Objects.toString(this.gteHip, null));
    // ヒップ_以下
    param = StringUtil.addParam(param, "lte_hip", Objects.toString(this.lteHip, null));
    // 身長_以上
    param = StringUtil.addParam(param, "gte_height", Objects.toString(this.gteHeight, null));
    // 身長_以下
    param = StringUtil.addParam(param, "lte_height", Objects.toString(this.lteHeight, null));
    // 生年月日_以上
    if (this.gteBirthday != null) {
      param = StringUtil
          .addParam(param, "gte_birthday", DateFormat.uuuuMMdd_HYPHEN.format(this.gteBirthday));
    }
    // 生年月日_以下
    if (this.lteBirthday != null) {
      param = StringUtil
          .addParam(param, "lte_birthday", DateFormat.uuuuMMdd_HYPHEN.format(this.lteBirthday));
    }
    // 取得件数
    param = StringUtil.addParam(param, "hits", Objects.toString(this.hits, null));
    // 検索開始位置
    param = StringUtil.addParam(param, "offset", Objects.toString(this.offset, null));
    // ソート順
    if (this.sort != null) {
      param = StringUtil.addParam(param, "sort", this.sort.getValue());
    }
    // 出力形式
    param = StringUtil.addParam(param, "output", Output.JSON.getValue());
    return param;
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   */
  @Override
  protected DmmApiUrl getDmmApiUrl() {
    return DmmApiUrl.ACTRESS_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<ActressInfo> getInfoClass() {
    return ActressInfo.class;
  }

}
