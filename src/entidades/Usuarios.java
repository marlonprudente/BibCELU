package entidades;
/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    private Integer usuario_id;
    private String nome;
    private Integer privilegios;
    private Integer quarto;
    private String curso;
    private Integer telefone;
    private String email;
    private String login;
    private String senha;

    //@OneToMany(mappedBy = "reservas_usuario", cascade = CascadeType.REMOVE)
    private List<Reservas> usuario_reservas;

    public Usuarios() {
        usuario_id = 0;
        nome = "";
        privilegios = 0;
        quarto = 0;
        curso = "";
        telefone = 00000000;
        email = "";
        login = "";
        senha = "";
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Integer privilegios) {
        this.privilegios = privilegios;
    }

    public Integer getQuarto() {
        return quarto;
    }

    public void setQuarto(Integer quarto) {
        this.quarto = quarto;
    }

    public String getCurso() {
        return curso;
    }

    public void setCusro(String curso) {
        this.curso = curso;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Reservas> getReservas() {
        return usuario_reservas;
    }

    @Override
    public String toString() {
        return "[" + usuario_id + "] " + nome;
    }
}
