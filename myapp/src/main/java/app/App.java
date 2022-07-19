package app;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", ctx -> "Bem-vindo a CalcApi!");
    mvc(new Soma());
    mvc(new Sub());
    mvc(new Div());
    mvc(new Multi());
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}