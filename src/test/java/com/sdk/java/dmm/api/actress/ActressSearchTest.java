package com.sdk.java.dmm.api.actress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.actress.dto.Actress;
import com.sdk.java.dmm.api.actress.dto.ActressSearchResult;
import com.sdk.java.dmm.enums.ActressSearchSort;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.utils.DateFormat;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageResolver;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ActressSearchTest {

  private final ActressSearch actressSearch = new ActressSearch();

  @AfterEach
  public void setUp() {
    actressSearch.clear();
  }

  @Nested
  public class execute {

    @Test
    public void 正常系_女優検索API実行_条件無し() {
      execute();
    }

    @Test
    public void 正常系_女優検索API実行_イニシャル() {
      String cond = "あ";
      actressSearch.setInitial(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_女優検索API実行_女優ID() {
      long cond = 26225;
      actressSearch.setActressId(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getId()).isEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_キーワード() {
      String cond = "はたの";
      actressSearch.setKeyword(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getRuby()).contains(cond));
    }

    @Test
    public void 正常系_女優検索API実行_バスト以上() {
      int cond = 80;
      actressSearch.setGteBust(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBust()).isGreaterThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_バスト以下() {
      int cond = 80;
      actressSearch.setLteBust(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBust()).isLessThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_ウエスト以上() {
      int cond = 60;
      actressSearch.setGteWaist(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getWaist()).isGreaterThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_ウエスト以下() {
      int cond = 60;
      actressSearch.setLteWaist(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getWaist()).isLessThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_ヒップ以上() {
      int cond = 90;
      actressSearch.setGteHip(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHip()).isGreaterThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_ヒップ以下() {
      int cond = 90;
      actressSearch.setLteHip(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHip()).isLessThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_身長以上() {
      int cond = 160;
      actressSearch.setGteHeight(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHeight()).isGreaterThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_身長以下() {
      int cond = 160;
      actressSearch.setLteHeight(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getHeight()).isLessThanOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_誕生日をLocalDateTimeで指定_以上() {
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setGteBirthday(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isAfterOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_誕生日を文字列で指定_以上() {
      String cond = "1996-12-15";
      actressSearch.setGteBirthday(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isAfterOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_誕生日をLocalDateTimeで指定_以下() {
      LocalDate cond = DateFormat.uuuuMMdd_HYPHEN.parse("1996-12-15");
      actressSearch.setLteBirthday(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBeforeOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_誕生日を文字列で指定_以下() {
      String cond = "1996-12-15";
      actressSearch.setLteBirthday(cond);
      ActressSearchResult result = execute();
      result.getResult().getActress()
          .forEach(actress -> assertThat(actress.getBirthday()).isBeforeOrEqualTo(cond));
    }

    @Test
    public void 正常系_女優検索API実行_取得件数() {
      int cond = 100;
      actressSearch.setHits(cond);
      ActressSearchResult result = execute();
      assertThat(result.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_女優検索API実行_検索開始位置() {
      int cond = 5000;
      actressSearch.setOffset(cond);
      ActressSearchResult result = execute();
      assertThat(result.getResult().getFirstPosition()).isEqualTo(cond);
    }

    @Nested
    public class 正常系_女優検索API実行_ソート {

      @Test
      public void 名前_昇順() {
        actressSearch.setSort(ActressSearchSort.NAME_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          String actual = actressList.get(i - 1).getRuby();
          String expected = actressList.get(i).getRuby();
          assertThat(actual.compareTo(expected)).isLessThanOrEqualTo(0);
        }
      }

      @Test
      public void 名前_降順() {
        actressSearch.setSort(ActressSearchSort.NAME_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          String actual = actressList.get(i - 1).getRuby();
          String expected = actressList.get(i).getRuby();
          assertThat(actual.compareTo(expected)).isGreaterThanOrEqualTo(0);
        }
      }

      @Test
      public void バスト_昇順() {
        actressSearch.setSort(ActressSearchSort.BUST_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getBust();
          int expected = actressList.get(i).getBust();
          assertThat(actual).isLessThanOrEqualTo(expected);
        }
      }

      @Test
      public void バスト_降順() {
        actressSearch.setSort(ActressSearchSort.BUST_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getBust();
          int expected = actressList.get(i).getBust();
          assertThat(actual).isGreaterThanOrEqualTo(expected);
        }
      }

      @Test
      public void ウエスト_昇順() {
        actressSearch.setSort(ActressSearchSort.WAIST_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getWaist();
          int expected = actressList.get(i).getWaist();
          assertThat(actual).isLessThanOrEqualTo(expected);
        }
      }

      @Test
      public void ウエスト_降順() {
        actressSearch.setSort(ActressSearchSort.WAIST_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getWaist();
          int expected = actressList.get(i).getWaist();
          assertThat(actual).isGreaterThanOrEqualTo(expected);
        }
      }

      @Test
      public void ヒップ_昇順() {
        actressSearch.setSort(ActressSearchSort.HIP_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getHip();
          int expected = actressList.get(i).getHip();
          assertThat(actual).isLessThanOrEqualTo(expected);
        }
      }

      @Test
      public void ヒップ_降順() {
        actressSearch.setSort(ActressSearchSort.HIP_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getHip();
          int expected = actressList.get(i).getHip();
          assertThat(actual).isGreaterThanOrEqualTo(expected);
        }
      }

      @Test
      public void 身長_昇順() {
        actressSearch.setSort(ActressSearchSort.HEIGHT_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getHeight();
          int expected = actressList.get(i).getHeight();
          assertThat(actual).isLessThanOrEqualTo(expected);
        }
      }

      @Test
      public void 身長_降順() {
        actressSearch.setSort(ActressSearchSort.HEIGHT_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          int actual = actressList.get(i - 1).getHeight();
          int expected = actressList.get(i).getHeight();
          assertThat(actual).isGreaterThanOrEqualTo(expected);
        }
      }

      @Test
      public void 生年月日_昇順() {
        actressSearch.setSort(ActressSearchSort.BIRTHDAY_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          LocalDate actual = actressList.get(i - 1).getBirthday();
          LocalDate expected = actressList.get(i).getBirthday();
          assertThat(actual).isBeforeOrEqualTo(expected);
        }
      }

      @Test
      public void 生年月日_降順() {
        actressSearch.setSort(ActressSearchSort.BIRTHDAY_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          LocalDate actual = actressList.get(i - 1).getBirthday();
          LocalDate expected = actressList.get(i).getBirthday();
          assertThat(actual).isAfterOrEqualTo(expected);
        }
      }

      @Test
      public void 女優ID_昇順() {
        actressSearch.setSort(ActressSearchSort.ID_ASC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          long actual = actressList.get(i - 1).getId();
          long expected = actressList.get(i).getId();
          assertThat(actual).isLessThanOrEqualTo(expected);
        }
      }

      @Test
      public void 女優ID_降順() {
        actressSearch.setSort(ActressSearchSort.ID_DESC);
        ActressSearchResult result = execute();
        List<Actress> actressList = result.getResult().getActress();
        for (int i = 1; i < actressList.size(); i++) {
          long actual = actressList.get(i - 1).getId();
          long expected = actressList.get(i).getId();
          assertThat(actual).isGreaterThanOrEqualTo(expected);
        }
      }

    }

    @Test
    public void 正常系_女優検索API実行_すべての検索条件() {
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
      ActressSearchResult actual = execute();
      ActressSearchResult expected = JsonUtil
          .read(actressSearch.getJson(), ActressSearchResult.class);
      assertThat(actual).isEqualTo(expected);
    }

  }

  @Test
  public void 正常系_getJson() {
    actressSearch.setActressId(26225);
    ActressSearchResult expected = execute();
    ActressSearchResult actual = JsonUtil.read(actressSearch.getJson(), ActressSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
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
    actressSearch.clear();
    assertThat(actressSearch).isEqualTo(new ActressSearch());
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setInitial_フォーマット不正() {
      String argument = "test";
      assertThatThrownBy(() -> actressSearch.setInitial(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0001, argument));
    }

    @Test
    public void 異常系_setGteBirthday_フォーマット不正() {
      String argument = "2019/01/01";
      assertThatThrownBy(() -> actressSearch.setGteBirthday(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0002, argument));
    }

    @Test
    public void 異常系_setLteBirthday_フォーマット不正() {
      String argument = "2019/01/01";
      assertThatThrownBy(() -> actressSearch.setLteBirthday(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0002, argument));
    }

  }

  public ActressSearchResult execute() {
    ActressSearchResult actressSearchResult = actressSearch.execute();
    assertThat(actressSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return actressSearchResult;
  }

}
