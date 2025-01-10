/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe para rodar o codigo e receber os valores do usuario
 *
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
        System.out.println("05) Vendas ");
        System.out.println("06) Deletar valores");
        System.out.println("07) Alterar valores");
        System.out.println("08) Listagem");
        System.out.println("================================");

    }

    public static void tabelas() {
        System.out.println("-------------------");
        System.out.println("1 - Estabelecimentos");
        System.out.println("2 - Fornecedores");
        System.out.println("3 - Produtos");
        System.out.println("4 - Usuarios");
        System.out.println("5 - Vendas");
        System.out.println("-------------------");
    }

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        String nome, sexo, telefone, cpf, cidade, uf;
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

        int tabelaEsc, cidadeEsc, produtoEsc, fornecedorEsc, estabelecimentoEsc, usuarioEsc;

        menu();
        System.out.println("Deseja escolher qual opcao?");
        int escolha = scan.nextInt();
        scan.nextLine();

        while (escolha != 10) {
            switch (escolha) {
                case 1:
                    try {
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
                            if (idade <= 0) {
                                System.out.println("Idade invalida!");
                                break;
                            }
                            scan.nextLine();
                            System.out.println("Informe o nome da sua ciade: ");
                            cidade = scan.nextLine();
                            System.out.println("Informe o UF do seu estado");
                            uf = scan.nextLine().toUpperCase();;

                            Usuario usu = new Usuario(nome, sexo, telefone, cpf, idade, cidade, uf);
                            usu.inserir();

                            System.out.println("Deseja fazer outro cadastro? ");
                            opc = scan.nextLine().toLowerCase();
                        }

                    } catch (Exception e) {
                        System.out.println("Erro na inserção de dados!" + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("====================================");
                    System.out.println("            FORNECEDORES            ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer o cadastro de fornecedores?");
                    opc = scan.nextLine().toLowerCase();

                    while (opc.equals("sim") || opc.equals("s")) {
                        try {
                            System.out.println("Informe seu nome: ");
                            nome = scan.nextLine();
                            System.out.println("Informe o telefone: ");
                            telefone = scan.nextLine();
                            System.out.println("Informe o nome fantasia: ");
                            nome_fantasia = scan.nextLine();
                            System.out.println("Informe o CNPJ: ");
                            cnpj_forn = scan.nextLine();
                            System.out.println("Informe o nome da cidade: ");
                            cidade = scan.nextLine();
                            System.out.println("Informe o UF do estado");
                            uf = scan.nextLine().toUpperCase();;
                            Fornecedores fornecedores = new Fornecedores(nome, telefone, nome_fantasia, cnpj_forn, cidade, uf);
                            fornecedores.inserir();

                        } catch (Exception e) {
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

                    while (opc.equals("sim") || opc.equals("s")) {

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

                    while (opc.equals("sim") || opc.equals("s")) {

                        try {
                            System.out.println("Informe o nome fantasia do Estabelecimento");
                            nome_fantasia = scan.nextLine();
                            System.out.println("Informe o telefone do Estabelecimento");
                            telefone = scan.nextLine();
                            System.out.println("Informe o endereço eletronico do Estabelecimento (email)");
                            email = scan.nextLine();
                            System.out.println("Informe o CNPJ/CPF do estabelecimento");
                            cnpj = scan.nextLine();
                            System.out.println("Informe o nome da cidade: ");
                            cidade = scan.nextLine();
                            System.out.println("Informe o UF do estado: ");
                            uf = scan.nextLine().toUpperCase();

                            Estabelecimento estabelecimento = new Estabelecimento(nome_fantasia, telefone, email, cnpj, cidade, uf);

                            estabelecimento.inserir();

                        } catch (Exception e) {
                            System.out.println("Erro na inserção de dados");
                        }

                        scan.nextLine();
                        System.out.println("Deseja fazer o cadastro de outro estabelecimento?");
                        opc = scan.nextLine().toLowerCase();
                    }

                    break;
                case 5:
                    System.out.println("========================================");
                    System.out.println("                 COMPRAS                ");
                    System.out.println("========================================");
                    System.out.println("Seja bem vindo as compras!");
                    System.out.println("Deseja comprar algum produto? ");
                    String resposta = scan.nextLine().toLowerCase();

                    while (resposta.equals("sim") || resposta.equals("s")) {
                        Usuario usuv = new Usuario("vendas");
                        System.out.println("Informe seu ID: ");
                        int id_usu = scan.nextInt();
                        scan.nextLine();
                        usuv.conferirUsu(id_usu);
                        System.out.println("Confirma ser esse usuarios?");
                        String confirmar = scan.nextLine().toLowerCase();
                        if(confirmar.equals("sim") || confirmar.equals("s")){
                            
                            System.out.println("Qual o id do Produto?");
                            int id_prodt = scan.nextInt();


                            Produtos prodtv =  new Produtos("vendas");

                            System.out.println("Deseja fazer a compra de quantos itens?");
                            int qtdProd = scan.nextInt(); 
                            scan.nextLine();

                            System.out.println("Qual o dia que a venda foi realizada? EX (25/12/2020");
                            String dataVnd = scan.nextLine();

                            Vendas venda = new Vendas(qtdProd,dataVnd, id_usu, id_prodt); 

                            prodtv.alterarQtd(id_prodt, qtdProd); // alterando valor de quantidade do produto da tabela produtos

                            venda.inserir(); // adiciona uma nova linha com essas informações
                            System.out.println("Venda realizada com sucesso!");
                            
                        }else{
                            System.out.println("Id incorreto!");
                        }
                        
                        System.out.println("Deseja comprar outro produto?");
                        resposta = scan.nextLine().toLowerCase();
                       
                    }

                    break;

                case 6:
                    System.out.println("====================================");
                    System.out.println("              REMOCAO               ");
                    System.out.println("====================================");
                    System.out.println("Deseja remover valor de alguma tabela?");
                    opc = scan.nextLine().toLowerCase();

                    while (opc.equals("sim") || opc.equals("s")) {
                        System.out.println("========================");
                        System.out.println("1 - Usuario");
                        System.out.println("2 - Produtos");
                        System.out.println("3 - Estabelecimento");
                        System.out.println("4 - Fornecedores");
                        System.out.println("5 - Vendas");
                        System.out.println("========================");
                        System.out.println("Deseja fazer remoção de qual tabela");
                        opc_rem = scan.nextInt();
                        scan.nextLine();
                        switch (opc_rem) {
                            case 1:
                                Usuario usu = new Usuario("usuarios");
                                usu.listar();
                                System.out.println("Deseja fazer a exclusao de algum ID de usuario?");
                                opc = scan.nextLine().toLowerCase();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    try {
                                        System.out.println("Informe o ID que voce deseja remover: ");
                                        id_remocao = scan.nextInt();
                                        boolean valor = Usuario.verificarUsuario(id_remocao);
                                        if(valor == true){
                                           usu.remover(id_remocao);
                                        } else{
                                            System.out.println("Esse ID nao existe");
                                        }
                                        
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro ao remover o id de usuario" + e.getMessage() + e.getLocalizedMessage());
                                    }
                                }

                                // fazer listagem de todos os usuarios para encontrar o id desejado a excluir
                                // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "usu.remover(idSelecionado)"
                                break;
                            case 2:
                                Produtos pro = new Produtos("produtos");
                                pro.listar();
                                System.out.println("Deseja fazer a remocao de algum campo de produtos? ");
                                opc = scan.nextLine().toLowerCase();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    try {
                                        System.out.println("Informe o ID que deseja remover: ");
                                        id_remocao = scan.nextInt();
                                        boolean valor = Produtos.verificarProduto(id_remocao);
                                        if(valor == true){
                                            pro.remover(id_remocao);
                                        }else {
                                            System.out.println("Esse ID nao existe!");
                                        }
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro ao remover o ID de produtos " + e.getMessage() + e.getLocalizedMessage());
                                    }
                                }
                                // fazer listagem de todos os produtos para encontrar o id desejado a excluir
                                // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "produtos.remover(idSelecionado)"
                                break;
                            case 3:
                                Estabelecimento esta = new Estabelecimento("estabelecimento");
                                esta.listar();
                                System.out.println("Deseja fazer a remocao de algum ID?");
                                opc = scan.nextLine().toLowerCase();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    try {
                                        System.out.println("Informe o ID que voce deseja remover: ");
                                        id_remocao = scan.nextInt();
                                        boolean valor = Estabelecimento.verificarEstabelecimento(id_remocao);
                                        if(valor == true){
                                            esta.remover(id_remocao);
                                            
                                        }else {
                                            System.out.println("Nao existe esse ID!");
                                        }
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro ao remover Id de estabelecimento! " + e.getMessage() + e.getLocalizedMessage());
                                    }
                                }

                                // fazer listagem de todos os estabelecimentos para encontrar o id desejado a excluir
                                // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "estabelecimentos.remover(idSelecionado)"
                                break;
                            case 4:
                                Fornecedores forn = new Fornecedores("fornecedores");
                                forn.listar();
                                System.out.println("Deseja fazer a remocao de algum ID?");
                                opc = scan.nextLine();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    try {
                                        System.out.println("Informe o ID que voce deseja remover: ");
                                        id_remocao = scan.nextInt();
                                        boolean valor = Fornecedores.verificarFornecedor(id_remocao);
                                        if (valor == true){
                                        forn.remover(id_remocao);
                                            
                                        }else {
                                            System.out.println("Esse ID nao existe!");
                                        }
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Erro ao remover o ID de fornecedores! " + e.getMessage() + e.getLocalizedMessage());
                                    }
                                }
                                // fazer listagem de todos os fornecedores para encontrar o id desejado a excluir
                                // pedir o id selecionado e colocar ele como parametro no metodo remover() dessa maneira "fornecedores.remover(idSelecionado)"
                                break;
                            case 5:
                                Vendas vendas = new Vendas();
                                vendas.listar();
                                System.out.println("Deseja fazer a remocao de algum ID?");
                                opc = scan.nextLine().toLowerCase();
                                if (opc.equals("sim") || opc.equals("s")) {
                                    try {
                                        System.out.println("Qual ID? ");
                                        id_remocao = scan.nextInt();
                                        boolean valor = Vendas.verificarVendas(id_remocao);
                                        if(valor == true){
                                            vendas.remover(id_remocao);
                                           
                                        } else {
                                            System.out.println("Nao existe esse ID!");
                                        }
                                        
                                        scan.nextLine();

                                    } catch (Exception e) {
                                        System.out.println("Erro ao remover ID de vendas! " + e.getMessage() + e.getLocalizedMessage());
                                    }
                                }
                                break;
                            default:
                                System.out.println("Numero errado!");
                                break;
                        }

                        System.out.println("Deseja remover valor de outra tabela?");
                        opc = scan.nextLine().toLowerCase();
                    }

                    break;

                case 7:
                    System.out.println("====================================");
                    System.out.println("              ALTERAÇÃO             ");
                    System.out.println("====================================");
                    System.out.println("Deseja alterar o valor de alguma tabela?");
                    opc = scan.nextLine().toLowerCase();

                    while (opc.equals("sim") || opc.equals("s")) {

                        System.out.println("Digite o numero da tabela que você deseja alterar!");
                        tabelas();
                        tabelaEsc = scan.nextInt();
                        scan.nextLine();

                        switch (tabelaEsc) {
                            case 1:
                                Estabelecimento esta = new Estabelecimento("estabelecimento");
                                System.out.println("Listagem de estabelecimentos para localizar ID!");
                                Estabelecimento estabelecimentos = new Estabelecimento("estabelecimento");
                                estabelecimentos.listar();
                                try {
                                    try {
                                        System.out.println("Digite o ID do estabelecimento que você deseja alterar!");
                                        estabelecimentoEsc = scan.nextInt();
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Digite um valor valido!!");
                                        break;// parar a execução e perguntar denovo!
                                    }
                                    System.out.println("Informe o novo nome fantasia do Estabelecimento");
                                    nome_fantasia = scan.nextLine();
                                    System.out.println("Informe o novo telefone do Estabelecimento");
                                    telefone = scan.nextLine();
                                    System.out.println("Informe o novo endereço eletronico do Estabelecimento (email)");
                                    email = scan.nextLine();
                                    System.out.println("Informe o novo CNPJ/CPF do estabelecimento");
                                    cnpj = scan.nextLine();
                                    System.out.println("Informe o novo nome da cidade do estabelecimento: ");
                                    cidade = scan.nextLine();
                                    System.out.println("Informe o UF dessa cidade: ");
                                    uf = scan.nextLine().toUpperCase();
                                    Estabelecimento est = new Estabelecimento(nome_fantasia,telefone, email,cnpj,cidade,uf);
                                    est.alterar(estabelecimentoEsc);
                                    System.out.println("Estabelecimento alterado com sucesso!!");

                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar o estabelecimento! " + e.getMessage() + e.getLocalizedMessage());
                                }

                                break;
                            case 2:
                                System.out.println("Listagem dos Fornecedores para localizar o ID!");
                                Fornecedores fornecedor = new Fornecedores("fornecedor");
                                fornecedor.listar();

                                try {
                                    try {
                                        System.out.println("Digite o id a ser alterado!");
                                        fornecedorEsc = scan.nextInt();
                                        scan.nextLine();

                                    } catch (Exception e) {
                                        System.out.println("Digite um valor valido!");
                                        break;// parar a execução e perguntar denovo!
                                    }
                                    System.out.println("Informe seu nome: ");
                                    nome = scan.nextLine();
                                    System.out.println("Informe o telefone: ");
                                    telefone = scan.nextLine();
                                    System.out.println("Informe o nome fantasia: ");
                                    nome_fantasia = scan.nextLine();
                                    System.out.println("Informe o CNPJ: ");
                                    cnpj_forn = scan.nextLine();
                                    System.out.println("Informe o novo nome da cidade do Fornecedor: ");
                                    cidade = scan.nextLine();
                                    System.out.println("Informe o UF do estado dessa cidade: ");
                                    uf = scan.nextLine().toUpperCase();
                                    Fornecedores forn = new Fornecedores(nome, telefone, nome_fantasia, cnpj_forn, cidade, uf);
                                    forn.alterar(fornecedorEsc);

                                    System.out.println("Sucesso ao alterar os dados do Fornecedor!");

                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar o Fornecedor! " + e.getMessage() + e.getLocalizedMessage());
                                }
                                break;
                            case 3:
                                System.out.println("Listagem dos Produtos para localizar o ID!");
                                Produtos produtos = new Produtos("Produtos");
                                produtos.listar();
                                try {
                                    try {
                                        System.out.println("Digite o id a ser alterado!");
                                        produtoEsc = scan.nextInt();
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Digite um valor valido!");
                                        break;// parar a execução e perguntar denovo!
                                    }
                                    System.out.println("Informe o nome do produto");
                                    nome = scan.nextLine();
                                    System.out.println("Informe a Marca do produto");
                                    marca = scan.nextLine();
                                    System.out.println("Informe a Quantidade desse produto no estoque");
                                    qtd = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("Informe o preço deste produto");
                                    preco = scan.nextFloat();

                                    Produtos prodt = new Produtos(nome, preco, marca, qtd);

                                    prodt.alterar(produtoEsc);

                                    System.out.println("Produto alterado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar o Produto! " + e.getMessage() + e.getLocalizedMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Listagem dos Usuarios para localizar o ID!");
                                Usuario usuario = new Usuario("usuario");
                                usuario.listar();
                                try {
                                    try {
                                        System.out.println("Digite o id a ser alterado!");
                                        usuarioEsc = scan.nextInt();
                                        scan.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Digite um valor valido!");
                                        break;// parar a execução e perguntar denovo!
                                    }
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
                                    scan.nextLine();
                                    if (idade <= 0 || idade >= 110) {
                                        System.out.println("Idade invalida!");
                                        break;
                                    }
                                    System.out.println("Informe a nova cidade do usuario: ");
                                    cidade = scan.nextLine();
                                    System.out.println("Informe o UF do estado: ");
                                    uf = scan.nextLine().toUpperCase();
                                    Usuario usu = new Usuario(nome, sexo, telefone, cpf, idade, cidade, uf);
                                    usu.alterar(usuarioEsc);

                                    System.out.println("Usuario alterado com sucesso!");

                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar o usuario! " + e.getMessage() + e.getLocalizedMessage());
                                }
                                break;

                            default:
                                System.out.println("Valor incorreto!");
                                break;
                        }
                        scan.nextLine();
                        System.out.println("Deseja alterar outro campo de alguma tabela?");
                        opc = scan.nextLine().toLowerCase();
                    }

                    break;

                case 8:
                    System.out.println("====================================");
                    System.out.println("              LISTAGEM              ");
                    System.out.println("====================================");
                    System.out.println("Deseja fazer uma listagem?");

                    opc = scan.nextLine().toLowerCase();

                    while (opc.equals("sim") || opc.equals("s")) {
                        System.out.println("Deseja fazer a listagem de qual tabela?");
                        tabelas();

                        tabelaEsc = scan.nextInt();
                        scan.nextLine();
                        switch (tabelaEsc) {
                            case 1:
                                Estabelecimento estabelecimentos = new Estabelecimento("estabelecimento");
                                estabelecimentos.listar();
                                break;
                            case 2:
                                Fornecedores fornecedor = new Fornecedores("fornecedor");
                                fornecedor.listar();
                                break;
                            case 3:
                                Produtos produtos = new Produtos("Produtos");
                                produtos.listar();
                                break;
                            case 4:
                                Usuario usu = new Usuario("usuario");
                                usu.listar();
                                break;
                            case 5:
                                Vendas vendas = new Vendas();
                                vendas.listar();
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
            menu();
            System.out.println("Deseja escolher qual opcao?");
            escolha = scan.nextInt();
            scan.nextLine();
        }

    }

}
