package app;
import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.exception.BadRequestException;

@Path("/div/{op}/{op2}")
public class Div {

    @GET
    public double calculaDiv(@PathParam("op") String op, @PathParam("op2") String op2) {
        try {
          Double doubleOp = Double.parseDouble(op);
          Double doubleOp2 = Double.parseDouble(op2);
          return doubleOp / doubleOp2;
        } catch (NumberFormatException nfe) {
            throw new BadRequestException("Parâmetro(s) inválido(s)");
        }
    }
}