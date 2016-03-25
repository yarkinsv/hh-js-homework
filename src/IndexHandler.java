import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;


public class IndexHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {
        File file = new File("C:\\Users\\RRP-YarkinSV\\hh\\JsDragAndDrop\\out\\production\\JsDragAndDrop\\index.html").getCanonicalFile();
        t.sendResponseHeaders(200, 0);
        OutputStream os = t.getResponseBody();
        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fs.read(buffer)) >= 0) {
            os.write(buffer,0,count);
        }
        fs.close();
        os.close();
    }
}
