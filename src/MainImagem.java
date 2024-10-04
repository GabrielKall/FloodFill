import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainImagem {
    public static void main(String[] args) {
        try {
            // Carregar a imagem original para o Flood Fill com Pilha (DFS)
            File arquivoImagemOriginal = new File("C:\\Users\\gabri\\IdeaProjects\\TDE1\\src\\casa.png");
            BufferedImage imagemPilha = ImageIO.read(arquivoImagemOriginal);

            // Definir a cor nova (exemplo: vermelho para o método com Pilha)
            Color corNovaPilha = new Color(255, 0, 0);

            // Escolher uma coordenada inicial que esteja dentro da casa.
            int xInicial = 300; // Ajuste o valor para um ponto dentro da casa
            int yInicial = 300; // Ajuste o valor para um ponto dentro da casa

            // Aplicar Flood Fill na imagem usando Pilha (DFS)
            FloodFillImagem.floodFill(imagemPilha, xInicial, yInicial, corNovaPilha);

            // Salvar a imagem resultante do Flood Fill com Pilha
            File arquivoImagemResultadoPilha = new File("C:\\Users\\gabri\\IdeaProjects\\TDE1\\src\\casaPintadaPilha.png");
            ImageIO.write(imagemPilha, "png", arquivoImagemResultadoPilha);

            System.out.println("Flood Fill (DFS) aplicado e imagem salva como 'imagem_pintada_pilha.png'");

            // Carregar novamente a imagem original para o Flood Fill com Fila (BFS)
            BufferedImage imagemFila = ImageIO.read(arquivoImagemOriginal);

            // Definir a cor nova (exemplo: azul para o método com Fila)
            Color corNovaFila = new Color(0, 0, 255);

            // Aplicar Flood Fill na imagem usando Fila (BFS)
            FloodFillImagemFila.floodFill(imagemFila, xInicial, yInicial, corNovaFila);

            // Salvar a imagem resultante do Flood Fill com Fila
            File arquivoImagemResultadoFila = new File("imagem_pintada_fila.png");
            ImageIO.write(imagemFila, "png", arquivoImagemResultadoFila);

            System.out.println("Flood Fill (BFS) aplicado e imagem salva como 'imagem_pintada_fila.png'");

        } catch (IOException e) {
            System.err.println("Erro ao carregar ou salvar a imagem: " + e.getMessage());
        }
    }
}