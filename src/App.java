import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão http e buscar os top 250 filmes
        
        //String url = "https://api.mocki.io/v2/549a5d8b";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
          
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
  
        String url = "https://alura-llinguagens-api.herokuapp.com/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        //exibir e manipular os dados na aplicação
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (Conteudo conteudo : conteudos) {
        
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String filename = conteudo.getTitulo() + ".png";
           
            geradora.cria(inputStream, filename);

            System.out.println(conteudo.getTitulo());
        }
        
    }
}
