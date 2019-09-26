package com.carlosdv93.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.carlosdv93.utils.TipoCliente;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String cgc;
	private TipoCliente tipo;
	
	//@OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity=Telefone.class)
	//private List<Telefone> telefones;

	private int ddd;
	private long numeroTel;
	
	public Cliente() {

	}

	public Cliente(String nome, String cgc, TipoCliente tipo, int ddd, long numeroTel) {
		super();
		this.nome = nome;
		this.cgc = cgc;
		this.tipo = tipo;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCgc() {
		return cgc;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public int getDdd() {
		return ddd;
	}

	public long getNumeroTel() {
		return numeroTel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public void setNumeroTel(long numeroTel) {
		this.numeroTel = numeroTel;
	}

}
