package br.com.everton.neg.apps.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Arquivo {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Integer id;
	   
	   @Column(name="nome", length=100, nullable=false)
	   private String nome_do_arquivo;
	   
	   @Lob @Basic(fetch = FetchType.LAZY)
	   @Column(name="conteudo", nullable=false)
	   private byte[] conteudo;
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_do_arquivo() {
		return nome_do_arquivo;
	}
	public void setNome_do_arquivo(String nome_do_arquivo) {
		this.nome_do_arquivo = nome_do_arquivo;
	}
	public byte[] getConteudo() {
		return conteudo;
	}
	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

}
