package view;

import java.util.concurrent.atomic.AtomicInteger;

import controller.ThreadSapo;

public class Main {
	public static void main(String[] args) {

		int distanciaPercurso = (int)(Math.random()*50);
		
		AtomicInteger posicao = new AtomicInteger(1);
		
		int[] posicoes = new int[5];
		
		for(int i = 0; i < 5;i++) {
			ThreadSapo threadSapo = new ThreadSapo(i+1, (int)(Math.random() * 30), distanciaPercurso, posicao, posicoes);
			threadSapo.start();
		}
	}
}
