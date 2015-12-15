/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Calendar;

/**
 *
 * @author mabaw
 */
public class Emprestimos {
    public Calendar datainicio;
    public Calendar datafim;
    
    public Usuario usuarioID;
    public Exemplares exemplar;
    public String EmprestimoID;
    
    public void setEmprestimo(Exemplares exemplar, Usuario usuarioID){
        this.datainicio = gettoday();
        this.EmprestimoID = this.datainicio.getTime().toString();
        this.datafim = datainicio;
        exemplar.emprestimoID = this; 
        datafim.add(Calendar.DATE ,5);
        int n = usuarioID.numerodeemprestimos;
        n++;
        usuarioID.emprestimos[n] = this;
}
    
    public void prolongarEmprestimo(){
        datafim.add(Calendar.DATE ,5);
    }
    
    public Calendar gettoday(){
            Calendar cal = Calendar.getInstance();
            return cal;
    }
    public void killEmprestimo() throws Throwable{
        this.usuarioID.numerodeemprestimos--;
        this.exemplar.emprestimoID = null;
        this.finalize();
    }
   

}
