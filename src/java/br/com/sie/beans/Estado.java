/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Elo
 */
@SequenceGenerator(name = "SEQESTADO", sequenceName = "SEQESTADO",
allocationSize = 1, initialValue = 1)
@Entity(name = "Estado")
@Table(name = "TB_ESTADO")
public class Estado implements Persistent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQESTADO")
    @Column(name = "ID_ESTADO")
    private long id;
    @Column(name = "NM_ESTADO")
    private String nome;

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
}
