/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

/**
 *
 * @author 182120036
 */
public class INF3N212 {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;
        do {
            System.out.println("--Sistema de Cadastro--");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
                                    deletarCarro();
                                }
                                break;
                            case 0:

                                break;
                            default:
                                System.out.println("--Opção inválida, tente novamente!--");
                        }
                    } while (opSM != 0);
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário");
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
            }
        } while (opM != 0);

    }// fime método main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro: " + i.getMessage() + "\nTente Novamente!");
            leiaNumInt();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("--Menu Principal--");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite Aqui: ");
    }//fim menuP

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }
        System.out.println("--Ger. " + subM + " --");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite aqui: ");
    }//fim subMenu

    private static void cadastrarPessoa() {
        System.out.println("Cadastrar Pessoa");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.getPessoaCPF(cpf) != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.println("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome() + " cadastrado com sucesso!");
    }

    private static void cadastrarCarro() {
        System.out.println("Cadastrar Carro");
        String placa;
        String marca;
        String modelo;
        int anoFab;
        int anoMod;
        String cor;
        String tpCambio;
        String combustivel;
        Pessoa proprietario;
        boolean pCarro = true;
        do {            
            System.out.println("Informe a Placa: ");
            placa = leia.nextLine();
            placa = placa.toUpperCase();
            pCarro = Validadores.validarPlaca(placa);
            if (pCarro) {
                Carro carro = cadCarro.getCarroPlaca(placa);
                if (carro == null) {
                    System.out.println("Informe a marca: ");
                    marca = leia.nextLine();
                    System.out.println("Informe a modelo: ");
                    modelo = leia.nextLine();
                    do{
                        System.out.println("Informe o ano fab.: ");
                        anoFab = leiaNumInt();
                        System.out.println("Informe o ano mod.: ");
                        anoMod = leiaNumInt();
                        if (!Validadores.validarAnoCarro(anoFab, anoMod)) {
                            System.out.println("Ano inválido, tente novamente!");
                        }
                    }while(!Validadores.validarAnoCarro(anoFab, anoMod));
                    System.out.println("Informe a cor: ");
                    cor = leia.nextLine();
                    System.out.println("Informe a tipo de câmbio: ");
                    tpCambio = leia.nextLine();
                    System.out.println("Informe a combustível: ");
                    combustivel = leia.nextLine();
                    do {                        
                        System.out.println("Informe o CPF do proprietário");
                        String cpf = leia.nextLine();
                        proprietario = cadPessoa.getPessoaCPF(cpf);
                        if (proprietario == null) {
                            System.out.println("CPF não cadastrado, tente novamente!");
                        }else{
                            System.out.println("Pessoa selecionada: " + proprietario.getNome());
                            System.out.println("Este é o prorpietário? ");
                            System.out.println("1 - Sim | 2 - Não");
                            System.out.print("Digite aqui: ");
                            int op = leiaNumInt();
                            if (op == 2) {
                                System.out.println("Tente outro CPF.");
                                proprietario = null;
                            }
                        }
                    } while (proprietario == null);
                    pCarro = false;
                    Carro c = new Carro(placa, marca, modelo, anoFab, anoMod, cor, tpCambio, combustivel, proprietario);
                    cadCarro.addCarro(c);
                    System.out.println("Carro cadastrado com sucesso!");
                }else{
                    System.out.println("Placa já cadastrada!");
                    pCarro = false;
                }
            }else{
                System.out.println("Placa inválida! Tente novamente");
                pCarro = true;
            }
        } while (pCarro);
    }

    private static void editarPessoa() {
        System.out.println("Editar Pessoa");
        boolean isCPF;
        do{
           System.out.println("Informe o CPF da pessoa a ser editado: ");
           String cpf = leia.nextLine();
           isCPF = Validadores.isCPF(cpf);
           if(isCPF){
               Pessoa p = cadPessoa.getPessoaCPF(cpf);
               if (p != null){
                   do{
                   System.out.println("Quais dados de " + p.getNome() + " deseja alterar?");
                   System.out.println("1 - Nome");
                   System.out.println("2 - Endereço");
                   System.out.println("3 - Telefone");
                   System.out.println("4 - Todos");
                   System.out.println("0 - Voltar");
                   System.out.println("Digite aqui: ");
                   int op = leiaNumInt();
                   if (op == 1 || op == 4){
                       System.out.println("Informe o nome: ");
                       p.setNome(leia.nextLine());
                   }
                   if (op == 2 || op == 4){
                       System.out.println("Informe o endereço: ");
                       p.setEndereco(leia.nextLine());
                   }
                   if (op == 3 || op == 4){
                       System.out.println("Informe o telefone: ");
                       p.setTelefone(leia.nextLine());
                   }
                   if (op == 0) {
                       System.out.println("Operação cancelada pelo usuário!");
                       isCPF = false;
                   }
                       if (op < 0 || op > 4) {
                           System.out.println("Operação inválidade, tente novamente!");
                           isCPF = true;
                       }
                   }while(isCPF);
               }else{
                   System.out.println("CPF não cadastrado!");
                       isCPF = false;
               }
           }else{
               System.out.println("CPF inválido!");
               System.out.println("Deseja tentar novamente? \n 1 - Sim | 2 - Não: ");
               int op = leiaNumInt();
               if(op ==1){
                   isCPF = true;
               }else{
                   isCPF = false;
               }
           }
        }while(isCPF);
    }

    private static void editarCarro() {
        System.out.println("Editar Carro");
        boolean isPlaca;
        do {            
            System.out.println("Informe a Placa: ");
            String placa = leia.nextLine();
            placa= placa.toUpperCase();
            isPlaca = Validadores.validarPlaca(placa);
            if (isPlaca) {
                Carro c;
                c = cadCarro.getCarroPlaca(placa);
                if (c != null) {
                    System.out.println(c.toString());
                    System.out.println("O que deseja alterar?");
                    System.out.println("1 - Cor");
                    System.out.println("2 - Tipo de câmbio");
                    System.out.println("3 - Tipo de combustível");
                    System.out.println("4 - Proprietário");
                    System.out.println("5 - Todos");
                    System.out.println("0 - Cancelar");
                    System.out.println("Digite sua escolha aqui: ");
                    int op = leiaNumInt();
                    if (op ==1 | op == 5) {
                        System.out.println("Informe a nova cor: ");
                        c.setCor(leia.nextLine().toUpperCase());
                    }
                    if (op ==2 | op == 5) {
                        System.out.println("Informe o novo câmbio: ");
                        c.setTpCambio(leia.nextLine().toUpperCase());
                    }
                    if (op ==3 | op == 5) {
                        System.out.println("Informe o novo combustível: ");
                        c.setCombustivel(leia.nextLine().toUpperCase());
                    }
                    if (op ==4 | op == 5) {
                        boolean isCPF;
                        do {                            
                            System.out.println("Informe o novo proprietário: ");
                            String cpf = leia.nextLine();
                            isCPF = Validadores.isCPF(cpf);
                            if (isCPF) {
                                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                                if (p != null) {
                                    System.out.println("Pessoa selecionada " + p.getNome());
                                    System.out.println("Está correto?");
                                    System.out.println("1 - Sim | 2 - Não");
                                    System.out.println("Digite aqui: ");
                                    op = leiaNumInt();
                                    if (op == 1) {
                                        isPlaca = false;
                                        c.setProprietario(p);
                                    }
                                }else{
                                    System.out.println("CPF não encontrado!");
                                    System.out.println("1 - Cadastrar?");
                                    System.out.println("2 - Tente novamente");
                                    System.out.println("Digite aqui sua opção:");
                                    int op2 = leiaNumInt();
                                    if (op2 == 1) {
                                        cadastrarPessoa();
                                    }
                                }
                            }
                        } while (isCPF);
                    }
                    if (op == 0) {
                        System.out.println("Edição do carrp cancelada pelo usuário!");
                        isPlaca = false;
                    }
                    if (op < 0 || op > 5) {
                        System.out.println("Opção inválida!");
                    }
                    isPlaca = false;
                }else{
                    System.out.println("Placa não cadastrada!");
                    isPlaca = true;
                }
            }else{
                System.out.println("Placa informada inválida!");
                System.out.println("Deseja tentar novamente?");
                System.out.println("1 - Sim | 2 - Não: ");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 1) {
                    isPlaca = true;
                }
            }
        } while (isPlaca);
    }

    private static void listarPessoa() {
        System.out.println("Listar Pessoas");
        for (Pessoa pessoa : cadPessoa.getPessoas()) {
            System.out.println(pessoa.toString());
        }
    }

    private static void listarCarro() {
        System.out.println("Listar Carro");
        for (Carro carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());
        }
    }

    private static void deletarPessoa() {
        System.out.println("Deletar Pessoa");
        boolean delCPF = false;
        do{
          System.out.println("Informe o CPF da pessoa a ser deletada: ");
          String cpf = leia.nextLine();
          delCPF=Validadores.isCPF(cpf);
          if (delCPF) {
              Pessoa p = cadPessoa.getPessoaCPF(cpf);
              if (p != null) {
                  System.out.println("Deseja realmente deletar " + p.getNome() + "?");
                  System.out.println("1 - Sim | 2 - Não");
                  int op = leiaNumInt();
                  if (op ==1) {
                      cadPessoa.removePessoa(p);
                      System.out.println("Pessoa deletada com sucesso!");
                      delCPF = false;
                  }else{
                      System.out.println("Operação cancelada pelo usuário!");
                      delCPF = false;
                  }
              }else{
                  System.out.println("CPF não cadastrado!");
                  System.out.println("Deseja tentar novamente?");
                  System.out.print("1 - Sim | 2 - Não");
                  int op = leiaNumInt();
                  if (op ==1){
                      delCPF = true;
                  }else{
                      delCPF = false;
                  }
              }
           }else {
              System.out.println("CPF inválido!"
                    + "\nTente novamente.");
              delCPF = true;
          }
        }while(delCPF);
    }

    private static void deletarCarro() {
        System.out.println("Deletar Carro");
        boolean delPlaca = false;
        do{
          System.out.println("Informe a placa do carro a ser deletada: ");
          String placa = leia.nextLine();
          placa = placa.toUpperCase();
          delPlaca=Validadores.validarPlaca(placa);
          if (delPlaca) {
              Carro c = cadCarro.getCarroPlaca(placa);
              if (c != null) {
                  System.out.println("Deseja realmente deletar " + c.getPlaca() + "?");
                  System.out.println("1 - Sim | 2 - Não");
                  int op = leiaNumInt();
                  if (op ==1) {
                      cadCarro.removeCarro(c);
                      System.out.println("Carro deletado com sucesso!");
                      delPlaca = false;
                  }else{
                      System.out.println("Operação cancelada pelo usuário!");
                      delPlaca = false;
                  }
              }else{
                  System.out.println("Placa não cadastrado!");
                  System.out.println("Deseja tentar novamente?");
                  System.out.print("1 - Sim | 2 - Não");
                  int op = leiaNumInt();
                  if (op ==1){
                      delPlaca = true;
                  }else{
                      delPlaca = false;
                  }
              }
           }else {
              System.out.println("Placa esta inválido!"
                    + "\nTente novamente.");
              delPlaca = false;
          }
        }while(delPlaca);
    }

}//fim classe
