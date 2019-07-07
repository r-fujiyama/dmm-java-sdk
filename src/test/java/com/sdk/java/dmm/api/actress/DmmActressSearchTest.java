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
import java.time.LocalDate;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DmmActressSearchTest {

  @Nested
  public class execute {

    @Test
    public void 正常系_DMM女優検索API実行_イニシャル() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      String cond = "あ";
      actressSearch.setInitial(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_DMM女優検索API実行_女優ID() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      long cond = 26225;
      actressSearch.setActressId(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getId()).isEqualTo(cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_キーワード() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      String cond = "はたの";
      actressSearch.setKeyword(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getRuby()).contains(cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_バスト以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 80;
      actressSearch.setGteBust(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBust()).isBetween(cond, Integer.MAX_VALUE));
    }

    @Test
    public void 正常系_DMM女優検索API実行_バスト以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 80;
      actressSearch.setLteBust(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBust()).isBetween(Integer.MIN_VALUE, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_ウエスト以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 60;
      actressSearch.setGteWaist(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getWaist()).isBetween(cond, Integer.MAX_VALUE));
    }

    @Test
    public void 正常系_DMM女優検索API実行_ウエスト以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 60;
      actressSearch.setLteWaist(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getWaist()).isBetween(Integer.MIN_VALUE, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_ヒップ以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 90;
      actressSearch.setGteHip(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHip()).isBetween(cond, Integer.MAX_VALUE));
    }

    @Test
    public void 正常系_DMM女優検索API実行_ヒップ以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 90;
      actressSearch.setLteHip(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHip()).isBetween(Integer.MIN_VALUE, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_身長以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 160;
      actressSearch.setGteHeight(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHeight()).isBetween(cond, Integer.MAX_VALUE));
    }

    @Test
    public void 正常系_DMM女優検索API実行_身長以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 160;
      actressSearch.setLteHeight(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHeight()).isBetween(Integer.MIN_VALUE, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_誕生日をDateTimeで指定_以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setGteBirthday(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBetween(cond, LocalDate.MAX));
    }

    @Test
    public void 正常系_DMM女優検索API実行_誕生日をDateTimeで指定_以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setLteBirthday(cond);
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBetween(LocalDate.MIN, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_誕生日を文字列で指定_以上() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setGteBirthday(DateFormat.uuuuMMdd_HYPHEN.format(cond));
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBetween(cond, LocalDate.MAX));
    }

    @Test
    public void 正常系_DMM女優検索API実行_誕生日を文字列で指定_以下() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setLteBirthday(DateFormat.uuuuMMdd_HYPHEN.format(cond));
      ActressInfo info = actressSearch.execute();
      info.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBetween(LocalDate.MIN, cond));
    }

    @Test
    public void 正常系_DMM女優検索API実行_取得件数() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 100;
      actressSearch.setHits(cond);
      ActressInfo info = actressSearch.execute();
      assertThat(info.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_DMM女優検索API実行_検索開始位置() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      int cond = 5000;
      actressSearch.setOffset(cond);
      ActressInfo info = actressSearch.execute();
      assertThat(info.getRequest().getParameters().getOffset()).isEqualTo(cond);
    }

    @Test
    public void 正常系_DMM女優検索API実行_ソート順() {
      DmmActressSearch actressSearch = new DmmActressSearch();
      ActressSearchSort cond = ActressSearchSort.ID_DESC;
      actressSearch.setSort(cond);
      ActressInfo info = actressSearch.execute();
      assertThat(info.getRequest().getParameters().getSort()).isEqualTo(cond);
    }

    @Test
    public void 正常系_DMM女優検索API実行_すべての検索条件() {
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
      ActressInfo expected = JsonUtil.read(actressSearch.getJson(), ActressInfo.class);
      assertThat(actual).isEqualTo(expected);
    }

  }

  @Test
  public void 正常系_getJson() {
    DmmActressSearch actSearch = new DmmActressSearch();
    actSearch.setActressId(26225);
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
  public void 異常系_setInitial_フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "test";
    assertThatThrownBy(() -> actressSearch.setInitial(argument))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0001, argument));
  }

  @Test
  public void 異常系_setGteBirthday_フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "2019/01/01";
    assertThatThrownBy(() -> actressSearch.setGteBirthday(argument))
        .isInstanceOf(DateTimeException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0002, argument));
  }

  @Test
  public void 異常系_setLteBirthday_フォーマット不正() {
    DmmActressSearch actressSearch = new DmmActressSearch();
    String argument = "2019/01/01";
    assertThatThrownBy(() -> actressSearch.setLteBirthday(argument))
        .isInstanceOf(DateTimeException.class)
        .hasMessage(MessageProperties.getMsg(Message.M0002, argument));
  }

}
