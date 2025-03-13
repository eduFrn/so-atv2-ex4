package controller;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSapo extends Thread {

	private int numero;
	private int tamanhoMaximo;
	private int distanciaMaxima;
	public AtomicInteger posicao;
	public int[] posicoes;
	
	public ThreadSapo(int numero, int tamanhoMaximo, int distanciaMaxima, AtomicInteger posicao, int[] posicoes) {
		this.numero = numero;
		this.tamanhoMaximo = tamanhoMaximo;
		this.distanciaMaxima = distanciaMaxima;
		this.posicao = posicao;
		this.posicoes = posicoes;
	}

	@Override
	public void run() {
		corrida();
	}

	public void corrida() {
		try {
			int distanciaPercorrida = 0;

			while (distanciaPercorrida < distanciaMaxima) {

				int percorrido = (int) (Math.random() * tamanhoMaximo + 1);

				distanciaPercorrida += percorrido;
				
				int distanciaRestante = distanciaMaxima - distanciaPercorrida;
				if(distanciaRestante < 0) distanciaRestante = 0;
				
				System.out.println("Sapo com identificador "+numero+" percorreu "+percorrido+" metros!\nDistancia percorrida ao todo: "+distanciaPercorrida+" | Faltam "+(distanciaRestante)+" metros.");
				sleep(500);
			}
			
			sleep(50*numero);
			
			posicoes[posicao.get()-1] = numero;

			System.out.println("\nRESULTADO: Sapo "+numero+" chegou até o fim da corrida. Posição: "+posicao.getAndIncrement()+"\n");


			if(posicao.get() == 6) {
				System.out.println("======PODIO DA CORRIDA======");
				System.out.println("           Sapo "+posicoes[0]+"           ");
				System.out.println("         1a posição         ");
				System.out.println("    Sapo "+posicoes[1]+"        Sapo "+posicoes[2]+"    ");
				System.out.println("  2a posição    3a posição  ");
				System.out.println("============================");
				
				System.out.println("Demais posições:");
				System.out.println("4a posição: Sapo "+posicoes[3]);
				System.out.println("5a posição: Sapo "+posicoes[4]);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
