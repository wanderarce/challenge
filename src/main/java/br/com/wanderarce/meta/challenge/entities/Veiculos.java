package br.com.wanderarce.meta.challenge.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Veiculos {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(max=10, message = "Informação deve conter 14 carateres alfanuméricos")
	private String placa;
	
	@NotNull
	@Size(min = 3,max=3, message = "Informe Sim ou Não para o campo Ativo")
	private String ativo;
	
	@NotNull
	@Size(min = 4,max=4, message = "Ano da fabricação deve conter 4 carateres alfanuméricos")
	private String anoFabricacao;
	
	@NotNull
	@Size(min = 14,max=14, message = "Ano do modelo deve conter 4 carateres alfanuméricos")
	private String anoModelo;
	
	@NotNull
	@Size(min = 14,max=14, message = "Chassi deve conter até 40 carateres alfanuméricos")
	private String chassi;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataDesativacao;
	
	@NotNull
	@Size(max=30, message = "Modelo deve conter até 30 carateres alfanuméricos")
	private String modelo;
	
	@NotNull
	@Size(max=20, message = "Cor deve conter 14 carateres alfanuméricos")
	private String cor;
	
	@NotNull
	@Size(min = 14,max=14, message = "Informação deve conter 14 carateres alfanuméricos")
	@Column(columnDefinition = "int default 4", nullable = false)
	private int passageiros;
	
	public Veiculos() {
		super();
	}
	
	public Veiculos(Integer id, String placa, String ativo, String anoFabricacao, String anoModelo, String chassi,
			LocalDate dataCadastro, LocalDate dataDesativacao, String modelo, String cor, int passageiros) {
		super();
		this.id = id;
		this.placa = placa;
		this.ativo = ativo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.chassi = chassi;
		this.dataCadastro = dataCadastro;
		this.dataDesativacao = dataDesativacao;
		this.modelo = modelo;
		this.cor = cor;
		this.passageiros = passageiros;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getDataDesativacao() {
		return dataDesativacao;
	}
	public void setDataDesativacao(LocalDate dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}
	
	@Override
	public String toString() {
		return "Veiculos [placa=" + placa + ", ativo=" + ativo + ", anoFabricacao=" + anoFabricacao + ", anoModelo="
				+ anoModelo + ", chassi=" + chassi + ", dataCadastro=" + dataCadastro + ", dataDesativacao="
				+ dataDesativacao + ", modelo=" + modelo + ", cor=" + cor + ", passageiros=" + passageiros + "]";
	}
	
}
