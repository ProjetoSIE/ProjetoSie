/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author disou_000
 */
@SequenceGenerator(name = "SEQUNIDADE", sequenceName = "SEQUNIDADE",
        allocationSize = 1, initialValue = 1)
@Entity(name = "Unidade")
@Table(name = "Unidade")
public class Unidade implements Persistent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUNIDADE")
    @Column(name = "cd_unidade")
    private Long id;
    @Column(name = "nm_razao_social")
    private String razaoSocial;
    @Column(name = "nm_fantasia")
    private String nomeFantasia;
    @Column(name = "cd_cnpj")
    private int cnpj;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_abertura", nullable = false, length = 10)
    private Date abertura;
    @Column(name = "cd_inscricao_estadual")
    private int inscricaoEstadual;
    @Column(name = "cd_inscricao_municipal")
    private int inscricaoMunicipal;
    @Column(name = "nm_email")
    private String email;
    @Column(name = "nm_site")
    private String site;
    @Column(name = "ds_observacoe")
    private String observacoe;
    @Column(name = "nm_logradouro")
    private String logradouro;
    @Column(name = "nm_numero")
    private String numero; //private int numero;
    @Column(name = "nm_complemento")
    private String complemento;
    @Column(name = "nm_bairro")
    private String bairro;
    @Column(name = "nm_cep")
    private String cep; //private int cep;
    @Column(name = "nm_cidade")
    private String cidade;
    @Column(name = "nm_estado")
    private String estado;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the abertura
     */
    public Date getAbertura() {
        return abertura;
    }

    /**
     * @param abertura the abertura to set
     */
    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    /**
     * @return the inscricaoEstadual
     */
    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @param inscricaoEstadual the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    /**
     * @return the inscricaoMunicipal
     */
    public int getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(int inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the observacoe
     */
    public String getObservacoe() {
        return observacoe;
    }

    /**
     * @param observacoe the observacoe to set
     */
    public void setObservacoe(String observacoe) {
        this.observacoe = observacoe;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
