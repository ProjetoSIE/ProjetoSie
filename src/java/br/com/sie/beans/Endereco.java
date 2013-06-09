/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Elo
 */
@SequenceGenerator(name = "SEQENDERECO", sequenceName = "SEQENDERECO",
allocationSize = 1, initialValue = 1)
@Entity(name = "Endereco")
@Table(name = "TB_ENDERECO")
public class Endereco implements Persistent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQENDERECO")
    @Column(name = "ID_ENDERECO")
    private long id;
    @Column(name = "NM_LOGRADOURO_ENDERECO")
    private String logradouro;
    @Column(name = "CD_NUMERO_ENDERECO")
    private int numero;
    @Column(name = "CD_COMPLEMENTO_ENDERECO")
    private String complemento;
    @Column(name = "NM_BAIRRO_ENDERECO")
    private String bairro;
    @Column(name = "CD_CEP_ENDERECO")
    private int cep;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE")
    private Cidade cidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
