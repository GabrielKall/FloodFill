import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainImagem {
    public static void main(String[] args) {
        try {
            File arquivoImagemOriginal = new File("C:\\Users\\gabri\\IdeaProjects\\TDE1\\src\\casa.png");
            BufferedImage imagemPilha = ImageIO.read(arquivoImagemOriginal);
            
            Color corNovaPilha = new Color(255, 0, 0);
            
            int xInicial = 300;
            int yInicial = 300;

           
            FloodFillImagem.floodFill(imagemPilha, xInicial, yInicial, corNovaPilha);

            
            File arquivoImagemResultadoPilha = new File("C:\\Users\\gabri\\IdeaProjects\\TDE1\\src\\casaPintadaPilha.png");
            ImageIO.write(imagemPilha, "png", arquivoImagemResultadoPilha);

            System.out.println("Flood Fill (DFS) aplicado e imagem salva como 'imagem_pintada_pilha.png'");

            
            BufferedImage imagemFila = ImageIO.read(arquivoImagemOriginal);

            
            Color corNovaFila = new Color(0, 0, 255);

           
            FloodFillImagemFila.floodFill(imagemFila, xInicial, yInicial, corNovaFila);

           
            File arquivoImagemResultadoFila = new File("C:\\Users\\gabri\\IdeaProjects\\TDE1\\src\\imagem_pintada_fila.png");
            ImageIO.write(imagemFila, "png", arquivoImagemResultadoFila);

            System.out.println("Flood Fill (BFS) aplicado e imagem salva como 'imagem_pintada_fila.png'");

        } catch (IOException e) {
            System.err.println("Erro ao carregar ou salvar a imagem: " + e.getMessage());
        }
    }
}
