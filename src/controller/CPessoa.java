/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120036
 */
public class CPessoa {ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa=1;
    
    public int geraID(){
        return this.idPessoa++;
        
        /**
         * Autoincrement do java ++
         * Autoincrement idPessoa
         */
    }
    
    /**
     * Metódo addPessoa adiciona Pessoa no ArrayList pessoas
     * @param p 
     */
    public void addPessoa(Pessoa p){
        this.pessoas.add(p);
    }
    /**
     * Método removePessoa remove Pessoa do ArrayList pessoas
     * @param p 
     */
    public void removePessoa(Pessoa p){
        this.pessoas.remove(p);
    }
    public ArrayList<Pessoa> getPessoas(){
        return this.pessoas;
    }
    public Pessoa getPessoaCPF(String CPF){
        Pessoa p = null;
        for(Pessoa pes:pessoas){
            if (pes.getCpf().equals(CPF)) {
                p = pes; 
                break;
            }
        }//fim foreach
        return p;
    }
    
    
    public void mockPessoas(){
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("30668518006");
        p1.setNome("Filipe");
        p1.setTelefone("51998899898");
        p1.setEndereco("Rua do Estresse");
        addPessoa(p1);
        
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("15975685231");
        p2.setNome("Nathalia");
        p2.setTelefone("51914112021");
        p2.setEndereco("Rua da Calmaria");
        addPessoa(p2);
    }   
}//fim classe controller