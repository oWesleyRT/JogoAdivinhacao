import javax.swing.JOptionPane;

import java.util.Random;

public class JogoAdvinhacao {

	public static void main(String[] args) throws InterruptedException {
		//lista para armazenar os rounds com CHAR
		char[] rounds = new char [3];
		
		//variável para armazenar o round atual
		int roundAtual = 0;
		
		System.out.println("Começando PAR ou ÍMPAR melhor de 3!");
		
		//corpo do jogo
		while(roundAtual < 3) {
			
			//escolha se quer par ou ímpar - 0 é par e 1 é impar
			int escolha = 3;
			for (int i = 0; i < 1;) {
				escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha 0 = PAR ou 1 = IMPAR"));
				if (escolha == 0) {
					System.out.println("O jogador escolheu PAR");
					i++;
				} else if (escolha == 1) {
					System.out.println("O jogador escolheu IMPAR");
					i++;
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}
			}
			
			//escolha da jogada
			int jogada1 = 0;
			for (int i = 0; i < 1;) {
				jogada1 = Integer.parseInt(JOptionPane.showInputDialog("Faça sua jogada, escolha 1 ou 2"));
				if (jogada1 == 1 || jogada1 == 2) {
					i++;
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}		
			}
			
			//jogada da CPU
			System.out.println("Agora é a vez da CPU jogar...");
			Thread.sleep(2000);//atrasa 1 segundo
			Random random = new Random();
			int jogada2 = random.nextInt(2) + 1;
			System.out.println(jogada2);
			JOptionPane.showMessageDialog(null, "A CPU jogou: " + jogada2); 
			
			//calculo do vencedor
			System.out.println("Calculando o vencedor");
			Thread.sleep(2000);
			int soma = (int) (jogada1 + jogada2);
			boolean resultadoPar = soma % 2 == 0;
			if(resultadoPar == true && escolha == 0 || resultadoPar == false && escolha == 1) {
				JOptionPane.showMessageDialog(null, "O jogador ganhou este round!");
				rounds[roundAtual++] = 'J';
			} else {
				JOptionPane.showMessageDialog(null, "A CPU ganhou este round!");
				rounds[roundAtual++] = 'C';
			}
			
			//vitória se o jogador ou a máquina ganharam 2 seguidas
			if(roundAtual == 2) {
				if(rounds[0] == 'J' && rounds[1] == 'J') {
					JOptionPane.showMessageDialog(null, "O jogador ganhou duas em sequência!");
					break;
				} else if (rounds [0] == 'C' && rounds[1] == 'C'){
					JOptionPane.showMessageDialog(null, "A CPU ganhou duas em sequência");
					break;
				}
			} else if(roundAtual == 3) {
				if(rounds[2] == 'J') {
					JOptionPane.showMessageDialog(null, "O jogador ganhou a melhor de 3!");
					break;
				} else if(rounds[2] == 'C') {
					JOptionPane.showMessageDialog(null, "A CPU ganhou a melhor de 3!");
					break;
				}
			}
		}
	}
}
