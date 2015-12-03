package entidades;
/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "generos")
public class Generos implements Serializable {
    
    @Id
    private Integer genero_id;
    private String descricao;

    @OneToMany(mappedBy = "livro_genero", cascade = CascadeType.REFRESH)
    private List<Livros> genero_livros;

    public Generos() {
        genero_id = 0;
        descricao = "";
    }

    public Integer getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Integer genero_id) {
        this.genero_id = genero_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livros> getLivros() {
        return new ArrayList<>(genero_livros);
    }

    @Override
    public String toString() {
        return "[" + genero_id + "] " + descricao;
    }
}
