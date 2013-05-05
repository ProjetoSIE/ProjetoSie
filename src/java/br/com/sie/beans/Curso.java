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
 * @author Marcos Costa
 */
@SequenceGenerator(name="SEQCURSO", sequenceName="SEQCURSO", allocationSize=1, initialValue=1)
@Entity(name="Curso")
@Table(name="Curso")
public class Curso implements Persistent{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQCURSO")
    @Column(name="cd_curso")
    private long id;
    
    @Column(name="nm_curso")
    private String nome;

    @Column(name="nm_periodo")
    private String periodo;
    
    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }        

    /**
     *
     * @return
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     *
     * @param periodo
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }        

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }        
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
}
