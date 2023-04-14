/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static inf3n212.INF3N212.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120036
 */
public class CCarro {
  ArrayList<Carro> carros = new ArrayList();
  
  public void addCarro(Carro c){
      this.carros.add(c);
  }
  
  public void removeCarro(Carro c){
      this.carros.remove(c);
  }
  
  public ArrayList<Carro> getCarros(){
      return this.carros;
  }
  
  public Carro getCarroPlaca(String placa){
      Carro c = null;
      
      for (Carro carro : carros) {
        if (carro.getPlaca().equals(placa)){
            c = carro;
            break;
        }  
      }
      return c;
  }
  
  public void mockCarros(){
      Carro c1 = new Carro();
      c1.setPlaca("ABC1F34");
      c1.setAnoFab(2023);
      c1.setAnoMod(2023);
      c1.setMarca("Fiat");
      c1.setModelo("Fastback");
      c1.setTpCambio("Automatico");
      c1.setCombustivel("Gasolina");
      c1.setCor("Preto");
      c1.setProprietario(cadPessoa.getPessoaCPF("15975685231"));
      addCarro(c1);
      
      Carro c2 = new Carro();
      c2.setPlaca("DEF2H56");
      c2.setAnoFab(2006);
      c2.setAnoMod(2006);
      c2.setMarca("Chevrolet");
      c2.setModelo("Astra");
      c2.setTpCambio("Manual");
      c2.setCombustivel("Gasolina");
      c2.setCor("Vermelho");
      c2.setProprietario(cadPessoa.getPessoaCPF("30668518006"));
      addCarro(c2);
  }

    public void removePlaca(Carro c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}//fim classe carro
