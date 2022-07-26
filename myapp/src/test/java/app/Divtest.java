package app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;


public class DivTest {
    @Test
    public void div() {
        MockRouter router = new MockRouter(new App());
        router.get("/div/2/2", rsp -> {
            assertEquals(4.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void div_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/a/1", rsp -> {});
        });
    }