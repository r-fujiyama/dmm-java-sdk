package com.sdk.java.dmm.api.actress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.actress.dto.ActressInfo;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.utils.DateFormat;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageProperties;
import java.time.DateTimeException;
import org.junit.jupiter.api.Test;

public class DmmActressSearchTest {

  @Test
  public void 正常系_DMM女優検索API実行_日付がDateTime() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    actressSearch.setInitial("は");
    actressSearch.setActressId(26225);
    actressSearch.setKeyword("はたの");
    actressSearch.setGteBust(88);
    actressSearch.setLteBust(88);
    actressSearch.setGteWaist(59);
    actressSearch.setLteWaist(59);
    actressSearch.setGteHip(85);
    actressSearch.setLteHip(85);
    actressSearch.setGteHeight(163);
    actressSearch.setLteHeight(163);
    actressSearch.setGteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actressSearch.setLteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actressSearch.setHits(1);
    actressSearch.setOffset(1);
    actressSearch.setSort(ActressSearchSort.ID_DESC);

    ActressInfo actual = actressSearch.execute();
    String json = JsonUtil.write(actual);
    ActressInfo expected = JsonUtil.read(json, ActressInfo.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_DMM女優検索API実行_日付が文字列() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    actressSearch.setInitial("は");
    actressSearch.setActressId(26225);
    actressSearch.setKeyword("はたの");
    actressSearch.setGteBust(88);
    actressSearch.setLteBust(88);
    actressSearch.setGteWaist(59);
    actressSearch.setLteWaist(59);
    actressSearch.setGteHip(85);
    actressSearch.setLteHip(85);
    actressSearch.setGteHeight(163);
    actressSearch.setLteHeight(163);
    actressSearch.setGteBirthday("1988-05-24");
    actressSearch.setLteBirthday("1988-05-24");
    actressSearch.setHits(1);
    actressSearch.setOffset(1);
    actressSearch.setSort(ActressSearchSort.ID_DESC);

    ActressInfo actual = actressSearch.execute();
    String json = JsonUtil.write(actual);
    ActressInfo expected = JsonUtil.read(json, ActressInfo.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_getJson() {
    DmmActressSearch actSearch = new DmmActressSearch();
    actSearch.setInitial("は");
    actSearch.setActressId(26225);
    actSearch.setKeyword("はたの");
    actSearch.setGteBust(88);
    actSearch.setLteBust(88);
    actSearch.setGteWaist(59);
    actSearch.setLteWaist(59);
    actSearch.setGteHip(85);
    actSearch.setLteHip(85);
    actSearch.setGteHeight(163);
    actSearch.setLteHeight(163);
    actSearch.setGteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actSearch.setLteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actSearch.setHits(1);
    actSearch.setOffset(1);
    actSearch.setSort(ActressSearchSort.ID_DESC);

    ActressInfo expected = actSearch.execute();
    ActressInfo actual = JsonUtil.read(actSearch.getJson(), ActressInfo.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    DmmActressSearch actual = new DmmActressSearch();
    actual.setInitial("は");
    actual.setActressId(26225);
    actual.setKeyword("はたの");
    actual.setGteBust(88);
    actual.setLteBust(88);
    actual.setGteWaist(59);
    actual.setLteWaist(59);
    actual.setGteHip(85);
    actual.setLteHip(85);
    actual.setGteHeight(163);
    actual.setLteHeight(163);
    actual.setGteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actual.setLteBirthday(DateFormat.uuuuMMdd_HYPHEN.parse("1988-05-24"));
    actual.setHits(1);
    actual.setOffset(1);
    actual.setSort(ActressSearchSort.ID_DESC);
    actual.clear();
    assertThat(actual).isEqualTo(new DmmActressSearch());
  }

  @Test
  public void 異常系_setInitial＿フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "test";
    assertThatThrownBy(() -> actressSearch.setInitial(argument))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0001, argument));
  }

  @Test
  public void 異常系_setGteBirthday＿フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "2019/01/01";
    assertThatThrownBy(() -> actressSearch.setGteBirthday(argument))
        .isInstanceOf(DateTimeException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0002, argument));
  }

  @Test
  public void 異常系_setLteBirthday＿フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "2019/01/01";
    assertThatThrownBy(() -> actressSearch.setLteBirthday(argument))
        .isInstanceOf(DateTimeException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0002, argument));
  }

}
