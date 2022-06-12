package com.alkemy.icons.icons.entity;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	
	private String denominacion;
	
	@Column(name = "fecha_creacion")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaCreacion;
	
	private Long altura;
	
	private String historia;
	
	@ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL) //La definicion del mtm "icons" está en paises
	private List<PaisEntity> paises = new ArrayList<>(); //Entonces lo busca en paises.
}
