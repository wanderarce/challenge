package br.com.wanderarce.meta.challenge.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Funcionarios {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Size(min = 14,max=14, message = "Informação deve conter 14 carateres alfanuméricos")
	private String cpf;
	
	@NotNull
	@Size(max=40, message = "Nome deve conter no máximo 40 caracteres")
	private String nome;
	
	private LocalDate dataNascimento;
	
	@NotNull
	@Size(min = 4,max=12, message = "Login deve conter entre 4 e 12 carateres alfanuméricos")
	private String login;
	
	@NotNull
	@Size(min = 12,max=12, message = "Senha deve conter 12 carateres alfanuméricos")
	private String senha;
	
	public Funcionarios() {}
	
	public Funcionarios(Integer id, String cpf, String nome, LocalDate dataNascimento, String login, String senha) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionarios [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", login=" + login
				+ ", senha=" + senha + "]";
	}
	
}
