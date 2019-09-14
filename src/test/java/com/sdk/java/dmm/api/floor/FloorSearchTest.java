package com.sdk.java.dmm.api.floor;

import static org.assertj.core.api.Assertions.assertThat;

import com.sdk.java.dmm.api.ApiTestBase;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.utils.JsonUtil;
import org.junit.jupiter.api.Test;

public class FloorSearchTest extends ApiTestBase<FloorSearch> {

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
    assertThat(floorSearch).isEqualTo(new FloorSearch(getApiId(), getAffiliateId()));
  }

}
