/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author mabaw
 */
public class Usuario extends Usuarios {
    public float multa;
    public Emprestimos[] emprestimos;
    public LivrosIndicados[] indicacoes;
    public int numerodeemprestimos, numerodeindicacoes;  
    
    public void setmulta(float valor){ 
        multa += valor;

    }
    public float getmulta(float valor){ 
        return valor;

    }
    public void paymulta(float valor){ 
        multa -= valor;

    }
    
    
    
    
}
