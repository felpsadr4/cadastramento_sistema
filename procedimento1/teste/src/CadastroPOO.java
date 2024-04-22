import java.util.ArrayList;


public class CadastroPOO {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        PessoaFisica pessoaf1 = new PessoaFisica(1, "Joãozin", "111-222-333-45", 14);
        PessoaFisica pessoaf2 = new PessoaFisica(2, "Cleberzin", "222-333-444-56", 15);
        PessoaJuridica pessoaj1 = new PessoaJuridica(3, "Casa dos doces", "132-456-546-4");
        PessoaJuridica pessoaj2 = new PessoaJuridica(4, "Casa dos salgados", "665-498-546-5");
        repo1.inserir(pessoaf1);
        repo1.inserir(pessoaf2);
        repo3.inserir(pessoaj1);
        repo3.inserir(pessoaj2);


        repo1.persistir("pessoa_fisica.txt");
        repo2.recuperar("pessoa_fisica.txt");
        ArrayList<PessoaFisica> listaPessoaFisica = repo2.obterTodos();
        listaPessoaFisica.forEach(PessoaFisica::exibir);

        repo3.persistir("pessoa_juridica.txt");
        repo4.recuperar("pessoa_juridica.txt");
        ArrayList<PessoaJuridica> listaPessoaJuridica = repo4.obterTodos();
        listaPessoaJuridica.forEach(PessoaJuridica::exibir);

    }
}