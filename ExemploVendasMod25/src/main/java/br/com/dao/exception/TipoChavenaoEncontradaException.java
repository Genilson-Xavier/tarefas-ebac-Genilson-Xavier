package main.java.br.com.dao.exception;

public class TipoChavenaoEncontradaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoChavenaoEncontradaException(String msg){ this(msg, null); }

	public TipoChavenaoEncontradaException(String msg, Throwable e){ super(msg, e); }
}
