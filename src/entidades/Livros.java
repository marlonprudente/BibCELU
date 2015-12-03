
package entidades;

/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="livros")
public class Livros implements Serializable {
    @Id
    private Integer livro_id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name ="GENERO_ID")
    private Generos livro_genero;
    
    private Integer quantidade;
    private Integer reserva;
      /*Como representar um BLOB? Array de bytes*/
    @Lob
    private Byte[] capa;  

    @ManyToMany
    @JoinTable( name = "reserva",
                joinColumns = @JoinColumn(name="LIVRO_ID"),
                inverseJoinColumns = @JoinColumn(name = "PEDIDO_ID"))
    List<Reservas> livro_reservados;
    
    public Livros(){
        livro_id = 0;
        titulo = "";
        autor = "";
        editora = "";
        ano = 0;
        descricao = "";
        quantidade = 0;
        reserva = 0;
    }
    
    public Integer getLivro_id()                    {return livro_id;}
    public void setLivro_id(Integer livro_id)       {this.livro_id = livro_id;}
    
    public String getTitulo()                   {return titulo;}
    public void setTitulo(String titulo)        {this.titulo = titulo;}

    public String getAutor()                    {return autor;}
    public void setAutor(String autor)          {this.autor = autor;}
    
    public String getEditora()                  {return editora;}
    public void setEditora(String editora)      {this.editora = editora;}
    
    public Integer getAno()                         {return ano;}
    public void setAno(Integer ano)                 {this.ano = ano;}
    
    public String getDescricao()                {return descricao;}
    public void setDescricao(String descricao)  {this.descricao = descricao;}
    
    public Integer getQuantidade()                     {return quantidade;}
    public void setEstoque(Integer estoque)         {this.quantidade = quantidade;}
    
    public Integer getReserva()                     {return reserva;}
    public void setReserva(Integer reserva)         {this.reserva = reserva;}
    
//    public Image getCapa()                      {return ImageIO.;}   
    public Byte[] getCapaByte()                 {return capa;}
    public void setCapa(Byte[] capa)            {this.capa = capa;}
    
    public Generos getGenero()                  {return livro_genero;}
    public void setGenero(Generos genero)       {this.livro_genero = genero;} 
    
    public List<Reservas> getPedidos()           {return new ArrayList<>(livro_reservados);}
    
    @Override
    public String toString(){return "["+livro_id+"] "+titulo;}
}
