package com.sdk.java.dmm.api.actress;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.actress.dto.ActressSearchResult;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.utils.DateFormat;
import com.sdk.java.dmm.utils.StringUtil;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 女優検索を実行するためのクラスです。<br>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * ActressSearch actressSearch = new ActressSearch();
 * actressSearch.setInitial("は");
 * actressSearch.setKeyword("はたの");
 * actressSearch.setGteBust(88);
 * actressSearch.setGteWaist(59);
 * ActressSearchResult result = actressSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActressSearch extends AbstractDmm<ActressSearchResult> {

  /** 女優名の頭文字(50音) */
  private String initial;
  /** 女優ID */
  private String actressId;
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
   * ActressSearchオブジェクトを生成します。
   */
  public ActressSearch() {
  }

  /**
   * 女優名の頭文字を設定する。<br>
   * 例:あい
   *
   * @param initial 頭文字
   * @return this ActressSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ActressSearch setInitial(String initial) throws DmmIllegalArgumentException {
    if (!StringUtil.isJapaneseSyllabary(initial)) {
      throw new DmmIllegalArgumentException(Message.M0001, "initial", initial);
    }
    this.initial = URLEncoder.encode(initial, StandardCharsets.UTF_8);
    return this;
  }

  /**
   * 女優IDを設定する。<br>
   * 例:15365
   *
   * @param actressId 女優ID
   * @return this ActressSearch
   */
  public ActressSearch setActressId(String actressId) {
    this.actressId = URLEncoder.encode(actressId, StandardCharsets.UTF_8);
    return this;
  }

  /**
   * キーワードを設定する。<br>
   * 例:あさみ
   *
   * @param keyword キーワード
   * @return this ActressSearch
   */
  public ActressSearch setKeyword(String keyword) {
    this.keyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
    return this;
  }

  /**
   * バスト(以上)を設定する。<br>
   * 例:80
   *
   * @param gteBust バスト(以上)
   * @return this ActressSearch
   */
  public ActressSearch setGteBust(int gteBust) {
    this.gteBust = gteBust;
    return this;
  }

  /**
   * バスト(以下)を設定する。<br>
   * 例:80
   *
   * @param lteBust バスト(以下)
   * @return this ActressSearch
   */
  public ActressSearch setLteBust(int lteBust) {
    this.lteBust = lteBust;
    return this;
  }

  /**
   * ウエスト(以上)を設定する。<br>
   * 例:60
   *
   * @param gteWaist ウエスト(以上)
   * @return this ActressSearch
   */
  public ActressSearch setGteWaist(int gteWaist) {
    this.gteWaist = gteWaist;
    return this;
  }

  /**
   * ウエスト(以下)を設定する。<br>
   * 例:60
   *
   * @param lteWaist ウエスト(以下)
   * @return this ActressSearch
   */
  public ActressSearch setLteWaist(int lteWaist) {
    this.lteWaist = lteWaist;
    return this;
  }

  /**
   * ヒップ(以上)を設定する。<br>
   * 例:90
   *
   * @param gteHip ヒップ(以上)
   * @return this ActressSearch
   */
  public ActressSearch setGteHip(int gteHip) {
    this.gteHip = gteHip;
    return this;
  }

  /**
   * ヒップ(以下)を設定する。<br>
   * 例:90
   *
   * @param lteHip ヒップ(以下)
   * @return this ActressSearch
   */
  public ActressSearch setLteHip(int lteHip) {
    this.lteHip = lteHip;
    return this;
  }

  /**
   * 身長(以上)を設定する。<br>
   * 例:160
   *
   * @param gteHeight ヒップ(以上)
   * @return this ActressSearch
   */
  public ActressSearch setGteHeight(int gteHeight) {
    this.gteHeight = gteHeight;
    return this;
  }

  /**
   * 身長(以下)を設定する。<br>
   * 例:160
   *
   * @param lteHeight ヒップ(以下)
   * @return this ActressSearch
   */
  public ActressSearch setLteHeight(int lteHeight) {
    this.lteHeight = lteHeight;
    return this;
  }

  /**
   * 生年月日(以上)を設定する。<br>
   * 例:1980-01-01
   *
   * @param gteBirthday 生年月日(以上)
   * @return this ActressSearch
   */
  public ActressSearch setGteBirthday(LocalDate gteBirthday) {
    this.gteBirthday = gteBirthday;
    return this;
  }

  /**
   * 生年月日(以上)を設定する。<br>
   * 例:1980-01-01
   *
   * @param gteBirthday 生年月日(以上)
   * @return this ActressSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ActressSearch setGteBirthday(String gteBirthday) throws DmmIllegalArgumentException {
    if (!DateFormat.uuuuMMdd_HYPHEN.check(gteBirthday)) {
      throw new DmmIllegalArgumentException(Message.M0002, "gteBirthday", gteBirthday);
    }
    this.gteBirthday = DateFormat.uuuuMMdd_HYPHEN.parse(gteBirthday);
    return this;
  }

  /**
   * 生年月日(以下)を設定する。<br>
   * 例:1980-01-01
   *
   * @param lteBirthday 生年月日(以下)
   * @return this ActressSearch
   */
  public ActressSearch setLteBirthday(LocalDate lteBirthday) {
    this.lteBirthday = lteBirthday;
    return this;
  }

  /**
   * 生年月日(以下)を設定する。<br>
   * 例:1980-01-01
   *
   * @param lteBirthday 生年月日(以下)
   * @return this ActressSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ActressSearch setLteBirthday(String lteBirthday) throws DmmIllegalArgumentException {
    if (!DateFormat.uuuuMMdd_HYPHEN.check(lteBirthday)) {
      throw new DmmIllegalArgumentException(Message.M0002, "lteBirthday", lteBirthday);
    }
    this.lteBirthday = DateFormat.uuuuMMdd_HYPHEN.parse(lteBirthday);
    return this;
  }

  /**
   * 取得件数を設定する。<br>
   * 初期値：20 <br>
   * 最大値:100
   *
   * @param hits 取得件数
   * @return this ActressSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ActressSearch setHits(int hits) throws DmmIllegalArgumentException {
    if (hits == 0) {
      throw new DmmIllegalArgumentException(Message.M0008, "hits");
    }
    this.hits = hits;
    return this;
  }

  /**
   * 検索開始位置を設定する。<br>
   * 初期値:1
   *
   * @param offset 検索開始位置
   * @return this ActressSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ActressSearch setOffset(int offset) throws DmmIllegalArgumentException {
    if (offset == 0) {
      throw new DmmIllegalArgumentException(Message.M0008, "offset");
    }
    this.offset = offset;
    return this;
  }

  /**
   * ソート順を設定する。
   * 名前昇順：NAME_ASC
   * 名前降順：NAME_DESC
   * バスト昇順：BUST_ASC
   * バスト降順：BUST_DESC
   * ウエスト昇順：WAIST_ASC
   * ウエスト降順：WAIST_DESC
   * ヒップ昇順：HIP_ASC
   * ヒップ降順：HIP_DESC
   * 身長昇順：HEIGHT_ASC
   * 身長降順：HEIGHT_DESC
   * 生年月日昇順：BIRTHDAY_ASC
   * 生年月日降順：BIRTHDAY_DESC
   * 女優ID昇順：ID_ASC
   * 女優ID降順：ID_DESC
   *
   * @param sort ソート順
   * @return this ActressSearch
   */
  public ActressSearch setSort(ActressSearchSort sort) {
    this.sort = sort;
    return this;
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
  protected String getParam() {
    String param = "";
    // 女優名の頭文字50音
    param = StringUtil.addParam(param, "initial", this.initial);
    // 女優ID
    param = StringUtil.addParam(param, "actress_id", this.actressId);
    // キーワード
    param = StringUtil.addParam(param, "keyword", this.keyword);
    // バスト_以上
    param = StringUtil.addParam(param, "gte_bust", this.gteBust);
    // バスト_以下
    param = StringUtil.addParam(param, "lte_bust", this.lteBust);
    // ウエスト_以上
    param = StringUtil.addParam(param, "gte_waist", this.gteWaist);
    // ウエスト_以下
    param = StringUtil.addParam(param, "lte_waist", this.lteWaist);
    // ヒップ_以上
    param = StringUtil.addParam(param, "gte_hip", this.gteHip);
    // ヒップ_以下
    param = StringUtil.addParam(param, "lte_hip", this.lteHip);
    // 身長_以上
    param = StringUtil.addParam(param, "gte_height", this.gteHeight);
    // 身長_以下
    param = StringUtil.addParam(param, "lte_height", this.lteHeight);
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
    param = StringUtil.addParam(param, "hits", this.hits);
    // 検索開始位置
    param = StringUtil.addParam(param, "offset", this.offset);
    // ソート順
    param = StringUtil.addParam(param, "sort", this.sort);
    // 出力形式
    param = StringUtil.addParam(param, "output", Output.JSON);
    return param;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected BaseURL getBaseURL() {
    return BaseURL.ACTRESS_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<ActressSearchResult> getResultClass() {
    return ActressSearchResult.class;
  }

}
