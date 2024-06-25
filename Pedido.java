import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private int id;
    private Map<Prato, Integer> pratos;
    private static int idCounter = 0;

    public Pedido() {
        this.id = ++idCounter;
        pratos = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void addPrato(Prato prato, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("\n[ERRO] A quantidade deve ser positiva, tente novamente\n");
        }
        if (pratos.containsKey(prato)) {
            int novaQuantidade = pratos.get(prato) + quantidade;
            pratos.put(prato, novaQuantidade);
        } else {
            pratos.put(prato, quantidade);
        }
    }

    public double calcTotal() {
        double total = 0.0;
        for (Map.Entry<Prato, Integer> entry : pratos.entrySet()) {
            total += entry.getKey().getPreco() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Prato, Integer> entry : pratos.entrySet()) {
            sb.append(entry.getKey().getNome())
              .append(" - Quantidade: ")
              .append(entry.getValue())
              .append(" - Total: R$ ")
              .append(String.format("%.2f", entry.getKey().getPreco() * entry.getValue()))
              .append("\n");
        }
        sb.append("Total do pedido: R$ ").append(String.format("%.2f", calcTotal()));
        return sb.toString();
    }
}