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
        
        public static void tabelas(){
            System.out.println("-------------------");
            System.out.println("1 - Cidades");
            System.out.println("2 - Estabelecimentos");
            System.out.println("3 - Fornecedores");
            System.out.println("4 - Produtos");
            System.out.println("5 - Usuarios");
            System.out.println("6 - Vendas");
            System.out.println("-------------------");
        }
        
    public static void main(String[] args) {
        
       Scanner scan = new Scanner(System.in);
       
       
       String nome, sexo, telefone, cpf;
       int idade;
       //variaveis para usuarios
       
       int qtd;
       float preco;
       String marca;
       // variaveis para produtos
       
       String email, cnpj;
       // variaveis para estabelecimentos
       
       String nome_fantasia, cnpj_forn;
       String opc;
       int opc_rem, id_remocao;
       
       
        menu();
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
                case 2:
                    System.out.println("====================================");
                    System.out.println("            FORNECEDORES            ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer o cadastro de fornecedores?");
                    opc = scan.nextLine().toLowerCase();
                    
                    while(opc.equals("sim") || opc.equals("s")){
                        try{
                            System.out.println("Informe seu nome: ");
                            nome = scan.nextLine();
                            System.out.println("Informe o telefone: ");
                            telefone = scan.nextLine();
                            System.out.println("Informe o nome fantasia: ");
                            nome_fantasia = scan.nextLine();
                            System.out.println("Informe o CNPJ: ");
                            cnpj_forn = scan.nextLine();
                            Fornecedores fornecedores = new Fornecedores(nome,telefone,nome_fantasia,cnpj_forn);
                            fornecedores.inserir();
                            
                        } catch(Exception e){
                            System.out.println("Erro na insercao de dados! ");
                        }
                        scan.nextLine();
                        System.out.println("Deseja fazer outro cadastro para fornecedores?");
                        opc = scan.nextLine().toLowerCase();
                        
                    }
                    break;
                case 3:
                    System.out.println("====================================");
                    System.out.println("              PRODUTOS              ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer o cadastro de Produtos?");
                    opc = scan.nextLine().toLowerCase();
                    
                    while(opc.equals("sim") || opc.equals("s")){
                        
                        try {   
                            System.out.println("Informe o nome do produto");
                            nome = scan.nextLine();
                            System.out.println("Informe a Marca do produto");
                            marca = scan.nextLine();
                            System.out.println("Informe a Quantidade desse produto no estoque");
                            qtd = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Informe o preço deste produto");
                            preco = scan.nextFloat();
                            
                            Produtos produto = new Produtos(nome, preco, marca, qtd);
                            
                            produto.inserir();
                        
                        } catch (Exception e) {
                            System.out.println("Erro na inserção de dados!");  
                        }
                        scan.nextLine();  
                        System.out.println("Deseja cadastrar outro produto?");
                        opc = scan.nextLine().toLowerCase();
                    }
                    
                    
                    break;
                case 4:
                    System.out.println("====================================");
                    System.out.println("          ESTABELECIMENTOS          ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer o cadastro de algum estabelecimento?");
                    opc = scan.nextLine().toLowerCase();
                    
                    while(opc.equals("sim") || opc.equals("s")){
                        
                        try {
                            System.out.println("Informe o nome fantasia do Estabelecimento");
                            nome_fantasia = scan.nextLine();
                            System.out.println("Informe o telefone do Estabelecimento");
                            telefone = scan.nextLine();
                            System.out.println("Informe o endereço eletronico do Estabelecimento (email)");
                            email =  scan.nextLine();
                            System.out.println("Informe o CNPJ/CPF do estabelecimento");
                            cnpj = scan.nextLine();
                            
                            Estabelecimento estabelecimento = new Estabelecimento(nome_fantasia, telefone, email, cnpj);
                            
                            estabelecimento.inserir();
                            
                            
                        } catch (Exception e) {
                            System.out.println("Erro na inserção de dados");
                        }

                        scan.nextLine();
                        System.out.println("Deseja fazer o cadastro de outro estabelecimento?");
                        opc = scan.nextLine().toLowerCase();
                    }
                    
                    
                    break;
                    
                case 7:
                       System.out.println("====================================");
                       System.out.println("              REMOCAO               ");
                       System.out.println("====================================");
                       System.out.println("Deseja remover valor de alguma tabela?");
                       opc = scan.nextLine().toLowerCase();
                       
                       while(opc.equals("sim")|| opc.equals("s")){
                           System.out.println("========================");
                           System.out.println("1 - Usuario");
                           System.out.println("2 - Cidade");
                           System.out.println("3 - Produtos");
                           System.out.println("4 - Estabelecimento");
                           System.out.println("5 - Fornecedores");
                           System.out.println("========================");
                           System.out.println("Deseja fazer remoção de qual tabela");
                           opc_rem = scan.nextInt();
                           switch(opc_rem){
                               case 1:
                                     Usuario usu = new Usuario("usuarios");
                                     usu.listar();
                                     System.out.println("Deseja fazer a exclusao de algum ID de usuario?");
                                     opc = scan.nextLine().toLowerCase();
                                     if (opc.equals("sim") || opc.equals("s")){
                                        try{
                                             System.out.println("Informe o ID que voce deseja remover: ");
                                             id_remocao = scan.nextInt();
                                             usu.remover(id_remocao);
                                        } catch(Exception e){
                                            System.out.println("Erro ao remover o id de usuario" + e.getMessage() + e.getLocalizedMessage());
                                        }  
                                     }
                                         
                                   // fazer listagem de todos os usuarios para encontrar o id desejado a excluir
                                   // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "usu.remover(idSelecionado)"
                                   break;
                               case 2:
                                   Cidade cid = new Cidade("cidade");
                                   cid.listar();
                                   System.out.println("Deseja fazer a remocao de algum campo de ciade?");
                                   opc = scan.nextLine().toLowerCase();
                                   if (opc.equals("sim")|| opc.equals("s")){
                                       try{
                                           System.out.println("Informe o ID que deseja remover: ");
                                           id_remocao = scan.nextInt();
                                           cid.remover(id_remocao);
                                        }  catch (Exception e){
                                            System.out.println("Erro ao remover o id de cidade " + e.getMessage() + e.getLocalizedMessage());
                                        } 
                                   }
                                   // fazer listagem de todos as cidades para encontrar o id desejado a excluir
                                   // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "cidades.remover(idSelecionado)"
                                   break;
                               case 3:
                                   Produtos prod = new Produtos("produtos");
                                   prod.listar();
                                   System.out.println("Deseja fazer a remocao de algum campo de produtos? ");
                                   opc = scan.nextLine().toLowerCase();
                                   if (opc.equals("sim") || opc.equals("s")){
                                       try {
                                           System.out.println("Informe o ID que deseja remover: ");
                                           id_remocao = scan.nextInt();
                                           prod.remover(id_remocao);
                                           
                                       } catch(Exception e){
                                           System.out.println("Erro ao remover o ID de produtos " + e.getMessage() + e.getLocalizedMessage());
                                       }
                                   }
                                   // fazer listagem de todos os produtos para encontrar o id desejado a excluir
                                   // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "produtos.remover(idSelecionado)"
                                   break;
                               case 4:
                                   Estabelecimento esta = new Estabelecimento("estabelecimento");
                                   esta.listar();
                                   System.out.println("Deseja fazer a remocao de algum ID?");
                                   opc = scan.nextLine().toLowerCase();
                                   if (opc.equals("sim")|| opc.equals("s")){
                                       try {
                                           System.out.println("Informe o ID que voce deseja remover: ");
                                           id_remocao = scan.nextInt();
                                           esta.remover(id_remocao);
                                       } catch (Exception e) {
                                           System.out.println("Erro ao remover Id de estabelecimento! " +e.getMessage() + e.getLocalizedMessage());
                                       }
                                   }
                                   
                                   // fazer listagem de todos os estabelecimentos para encontrar o id desejado a excluir
                                   // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "estabelecimentos.remover(idSelecionado)"
                                   break;
                               case 5:
                                   Fornecedores forn = new Fornecedores("fornecedores");
                                   forn.listar();
                                   System.out.println("Deseja fazer a remocao de algum ID?");
                                   opc = scan.nextLine();
                                   if (opc.equals("sim")|| opc.equals("s")){
                                       try {
                                           System.out.println("Informe o ID que voce deseja remover: ");
                                           id_remocao = scan.nextInt();
                                           forn.remover(id_remocao);
                                       } catch (Exception e) {
                                           System.out.println("Erro ao remover o ID de fornecedores! " +e.getMessage() + e.getLocalizedMessage());
                                       }
                                   }
                                   // fazer listagem de todos os fornecedores para encontrar o id desejado a excluir
                                   // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "fornecedores.remover(idSelecionado)"
                                   break;
                               default:   
                                   System.out.println("Numero errado!");
                                   break;
                           }
                           
                           System.out.println("Deseja remover valor de outra tabela?");
                           opc = scan.nextLine().toLowerCase();
                       }
                       
                       
                    break;
                    
                case 9:
                    System.out.println("====================================");
                    System.out.println("              LISTAGEM              ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer uma listagem?");
                    
                    opc = scan.nextLine().toLowerCase();
                    
                    while(opc.equals("sim") || opc.equals("s")){
                        System.out.println("Deseja fazer a listagem de qual tabela?");
                        tabelas();
                        
                        int tabelaEsc = scan.nextInt();
                        switch(tabelaEsc){
                            case 1:
                                Cidade cidades = new Cidade("cidade");
                                cidades.listar();
                                break;
                            case 2:
                                Estabelecimento estabelecimentos = new Estabelecimento("estabelecimento");
                                estabelecimentos.listar();
                                break;
                            case 3:
                                Fornecedores fornecedor = new Fornecedores("fornecedor");
                                fornecedor.listar();
                                break;
                            case 4:
                                Produtos produtos = new Produtos("Produtos");
                                produtos.listar();
                                break;
                            case 5:
                                Usuario usu = new Usuario("usuario");
                                usu.listar();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Numero de tabela errado");
                                break;
                                
                        }
                        scan.nextLine();
                        System.out.println("Deseja fazer outra listagem?");
                        opc = scan.nextLine().toLowerCase();
                        
                    }
                    
                    
                    
                    
                    
                    
                    break;
                    
                default:
                    break;
                   
            }
                
        }       
       
       
        
    }
    
}
