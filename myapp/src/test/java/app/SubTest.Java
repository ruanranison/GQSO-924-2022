package app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;


public class SubTest {
    @Test
    public void Sub() {
        MockRouter router = new MockRouter(new App());
        router.get("/sub/5/2", rsp -> {
            assertEquals(3.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void sub_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/a/1", rsp -> {});
        });
    }
}