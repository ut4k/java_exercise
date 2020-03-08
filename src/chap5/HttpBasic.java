package chap5;
//うごかない?
// import java.net.http;
// import java.httpclient;

public class HttpBasic {

    public static void main(String[] args) {
        var client = HttpClient.newHttpClient();
        var req = HttpRequest.newBuilder()
            .uri(URI.create("https://codezine.jp/"))
            .build();
        var res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println(res.body());
    }

}
