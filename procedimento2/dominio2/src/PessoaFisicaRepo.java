import javax.swing.plaf.synth.SynthOptionPaneUI;
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

    public void alterar(int id, PessoaFisica pessoaFisicaAlterada) {
        for (int i = 0; i < this.listaPessoaFisica.size(); i++) {
            PessoaFisica pessoaFisica = this.listaPessoaFisica.get(i);
            if (pessoaFisica.getId() == id) {
                pessoaFisica.setNome(pessoaFisicaAlterada.getNome());
                pessoaFisica.setCpf(pessoaFisicaAlterada.getCpf());
                pessoaFisica.setIdade(pessoaFisicaAlterada.getIdade());

            }
        }
    }

    public void excluir(int id) {
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                listaPessoaFisica.remove(pessoa);
                return;
            }
        }
        System.out.println("Pessoa com o ID " + id + " não encontrada para excluir");
    }

    public PessoaFisica obter(int id) {
        boolean encontrado = false;

        for (PessoaFisica pessoaFisica : listaPessoaFisica) {
            if (pessoaFisica.getId() == id) {
                System.out.println("╠ ID: " + pessoaFisica.getId());
                System.out.println("╠ NOME: " + pessoaFisica.getNome());
                System.out.println("╠ CPF: " + pessoaFisica.getCpf());
                System.out.println("╠ IDADE: " + pessoaFisica.getIdade());
                System.out.println("╠═══════════");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Sem Dados neste ID");
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        if (listaPessoaFisica.isEmpty()) {
            System.out.println("Lamento, mas sua lista está vazia.");
        }

        for (PessoaFisica pessoaFisica : listaPessoaFisica) {
            System.out.println("╠ ID: " + pessoaFisica.getId());
            System.out.println("╠ NOME: " + pessoaFisica.getNome());
            System.out.println("╠ CPF: " + pessoaFisica.getCpf());
            System.out.println("╠ IDADE: " + pessoaFisica.getIdade());
            System.out.println("╠═══════════");
        }
        return null;
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

