package main.java.br.com.dao.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Persistente;

public abstract class GenericDao<T extends Persistente> implements IGenericDao<T> {
	
	private SingletonMap singletonMap;
	
	public abstract Class<T> getTipoClasse();

	public abstract void atualizarDados(T entity, T entityCadastrado);

	public GenericDao(){
		this.singletonMap = SingletonMap.getInstance();
	}

	public Long getChave(T entity) throws TipoChavenaoEncontradaException{
		Field[] fields = entity.getClass().getDeclaredFields();
		Long returnValue = null;
		for(Field field : fields) {
			if(field.isAnnotationPresent(TipoChave.class)){
				TipoChave tipoChave = field.getAnnotation(TipoChave.class);
				String nomeMetodo = tipoChave.value(); 
				try{
					Method method = entity.getClass().getMethod(nomeMetodo);
					returnValue = (Long) method.invoke(entity);
					return  returnValue;
				}catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
					e.printStackTrace();
					throw new TipoChavenaoEncontradaException(" chave principal do objeto "+ entity.getClass()+" não encontrado");
				}
			}
		}
		if(returnValue == null) {
			String msg = " chave principal do objeto "+ entity.getClass()+" não encontrado";
			System.out.println(" ***ERRO*** "+msg);
			throw new TipoChavenaoEncontradaException(msg);
		}
		return null;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChavenaoEncontradaException{
		Map<Long , T> mapaInterno = (Map<Long , T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		if(mapaInterno.containsKey(chave)){
			return false;
		}

		mapaInterno.put(chave, entity);
		return true;
	}
	
	@Override
	public void excluir(Long valor){
		Map<Long , T> mapaInterno = (Map<Long , T>) this.singletonMap.getMap().get(getTipoClasse());
		T objetoCadastrado = mapaInterno.get(valor);
		if(objetoCadastrado != null){
			mapaInterno.remove(valor, objetoCadastrado); 
		}
	}

	@Override
	public void alterar(T entity) throws TipoChavenaoEncontradaException{
		Map<Long , T> mapaInterno = (Map<Long , T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		T objetoCadastrado = mapaInterno.get(chave);
		if(objetoCadastrado != null){
			atualizarDados(entity, objetoCadastrado); 
		}
	}

	@Override
	public T consultar(Long valor){
		Map<Long , T> mapaInterno = (Map<Long , T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.get(valor);
	}

	@Override
	public Collection<T> buscarTodos(){
		Map<Long , T> mapaInterno = (Map<Long , T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.values();
	}
}
