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
@SequenceGenerator(name = "SEQCIDADE", sequenceName = "SEQCIDADE",
allocationSize = 1, initialValue = 1)
@Entity(name = "Cidade")
@Table(name = "TB_CIDADE")
public class Cidade implements Persistent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQCIDADE")
    @Column(name = "ID_CIDADE")
    private long id;
    @Column(name = "NM_CIDADE")
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
