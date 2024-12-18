/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe para rodar o codigo e receber os valores do usuario
 * @author felipe ferreira, Carlos Eduardo, Caua Alavarenga e Heitor Messias
 * @since 15/12/2024 at 16:21
 */

public class App {
    
        public static void menu() {
            System.out.println("================================");
            System.out.println("              MENU              ");
            System.out.println("================================");
            System.out.println("01) Inserir dados a Usuarios ");
            System.out.println("02) Inserir dados a Fornecedores");
            System.out.println("03) Inserir dados a Produtos");
            System.out.println("04) Inserir dados a Estabelecimento");
            System.out.println("05) Inserir dados a Endereco");
            System.out.println("06) Inserir dados a Cidade");
            System.out.println("07) Deletar valores");
            System.out.println("08) Alterar valores");
            System.out.println("09) Listagem");
            System.out.println("================================");
                   
    }
    public static void main(String[] args) {
        
       Scanner scan = new Scanner(System.in);
       
       
       String nome, sexo, telefone, cpf;
       int idade;
       //variaveis para usuarios
       int id_Usu, id_Prod, id_For, id_Esta, id_End, id, id_cid;
       String opc;
       int opc_rem;
        System.out.println("Deseja escolher qual opcao?");
        int escolha = scan.nextInt();
        scan.nextLine();
        
        while(escolha != 10){
            switch(escolha){
                case 1:
                    try{
                        System.out.println("====================================");
                        System.out.println("              USUARIO               ");
                        System.out.println("====================================");
                        System.out.println("Deseja fazer o cadastro do usuario?");
                        opc = scan.nextLine().toLowerCase();
                        
                        while (opc.equals("sim") || opc.equals("s")) {
                            System.out.println("Informe o seu nome: ");
                            nome = scan.nextLine();
                            System.out.println("Informe seu sexo: ");
                            sexo = scan.nextLine();
                            System.out.println("Informe seu telefone: ");
                            telefone = scan.nextLine();
                            System.out.println("Informe seu cpf:");
                            cpf = scan.nextLine();
                            System.out.println("Informe sua idade:");
                            idade = scan.nextInt();
                            if (idade <= 0){
                                System.out.println("Idade invalida!");
                                break;
                            }
                            Usuario usu = new Usuario(nome, sexo, telefone, cpf, idade);
                            usu.inserir();
                            
                            System.out.println("Deseja fazer outro cadastro? ");
                            opc = scan.nextLine().toLowerCase();
                        }

                    } catch (Exception e){
                        System.out.println("Erro na inserção de dados!");
                    }
                    break;
                case 7:
                       System.out.println("====================================");
                       System.out.println("              REMOCAO               ");
                       System.out.println("====================================");
                       System.out.println("Deseja remover valor de alguma tabela?");
                       opc = scan.nextLine().toLowerCase();
                       
                       while(opc.equals("sim")|| opc.equals('s')){
                           System.out.println("========================");
                           System.out.println("1 - Usuario");
                           System.out.println("2 - Cidade");
                           System.out.println("3 - Produtos");
                           System.out.println("4 - Estabelecimento");
                           System.out.println("5 - Fornecedores");
                           System.out.println("6 - Endereco");
                           System.out.println("========================");
                           System.out.println("Deseja fazer remoção de qual tabela");
                           opc_rem = scan.nextInt();
                           switch(opc_rem){
                               case 1:
                                   
                                   
                                   

                           }
                           
                       }
                       
                       
                    break;
                    
                default:
                    break;
                   
            }
                
        }       
       
       
        
    }
    
}
