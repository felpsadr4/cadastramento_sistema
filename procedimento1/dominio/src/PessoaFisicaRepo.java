import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo implements Serializable {
    private List<PessoaFisica> listaPessoaFisica;

    public PessoaFisicaRepo(List<PessoaFisica> listaPessoaFisica) {

        this.listaPessoaFisica = listaPessoaFisica;
    }

    public PessoaFisicaRepo() {

        this.listaPessoaFisica = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {

        listaPessoaFisica.add(pessoa);

    }

    public void alterar(int indice, PessoaFisica pessoa) {
        if (indice >= 0 && indice < listaPessoaFisica.size()) {
            listaPessoaFisica.set(indice, pessoa);
        } else {
            System.out.println("Erro no Alterar");
        }
    }

    public void excluir(int id) {
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                listaPessoaFisica.remove(pessoa);
                System.out.println("Pessoa com ID " + id + " excluída com sucesso");
                return;
            }
        }
        System.out.println("Pessoa com o ID " + id + " não encontrada para excluir");
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return (ArrayList<PessoaFisica>) listaPessoaFisica;
    }


    public void persistir(String persistirArquivo) {
        try (FileOutputStream filePer = new FileOutputStream(persistirArquivo);
             ObjectOutputStream saida = new ObjectOutputStream(filePer)) {
            saida.writeObject(listaPessoaFisica);
            System.out.println("Dados de Pessoas Fisicas Armazenados");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperar(String recuperarArquivo) {
        try (FileInputStream fileRec = new FileInputStream(recuperarArquivo);
             ObjectInputStream entrada = new ObjectInputStream(fileRec)) {
            listaPessoaFisica = (ArrayList<PessoaFisica>) entrada.readObject();
            System.out.println("Dados de Pessoas Fisicas Recuperados");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

