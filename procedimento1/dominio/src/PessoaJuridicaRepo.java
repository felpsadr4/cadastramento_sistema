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

    public void alterar(int indice, PessoaJuridica pessoa) {
        if (indice >= 0 && indice < listaPessoaJuridica.size()) {
            listaPessoaJuridica.set(indice, pessoa);
        } else {
            System.out.println("Erro no Alterar");
        }
    }

    public void excluir(int id) {
        for (PessoaJuridica pessoa : listaPessoaJuridica) {
            if (pessoa.getId() == id) {
                listaPessoaJuridica.remove(pessoa);
                System.out.println("Pessoa com ID " + id + " excluída com sucesso");
                return;
            }
        }
        System.out.println("Pessoa com o ID " + id + " não encontrada para excluir");
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : listaPessoaJuridica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return (ArrayList<PessoaJuridica>) listaPessoaJuridica;
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

