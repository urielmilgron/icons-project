package com.alkemy.icons.icons.entity;
import lombok.Getter; //con estas 2 dependencias se definen 
import lombok.Setter; //getter y setter

import javax.persistence.*; //Dependencia para entity y table.

@Entity //Con esto digo que continente Pais es un Entity
@Table(name = "Continente") //Definimos nombre de la tabla.
@Getter //Estos 2 crean automaticamente un set y get
@Setter //a cada no de los atributos.
public class ContinenteEntity {
 
	@Id //Le decimos que va a haber un ID
	//No hay column ya que iria el mismo nombre de columna.
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //Se genera un id en secuencia.
	private Long Id; //Declaro el atributo ID
	
	private String image;
	
	private String denominacion;
	
}
