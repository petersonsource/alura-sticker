import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    private BufferedImage bufferedImage;

    public void cria(InputStream inputStream, String fileName) throws Exception  {

        //InputStream inputStream =
        //     new FileInputStream(new File("entrada/filme.jpeg"));
        //InputStream inputStream = 
        //    new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        //criar nova imagem com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        //configurar fonte
        Font font = new Font(Font.SERIF, Font.BOLD, 52);
        graphics.setColor(Color.BLACK);
        graphics.setFont(font);
    
        //escrever uma frase na nova imagem
        graphics.drawString("TOPZEIRA!", 100, novaAltura - 100);
            
        //escreve a nova iamgem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + fileName));

    }
    
}
