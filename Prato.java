public class Prato {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private static int idCounter = 0;

    public Prato(String nome, String descricao, double preco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("\n[ERRO] O nome precisa ser preenchido, tente novamente!\n");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("\n[ERRO] A descrição precisa ser preenchida, tente novamente!\n");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("\n[ERRO] O preço não pode ser negativo, tente novamente!\n");
        }
        this.id = generateId();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    private synchronized int generateId() {
        return ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("\n[ERRO] O nome precisa ser preenchido, tente novamente!\n");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("\n[ERRO] A descrição precisa ser preenchida, tente novamente!\n");
        }
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("\n[ERRO] O preço não pode ser negativo, tente novamente!\n");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return id + ". " + nome + " - " + descricao + " - R$ " + preco;
    }
}