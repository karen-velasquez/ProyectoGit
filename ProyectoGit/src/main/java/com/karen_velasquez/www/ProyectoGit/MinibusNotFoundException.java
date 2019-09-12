package com.karen_velasquez.www.ProyectoGit;

public class MinibusNotFoundException extends RuntimeException{
	MinibusNotFoundException(Long id) {
		    super("No se pudo encontrar el minibus " + id);
		  }
}
