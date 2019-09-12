package com.karen_velasquez.www.ProyectoGit;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
	@Entity
	class Minibus{
		private @Id @GeneratedValue Long id;
		private int numero;
		private String p_partida;
		private String p_llegada;
		 
		Minibus(){}
			Minibus(int numero, String p_partida,String p_llegada){
				this.numero=numero;
				this.p_partida=p_partida;
				this.p_llegada=p_llegada;
		}

}
