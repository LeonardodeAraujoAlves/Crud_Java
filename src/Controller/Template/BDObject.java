/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Template;

/**
 *
 * @author L.A.A
 */
public abstract class BDObject {
    public abstract void inserir(String nome_heroi, String identidade_heroi, int idade_heroi,double altura_heroi, String inimigo_heroi);
    public abstract void inserir(String nome_vilao, String organizacao_vilao, double altura_vilao, String inimigo_vilao,String lugar_principal,String arma,int quant_vitimas,String mascote_vilao);
    public abstract void atualizar();
    public abstract void deletar();
    public abstract void mostrar();
    
}
