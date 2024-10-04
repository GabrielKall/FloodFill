import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFillImagemFila {

    public static void floodFill(BufferedImage imagem, int x, int y, Color corNova) {
        int corAntiga = imagem.getRGB(x, y);
        int corNovaRGB = corNova.getRGB();

        if (corAntiga == corNovaRGB) return;

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        Fila filaX = new Fila(largura * altura);
        Fila filaY = new Fila(largura * altura);

        filaX.enqueue(x);
        filaY.enqueue(y);

        while (!filaX.isEmpty()) {
            int atualX = filaX.dequeue();
            int atualY = filaY.dequeue();

            // Verifica se a posição está dentro dos limites da imagem
            if (atualX < 0 || atualX >= largura || atualY < 0 || atualY >= altura) {
                continue;
            }

            int corAtual = imagem.getRGB(atualX, atualY);

            // Verifica se a cor é igual à cor antiga (tolerância opcional pode ser adicionada aqui também)
            if (corAtual != corAntiga) {
                continue;
            }

            // Pinta o pixel com a nova cor
            imagem.setRGB(atualX, atualY, corNovaRGB);

            // Adiciona as coordenadas adjacentes (cima, baixo, esquerda, direita) na fila
            filaX.enqueue(atualX + 1); filaY.enqueue(atualY);     // Baixo
            filaX.enqueue(atualX - 1); filaY.enqueue(atualY);     // Cima
            filaX.enqueue(atualX);     filaY.enqueue(atualY + 1); // Direita
            filaX.enqueue(atualX);     filaY.enqueue(atualY - 1); // Esquerda
        }
    }
}