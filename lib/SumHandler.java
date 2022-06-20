import static java.net.HttpURLConnection.HTTP_OK;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SumHandler implements HttpHandler {

    public static final String PATH = "/sum";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        String[] partes = conn.getRequestURI().getPath().split("/");
        String parametro1 = partes[2];
        String parametro2 = partes[3];
        byte[] result = calculateResponse(parametro1, parametro2);
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

    byte[] calculateResponse(String parametro1, String parametro2) {
        double n1 = Double.parseDouble(parametro1);
        double n2 = Double.parseDouble(parametro2);
        double sub = n1 + n2;
        return Double.toString(sub).getBytes();
    }
}