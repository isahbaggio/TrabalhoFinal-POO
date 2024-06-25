import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    public List<Pedido> listaPedidos;
    private static int idCounter = 0; 

    public Cliente(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("\n[ERRO] O nome precisa ser preenchido, tente novamente!\n");
        }
        this.id = ++idCounter;
        this.nome = nome;
        this.listaPedidos = new ArrayList<>();
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

    public void fazerPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("\n[ERRO] O pedido precisa ser preenchido, tente novamente!\n");
        }
        listaPedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(listaPedidos);
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", Pedidos: " + listaPedidos.size();
    }
}