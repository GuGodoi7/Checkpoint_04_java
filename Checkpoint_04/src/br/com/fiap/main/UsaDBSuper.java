//Gustavo Godoi da Silva; RM: 99585

package br.com.fiap.main;

import javax.swing.JOptionPane;
import br.com.fiap.bean.DragonBallSuper;

public class UsaDBSuper {

	public static void main(String[] args) {
		String aux, path, nome, ki, tecnicas, velocidade, transformacoes, continuar = "sim";
		int escolha;
		DragonBallSuper personagem;
		
		while (continuar.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog(" Qual operação deseja executar "
						+ "\n(1) Cadastrar Personagem"
						+ "\n(2) Consultar Personagem"); 
				escolha = Integer.parseInt(aux);

				path = JOptionPane.showInputDialog("Digite o caminho da pasta: ");
				personagem = new DragonBallSuper();
				
				switch (escolha) {
				case 1:
					nome = JOptionPane.showInputDialog("Informe o Nome Personagem");
					ki = JOptionPane.showInputDialog("Informe KI do Personagem");
					tecnicas = JOptionPane.showInputDialog("Informe as tecnicas Personagem");
					velocidade = JOptionPane.showInputDialog("Informe a velocidade Personagem");
					transformacoes = JOptionPane.showInputDialog("Informe as transformações Personagem");
					personagem.setNome(nome);
					personagem.setKi(Integer.parseInt(ki));
					personagem.setTecnicas(Integer.parseInt(tecnicas));
					personagem.setVelocidade(Integer.parseInt(velocidade));
					personagem.setTransformacoes(Integer.parseInt(transformacoes));
					
					JOptionPane.showMessageDialog(null, personagem.gravar(path));
					break;
				
				case 2:
					aux = JOptionPane.showInputDialog("Informe o nome do personagem: ");
					personagem.setNome(aux);
					personagem = personagem.ler(path);
					if (personagem == null) {
						JOptionPane.showMessageDialog(null, "Caminho ou pasta inexistente" );
						
					} else {
						JOptionPane.showMessageDialog(null, "Exibindo dados:"
								+ "\nCaminho: " + path
								+ "\nArquivo: " + path + "/" + personagem.getNome() + ".txt"
								+ "\nNome: " + personagem.getNome()
								+ "\nKi: " + personagem.getKi()
								+ "\nTecnicas: " + personagem.getTecnicas()
								+ "\nVelocidade: " + personagem.getVelocidade()
								+ "\nTransformações: " + personagem.getTransformacoes());
					break;
					}
				default:
					JOptionPane.showMessageDialog(null, "Escolha invalida");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		}
			continuar = JOptionPane.showInputDialog("Deseja continuar?");
		}
		JOptionPane.showMessageDialog(null, "*_* Programa finalizado. Volte sempre! *_*");
	}
}
