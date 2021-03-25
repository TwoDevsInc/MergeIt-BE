package com.twodevs.MergeIt.models.entities;
// Generated 25 mar. 2021 22:27:41 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Equipos generated by hbm2java
 */
@Entity
@Table(name = "equipos")
public class Equipos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Date createdAt;
	private Set<Proyectos> proyectoses = new HashSet<Proyectos>(0);
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	public Equipos() {
	}

	public Equipos(int id, Date createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	public Equipos(int id, String nombre, Date createdAt, Set<Proyectos> proyectoses, Set<Usuarios> usuarioses) {
		this.id = id;
		this.nombre = nombre;
		this.createdAt = createdAt;
		this.proyectoses = proyectoses;
		this.usuarioses = usuarioses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", nullable = false, length = 13)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipos")
	public Set<Proyectos> getProyectoses() {
		return this.proyectoses;
	}

	public void setProyectoses(Set<Proyectos> proyectoses) {
		this.proyectoses = proyectoses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "equipos_usuarios", joinColumns = {
			@JoinColumn(name = "id_equipo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_usuario", nullable = false, updatable = false) })
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}
