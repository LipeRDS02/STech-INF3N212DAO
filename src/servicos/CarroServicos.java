/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.CarroDAO;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120036
 */
public class CarroServicos {
    public void cadastroCarro(Carro cVO){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.cadastrarCarroDAO(cVO);
    }
    
    public ArrayList<Carro> getCarros(){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.getCarros();
    }
    
    public Carro getCarroByDoc(String placa){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        return cDAO.getCarroByDoc(placa);
    }
    
    public void atualizarPessoa(Carro cVO){
        CarroDAO cDAO = DAOFactory.getCarroDAO();
        cDAO.atualizarCarroDAO(cVO);
    }
    
    public void deletarPessoa(String placa){
        CarroDAO pDAO = DAOFactory.getCarroDAO();
        pDAO.deletarCarroDAO(placa);
    }
}