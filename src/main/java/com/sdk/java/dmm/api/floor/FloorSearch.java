package com.sdk.java.dmm.api.floor;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.utils.StringUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * フロアAPIを実行するためのクラスです。<br>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * FloorSearch floorSearch = new FloorSearch();
 * FloorSearchResult result = floorSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class FloorSearch extends AbstractDmm<FloorSearchResult> {

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    // do nothing
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getParam() {
    String param = "";
    // 出力形式
    param = StringUtil.addParam(param, "output", Output.JSON);
    return param;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected BaseURL getBaseURL() {
    return BaseURL.FLOOR_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<FloorSearchResult> getResultClass() {
    return FloorSearchResult.class;
  }

}
