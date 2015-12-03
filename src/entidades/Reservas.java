/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */

@Entity
@Table(name = "reserva")
public class Reservas implements Serializable {
    @Id
    private Integer reserva_id;
    
    private Integer livro_id;
    private Integer usuario_id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datadeemprestimo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datadedevolucao;
    
    @ManyToMany
    @JoinTable( name = "reserva",
                joinColumns = @JoinColumn(name="PEDIDO_ID"),
                inverseJoinColumns = @JoinColumn(name = "LIVRO_ID"))
    List<Livros> reserva_livros;
    
    
    
    
}
