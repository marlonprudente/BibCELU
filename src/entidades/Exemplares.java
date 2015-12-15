/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mabaw
 */
@Entity
public class Exemplares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String livroID, exemplarID, bibliotecaID;
    public Emprestimos emprestimoID = null;

    public String getexemplarID() {
        return exemplarID;
    }

    public void setexemplarID(String id) {
        this.exemplarID = id;
    }
    
    public String getlivroID() {
        return livroID;
    }

    public void setlivroID(String id) {
        this.livroID = id;
    }
    public Emprestimos withwho(){
        return emprestimoID;
    }
   
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplares)) {
            return false;
        }
        Exemplares other = (Exemplares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Exemplares[ id=" + id + " ]";
    }
    
}
