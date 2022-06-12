package com.alkemy.icons.icons.entity;
import lombok.Getter; //con estas 2 dependencias se definen 
import lombok.Setter; //getter y setter

import java.util.*;

import javax.persistence.*;

@Entity //Con esto digo que continente Pais es un Entity
@Table(name = "Pais")
@Getter
@Setter
public class PaisEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	private String image;
	
	private String denominacion;
	
	@Column(name = "cant_habitantes") //Definimos la columna ya que si o si va a ser diferente nombre por buenas prácticas
	private Long cantidadHabitantes;
	
	private Long superficie; //Metros cuadrados.
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //Muchos a uno, o sea que un contiente tiene muchos paises.
	@JoinColumn(name = "continente_id", insertable = false, updatable = false) //Aca definimos como vamos a entrar a la tabla de Continentes
	private ContinenteEntity continente; //Este es solo para buscar informacion, retornando objeto de tipo continente 
	
	@Column(name = "continente_id", nullable = false) 
	private Long contintenteId; //En este guardamos y actualizamos datos
	
	@ManyToMany( //Esté mtm engloba a icons
			cascade = {
					CascadeType.PERSIST, //Cuando creamos un pais, icons tambien se guardan
					CascadeType.MERGE //Cuando guardamos cambios en el pais, tambien icons
	})
	@JoinTable( //Aca definimos como se combinan los datos de esta relacion.
	name = "icon_pais", //Nombre de la tabla intermedia.
	joinColumns = @JoinColumn(name = "pais_id"), //Definimos a id de pais
	inverseJoinColumns = @JoinColumn(name = "icon_id")) //Definimos id para icon en la tabla entre estos dos
	
	private Set<IconEntity> icons = new HashSet<>();
}
