package br.com.javaPro_modulo1.desafio;


/**
 * @author Genilson.Xavier
 *
 */
public class Main {
	public static void main(String[] args) {
		int tamanhoMapa;
		
		EstruturaDeDadosHash map = new EstruturaDeDadosHash();
		
		// Inserir no hashmap 
		map.put(1, 4);
		map.put(2, 78);
		map.put(3, 1902);
		map.put(4, 43);
		map.put(5, 98765);
		
		
		// comecando em 1 porque minha primeira chave do maock é 1
		// usando get para retorno do valor
		tamanhoMapa = map.size;
		for(int i=1; i <= tamanhoMapa; i++) {
			if(map.get(i) != -1) {
				System.out.println(map.get(i));
			}else {
				tamanhoMapa++;
			}
		}
		
		// removendo 
		map.remove(3);
		System.out.println("\n");
		// comecando em 1 o for porque minha primeira chave do mock é 1
		// usando get para retorno do valor
		tamanhoMapa = map.size;
		for(int i=1; i <= tamanhoMapa; i++) {
			if(map.get(i) != -1) {
				System.out.println(map.get(i));
			}else {
				tamanhoMapa++;
			}
		}
		
		// Removendo todos elementos mapa 
		map.clear();
		for(int i=1; i <= map.size; i++) {
			System.out.println(map.get(i));
		}
	}
}
