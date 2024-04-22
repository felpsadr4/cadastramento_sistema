import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> listaPessoaJuridica;

    public PessoaJuridicaRepo(List<PessoaJuridica> listaPessoaJuridica) {

        this.listaPessoaJuridica = listaPessoaJuridica;
    }

    public PessoaJuridicaRepo() {

        this.listaPessoaJuridica = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {

        listaPessoaJuridica.add(pessoa);

    }

    public void alterar(int id, PessoaJuridica pessoaJuridicaAlterada) {
        for (int i = 0; i < this.listaPessoaJuridica.size(); i++) {
            PessoaJuridica pessoaJuridica = this.listaPessoaJuridica.get(i);
            if (pessoaJuridica.getId() == id) {
                pessoaJuridica.setNome(pessoaJuridicaAlterada.getNome());
                pessoaJuridica.setCnpj(pessoaJuridicaAlterada.getCnpj());
            }
        }
    }

    public void excluir(int id) {
        for (PessoaJuridica pessoa : listaPessoaJuridica) {
            if (pessoa.getId() == id) {
                listaPessoaJuridica.remove(pessoa);
                return;
            }
        }
        System.out.println("Pessoa com o ID " + id + " não encontrada para excluir");
    }

    public PessoaJuridica obter(int id) {
        boolean encontrado = false;
        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            if (pessoaJuridica.getId() == id) {
                System.out.println("╠ ID: " + pessoaJuridica.getId());
                System.out.println("╠ NOME: " + pessoaJuridica.getNome());
                System.out.println("╠ CNPJ: " + pessoaJuridica.getCnpj());
                System.out.println("╠═══════════");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Sem Dados neste ID");
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        if (listaPessoaJuridica.isEmpty()) {
            System.out.println("Lamento, mas sua lista está vazia.");
        }

        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            System.out.println("╠ ID: " + pessoaJuridica.getId());
            System.out.println("╠ NOME: " + pessoaJuridica.getNome());
            System.out.println("╠ CNPJ: " + pessoaJuridica.getCnpj());
            System.out.println("╠═══════════");
        }
        return null;
    }

    public void persistir(String persistirArquivo) {
        try (FileOutputStream filePer = new FileOutputStream(persistirArquivo);
             ObjectOutputStream saida = new ObjectOutputStream(filePer)) {
            saida.writeObject(listaPessoaJuridica);
            System.out.println("Dados de Pessoas Juridicas Armazenados");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperar(String recuperarArquivo) {
        try (FileInputStream fileRec = new FileInputStream(recuperarArquivo);
             ObjectInputStream entrada = new ObjectInputStream(fileRec)) {
            listaPessoaJuridica = (ArrayList<PessoaJuridica>) entrada.readObject();
            System.out.println("Dados de Pessoas Juridicas Recuperados");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

