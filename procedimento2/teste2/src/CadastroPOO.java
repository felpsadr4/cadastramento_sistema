import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CadastroPOO {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        String arquivoDeDadosPessoaFisica = "pessooa_fisica.bin";
        String arquivoDeDadosPessoaJuridica = "pessooa_Juridica.bin";
        while (opcao != 0) {
            System.out.println("╔═════════════════════════════════╗");
            System.out.println("║RPG014 - Sistema de Cadastramento║");
            System.out.println("╠═════════════════════════════════╣");
            System.out.println("╟ (\u001B[1m1\u001B[0m) - Incluir Pessoa            ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m2\u001B[0m) - Alterar Pessoa            ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m3\u001B[0m) - Excluir Pessoa            ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m4\u001B[0m) - Buscar pelo Id            ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m5\u001B[0m) - Exibir Todos              ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m6\u001B[0m) - Persistir Dados           ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m7\u001B[0m) - Recuperar Dados           ╢");
            System.out.println("╠══                             ══╣");
            System.out.println("╟ (\u001B[1m0\u001B[0m) - Finalizar Programa        ╢");
            System.out.println("╚═════════════════════════════════╝");

            opcao = scanner.nextInt();
            String tipoPessoa;
            switch (opcao) {
                case 1:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (1)        Incluir        ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Digite o ID da Pessoa Fisica   ╢");
                        int idPessoaF = scanner.nextInt();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Digite o NOME da Pessoa Fisica  ╢");
                        scanner.nextLine();
                        String nomePessoaF = scanner.nextLine();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Digite o CPF da Pessoa Fisica  ╢");
                        String cpfPessoaF = scanner.next();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Digite a IDADE da Pessoa Fisica ╢");
                        int idadePessoaF = scanner.nextInt();
                        PessoaFisica cadastroCompleto = new PessoaFisica(idPessoaF, nomePessoaF, cpfPessoaF, idadePessoaF);
                        repo1.inserir(cadastroCompleto);
                        System.out.println("╟        CADASTRO COMPLETO        ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Digite o ID da Pessoa Juridica  ╢");
                        int idPessoaJ = scanner.nextInt();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Digite o NOME da Pessoa Juridica╢");
                        scanner.nextLine();
                        String nomePessoaJ = scanner.nextLine();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Digite o CNPJ da Pessoa Juridica╢");
                        String cnpjPessoaJ = scanner.next();
                        PessoaJuridica cadastroCompleto = new PessoaJuridica(idPessoaJ, nomePessoaJ, cnpjPessoaJ);
                        repo3.inserir(cadastroCompleto);
                        System.out.println("╟        CADASTRO COMPLETO        ╢");
                        System.out.println("╚═════════════════════════════════╝");

                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                case 2:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (2)     Alterar           ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟   Digite o ID da Pessoa Fisica  ╢");
                        int idPessoaF = scanner.nextInt();
                        repo1.obter(idPessoaF);
                        System.out.println("╟          DADOS ATUAIS           ╢");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("║                                 ║");
                        System.out.println("║                                 ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("║         ALTERAR DADOS           ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Altere o NOME da Pessoa Fisica  ╢");
                        scanner.nextLine();
                        String nomePessoaF = scanner.nextLine();

                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Altere o CPF da Pessoa Fisica  ╢");
                        String cpfPessoaF = scanner.next();
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Altere a IDADE da Pessoa Fisica ╢");
                        int idadePessoaF = scanner.nextInt();
                        PessoaFisica cadastroCompleto = new PessoaFisica(idPessoaF, nomePessoaF, cpfPessoaF, idadePessoaF);
                        repo1.alterar(idPessoaF, cadastroCompleto);
                        System.out.println("╟        CADASTRO ALTERADO        ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Digite o ID da Pessoa Juridica ╢");
                        int idPessoaJ = scanner.nextInt();
                        repo3.obter(idPessoaJ);
                        System.out.println("╟          DADOS ATUAIS           ╢");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("║                                 ║");
                        System.out.println("║                                 ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("║         ALTERAR DADOS           ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Altere o NOME da Pessoa Juridica╢");
                        scanner.nextLine();
                        String nomePessoaJ = scanner.nextLine();

                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟ Altere o CNPJ da Pessoa Juridica╢");
                        String cnpjPessoaJ = scanner.next();
                        PessoaJuridica cadastroCompleto = new PessoaJuridica(idPessoaJ, nomePessoaJ, cnpjPessoaJ);
                        repo3.alterar(idPessoaJ, cadastroCompleto);
                        System.out.println("╟        CADASTRO ALTERADO        ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                case 3:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (3)     Excluir           ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟   Digite o ID da Pessoa Fisica  ╢");
                        int idPessoaF = scanner.nextInt();
                        repo1.excluir(idPessoaF);
                        System.out.println("╟        EXCLUSÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Digite o ID da Pessoa Juridica ╢");
                        int idPessoaJ = scanner.nextInt();
                        repo3.excluir(idPessoaJ);
                        System.out.println("╟        EXCLUSÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                case 4:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (4)     Exibir Por ID     ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟   Digite o ID da Pessoa Fisica  ╢");
                        int idPessoaF = scanner.nextInt();
                        repo1.obter(idPessoaF);
                        System.out.println("╟        EXIBIÇÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╟  Digite o ID da Pessoa Juridica ╢");
                        int idPessoaJ = scanner.nextInt();
                        repo3.obter(idPessoaJ);
                        System.out.println("╟        EXIBIÇÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;

                case 5:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (5)      Exibir Todos     ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╠═══  LISTA DE PESSOAS FISICAS ═══╣");
                        repo1.obterTodos();
                        System.out.println("╟        EXIBIÇÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╠════LISTA DE PESSOAS JURIDICAS═══╣");
                        repo3.obterTodos();
                        System.out.println("╟        EXIBIÇÃO COMPLETA        ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                case 6:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (6)        Persistir      ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        repo1.persistir(arquivoDeDadosPessoaFisica);
                        System.out.println("╟       SALVEMENTO COMPLETO       ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        repo3.persistir(arquivoDeDadosPessoaJuridica);
                        System.out.println("╟       SALVEMENTO COMPLETO       ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }
                    break;
                case 7:
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Opção (7)      Recuperar        ║");
                    System.out.println("╠═════════════════════════════════╣");
                    System.out.println("╟ (\u001B[1mF\u001B[0m) - Pessoa Fisica             ╢");
                    System.out.println("╠══                             ══╣");
                    System.out.println("╟ (\u001B[1mJ\u001B[0m) - Pessoa Juridica           ╢");
                    System.out.println("╚═════════════════════════════════╝");
                    tipoPessoa = scanner.next().toUpperCase();
                    if (tipoPessoa.equals("F")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (F) selecionada: Fisico   ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╠═══  LISTA DE PESSOAS FISICAS ═══╣");
                        repo1.recuperar(arquivoDeDadosPessoaFisica);
                        System.out.println("╟      RECUPERAÇÃO COMPLETA       ╢");
                        System.out.println("╚═════════════════════════════════╝");


                    } else if (tipoPessoa.equals("J")) {
                        System.out.println("╔═════════════════════════════════╗");
                        System.out.println("║ Opção (J) selecionada: Juridico ║");
                        System.out.println("╠═════════════════════════════════╣");
                        System.out.println("╠════LISTA DE PESSOAS JURIDICAS═══╣");
                        repo3.recuperar(arquivoDeDadosPessoaJuridica);
                        System.out.println("╟      RECUPERAÇÃO COMPLETA       ╢");
                        System.out.println("╚═════════════════════════════════╝");
                    } else {
                        System.out.println("Opção Inválida");
                    }

                    break;
            }

        }

    }
}
