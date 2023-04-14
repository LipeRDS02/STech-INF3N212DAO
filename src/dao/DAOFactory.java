/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author 182120036
 */
public class DAOFactory {
    private static PessoaDAO pDAO = new PessoaDAO();
    
    public static PessoaDAO getPessoaDAO(){
        return pDAO;
    }
}
