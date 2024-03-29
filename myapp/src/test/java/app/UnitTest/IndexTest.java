package app.UnitTest;
import io.jooby.MockRouter;
import io.jooby.StatusCode;
import org.junit.jupiter.api.Test;

import app.App;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexTest {
  @Test
  public void welcome() {
    MockRouter router = new MockRouter(new App());
    router.get("/", rsp -> {
      assertEquals("Bem-vindo a CalcApi!", rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }
}