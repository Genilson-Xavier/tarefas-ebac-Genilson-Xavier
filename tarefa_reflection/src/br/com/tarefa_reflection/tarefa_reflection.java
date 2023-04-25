package br.com.tarefa_reflection;

import java.lang.reflect.Field;

import br.com.tarefa_reflection.Model.Cliente;

public class tarefa_reflection {
	public static void main(String[] args) {
		final Cliente cliente = new Cliente();
		retornaNomeDaTabelaAnotada(cliente);
	}
	
	public static void retornaNomeDaTabelaAnotada(final Object objeto) {
		final Class<?> classe = objeto.getClass();
		if(classe.isAnnotationPresent(Tabela.class)) {
			Tabela tabela = classe.getAnnotation(Tabela.class);
			System.out.println(" Nome da Tabela -> "+ tabela.nomeDaTabela());
		}
		final Field[] fields = classe.getDeclaredFields();
		for (final Field field : fields) {
			if(field.isAnnotationPresent(Tabela.class)) {
				Tabela tabela = field.getAnnotation(Tabela.class);
				System.out.println(" Nome da Coluna -> "+tabela.nomeDaColuna());
			}
		}
	}
}
