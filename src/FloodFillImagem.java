import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFillImagem {

    public static void floodFill(BufferedImage imagem, int x, int y, Color corNova) {
        int corAntiga = imagem.getRGB(x, y);
        int corNovaRGB = corNova.getRGB();

        if (corAntiga == corNovaRGB) return;

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        Pilha pilhaX = new Pilha(largura * altura);
        Pilha pilhaY = new Pilha(largura * altura);

        pilhaX.push(x);
        pilhaY.push(y);

        while (!pilhaX.isEmpty()) {
            int atualX = pilhaX.pop();
            int atualY = pilhaY.pop();

            // Verifica se a posição está dentro dos limites da imagem e se a cor é a que queremos substituir
            if (atualX < 0 || atualX >= largura || atualY < 0 || atualY >= altura || imagem.getRGB(atualX, atualY) != corAntiga) {
                continue;
            }

            // Pinta o pixel com a nova cor
            imagem.setRGB(atualX, atualY, corNovaRGB);

            // Adiciona as coordenadas adjacentes (cima, baixo, esquerda, direita)
            pilhaX.push(atualX + 1); pilhaY.push(atualY);     // Baixo
            pilhaX.push(atualX - 1); pilhaY.push(atualY);     // Cima
            pilhaX.push(atualX);     pilhaY.push(atualY + 1); // Direita
            pilhaX.push(atualX);     pilhaY.push(atualY - 1); // Esquerda
        }
    }
}