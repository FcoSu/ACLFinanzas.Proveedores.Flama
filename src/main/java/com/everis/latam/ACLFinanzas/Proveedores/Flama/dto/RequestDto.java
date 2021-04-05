package com.everis.latam.ACLFinanzas.Proveedores.Flama.dto;


import java.io.Serializable;

import lombok.Data;

@Data
public class RequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	String idProveedor;
	String nombreArea;
	String responsable;
	String email;
	String ceco;
	int idAprovador;
	int numero;
	int monto;
	float iva;
	String prioridad;
	int idSolicitud;
}
