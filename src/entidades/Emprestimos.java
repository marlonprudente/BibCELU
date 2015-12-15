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
    public String exemplarID, usuarioID;
    
    public void setEmprestimo(String exemplarID, String usuarioID){
        this.datainicio = gettoday();
        this.datafim = datainicio;
        datafim.add(Calendar.DATE ,5);
}
    public void prolongarEmprestimo(){
        datafim.add(Calendar.DATE ,5);
    }
    
    public Calendar gettoday(){
            Calendar cal = Calendar.getInstance();
            return cal;
    }
    public void killEmprestimo() throws Throwable{
        this.finalize();
    }
   

}
