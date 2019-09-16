package com.sdk.java.dmm.api.floor;

import static org.assertj.core.api.Assertions.assertThat;

import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.ApiTestBase;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.utils.JsonUtil;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class FloorSearchTest extends ApiTestBase {

  private final FloorSearch floorSearch = create(FloorSearch.class);

  @Test
  public void 正常系_execute() {
    FloorSearchResult result = floorSearch.execute();
    assertThat(result).isNotNull();
  }

  @Test
  public void 正常系_getJson() {
    FloorSearchResult expected = floorSearch.execute();
    FloorSearchResult actual = JsonUtil.read(floorSearch.getJson(), FloorSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    floorSearch.clear();
    assertThat(floorSearch).isEqualTo(create(FloorSearch.class));
  }

  @Test
  public void 異常系_リクエストが不正な場合() throws Exception {
    Field field = AbstractDmm.class.getDeclaredField("API_ID");
    field.setAccessible(true);
    field.set(floorSearch, "");
    FloorSearchResult result = floorSearch.execute();
    assertThat(result.getResult().getStatus()).isEqualTo(400);
    assertThat(result.getResult().getMessage()).isEqualTo("BAD REQUEST");
  }

}
