import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão http e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        //pegar so os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List< Map<String,String> > listaDeFilmes = parser.parse(body);;
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));

        //exibir e manipular os dados na aplicação
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println("");
        }


        
    }
}
