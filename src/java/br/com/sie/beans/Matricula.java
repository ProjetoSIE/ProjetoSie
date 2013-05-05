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
 * @author Marcos Costa
 */
@SequenceGenerator(name="SEQMATRICULA", sequenceName="SEQMATRICULA", allocationSize=1, initialValue=1)
@Entity(name="Matricula")
@Table(name="Matricula")
public class Matricula implements Persistent{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQMATRICULA")
    @Column(name="cd_matricula")
    private long id;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="cd_curso")
    private Curso curso;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="cd_aluno")
    private Aluno aluno;

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
    public Curso getCurso() {
        return curso;
    }

    /**
     *
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     *
     * @return
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     *
     * @param aluno
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }        

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }        
        final Matricula other = (Matricula) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
    
}
