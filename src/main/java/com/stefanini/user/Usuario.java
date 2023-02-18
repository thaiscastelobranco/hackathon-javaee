package com.stefanini.user;

import io.quarkus.security.jpa.Password;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_id")
    private Long id;

    @Column(name = "desc_nome", nullable = false)
    @NotBlank
    @Size(max = 50)
    private String nome;

    @Column(name = "cod_login", nullable = false, unique = true)
    @Size(min = 5, max = 20)
    private String login;

    @Column(name = "desc_email", nullable = false)
    @NotBlank
    @Email
    @Size(min = 10)
    private String email;

    @Column(name = "desc_password", nullable = false)
    @Password
    @Size(min = 4, max = 10)
    private String senha;

    @Column(name = "dat_birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataNascimento;

    @Column(name = "dat_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dataCriacao;

    @Column(name = "dat_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date dataModificacao;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String email, String senha, Date dataNascimento, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", data=" + dataNascimento +
                '}';
    }
}
