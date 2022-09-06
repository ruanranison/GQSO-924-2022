package app.IntegrationTest;
import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import app.App;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class SumIntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void checaErroSum(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sum/a/a")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checaSucessoSum(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sum/10/7")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("17.0", rsp.body().string());
    }
  }
}