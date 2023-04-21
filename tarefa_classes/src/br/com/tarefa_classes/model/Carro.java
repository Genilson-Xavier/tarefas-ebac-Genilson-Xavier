package br.com.tarefa_classes.model;

import java.util.Objects;

// Classe que representa um carro 
public class Carro {
    // Atributos ou Caracter�sticas de um carro
    public String modelo;
    public String marca;
    public String chassi;
    public String fabricante;
    
    // M�todos ou a��es de um carro
    /**M�todo para ligar o carro
   	* @return String - A��o executada
    */
    public void ligar() {
        System.out.println(this.modelo+" ligado!");
    }
    
    /**M�todo para desligar o carro
   	* @return String - A��o executada
    */
    public void desligar() {
        System.out.println(this.modelo+" desligado!");
    }
    
    /**M�todo para acelerar o carro
   	* @return String - A��o executada
    */
    public void acelerar() {
        System.out.println(this.modelo+" acelerando...");
    }
    
    /**M�todo para frear o carro
   	* @return String - A��o executada
    */
    public void frear() {
        System.out.println(this.modelo+" freando...");
    }

    // Construtor do metodo com parametros 
    /**Contrutor de objeto Carro
   	* @return Carro - retorna um objeto Carro preenchido com os dados passados
    */
	public Carro(String modelo, String marca, String chassi, String fabricante) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.chassi = chassi;
		this.fabricante = fabricante;
	}

	// Construtor principal usado no new sem parametros 
	public Carro() {
		super();
	}

	// getters e setters 
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	// todos os atributos do objeto
    /**M�todo para imprimir atributos do objeto
   	* @return String - Atributos do objeto Carro
    */
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", marca=" + marca + ", chassi=" + chassi + ", fabricante=" + fabricante
				+ "]";
	}

	// c�digo hash
    /**M�todo para retorna hash
   	* @return Integer - hashcode
    */
	@Override
	public int hashCode() {
		return Objects.hash(chassi, fabricante, marca, modelo);
	}

	// compara��o de objeto 
    /**M�todo para comparar objetos 
   	* @return boolean - retorna se objetos s�o iguais
    */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(chassi, other.chassi) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}
    
	
}
