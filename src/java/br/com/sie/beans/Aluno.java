/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sie.beans;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcos Costa
 */
@SequenceGenerator(name="SEQALUNO", sequenceName="SEQALUNO", allocationSize=1, initialValue=1)
@Entity(name="Aluno")
@Table(name="Aluno")
public class Aluno implements Persistent{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQALUNO")
    @Column(name="cd_aluno")
    private long id;
   
    @Column(name="nm_aluno")
    private String nome;
    
    @Column(name="cd_telefone")
    private String telefone;
    
    @Column(name="cd_celular")
    private String celular;
    
    @Column(name="nm_email")
    private String email;
    
    @OneToMany(mappedBy="aluno", fetch= FetchType.EAGER)    
    private List<Matricula> matriculas;
        

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
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public String getCelular() {
        return celular;
    }

    /**
     *
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }   

    /**
     *
     * @return
     */
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    /**
     *
     * @param matriculas
     */
    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }      
        final Aluno other = (Aluno) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }   
    
}
