import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
public class Consulta {
    public Cambiar buscaMoneda(String denominacionBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b567e9d7a6af531af245c9c3/latest/"+denominacionBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cambiar.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión");
        }

    }
}
