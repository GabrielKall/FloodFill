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

            if (atualX < 0 || atualX >= largura || atualY < 0 || atualY >= altura || imagem.getRGB(atualX, atualY) != corAntiga) {
                continue;
            }
            
            imagem.setRGB(atualX, atualY, corNovaRGB);

            pilhaX.push(atualX + 1); pilhaY.push(atualY);     // Baixo
            pilhaX.push(atualX - 1); pilhaY.push(atualY);     // Cima
            pilhaX.push(atualX);     pilhaY.push(atualY + 1); // Direita
            pilhaX.push(atualX);     pilhaY.push(atualY - 1); // Esquerda
        }
    }
}
