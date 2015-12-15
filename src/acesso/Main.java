/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import entidades.*;
import javax.persistence.*;


/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        //1
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibCELUPU");
        //2
        EntityManager em = emf.createEntityManager();
        Generos g = em.find(Generos.class, 1);
        //3
        if(g != null){
            System.out.println(g.getGenero_id() +", "+g.getDescricao());
        }else{
            System.out.println("Não encontrado!");
        }
    }
}
