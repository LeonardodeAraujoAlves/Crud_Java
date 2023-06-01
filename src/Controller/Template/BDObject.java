/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Template;

/**
 * Esta classe se trata de um template method
 * que deverá ser implementado nas classes que
 * realizam operações no banco de dados
 *
 * @author L.A.A
 */
public abstract class BDObject {

    public BDObject() {
    }
    
    
    
   public abstract void inserir();
   public abstract void atualizar();
   public abstract void deletar(String nome);
   public abstract void deletarTodos();
   public abstract void mostrar();
    
}
