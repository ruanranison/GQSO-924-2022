import static java.net.HttpURLConnection.HTTP_OK;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DivHandler implements HttpHandler {

    public static final String PATH = "/div";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        String[] partes = conn.getRequestURI().getPath().split("/");
        String p1 = partes[2];
        String p2 = partes[3];
        byte[] result = calculateResponse(p1, p2);
        try {
            conn.sendResponseHeaders(HTTP_OK, result.length);
            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");
            try (OutputStream out = conn.getResponseBody()) {
                out.write(result);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    byte[] calculateResponse(String p1, String p2) {
        double n1 = Double.parseDouble(p1);
        double n2 = Double.parseDouble(p2);
        double div = n1 / n2;
        return Double.toString(div).getBytes();
    }
}