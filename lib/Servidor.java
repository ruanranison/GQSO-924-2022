import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

public class Servidor {
    public static final int TAMANHO_BACKLOG = 100;

    public static void main(String[] args) throws IOException {
        InetSocketAddress bindAddr = new InetSocketAddress(36615);
        HttpServer server = HttpServer.create(bindAddr, TAMANHO_BACKLOG);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.createContext(IndexHandler.PATH, new IndexHandler());
        server.createContext(DivHandler.PATH, new DivHandler());
        server.createContext(SomaHandler.PATH, new SomaHandler());
        server.createContext(MultiHandler.PATH, new MultiHandler());
        server.createContext(SubHandler.PATH, new SubHandler());
        server.start();
        System.out.printf("Servidor ouvindo requisições na porta %s\n\n", server.getAddress().getPort());
    }
}