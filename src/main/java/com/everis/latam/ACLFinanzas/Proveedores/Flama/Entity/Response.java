package com.everis.latam.ACLFinanzas.Proveedores.Flama.Entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Response {
	
	String estatus;
	int montoTotal;
	int idResolucion;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date fechaResolucion;
	int idSolicitud;
}

