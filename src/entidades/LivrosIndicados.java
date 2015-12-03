/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.*;


/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
@Entity
@Table(name = "livrosindicados")
public class LivrosIndicados {
    @Id
    private Integer indicacao_id;
    private String titulo;
    private String volume;
    private Integer ano;
    private String editora;
    private String motivo;
    private String usuario_id;      
        
    
    public Integer getId() {
        return indicacao_id;
    }

    public void setIndicacaoId(Integer id) {
        this.indicacao_id = id;
    }
    
}
