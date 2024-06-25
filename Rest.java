import java.util.ArrayList;
import java.util.List;

public class Rest {
    private List<Prato> listCardapio;
    private List<Pedido> listPedidos;
    private List<Cliente> listClientes;

    public Rest() {
        listCardapio = new ArrayList<>();
        listPedidos = new ArrayList<>();
        listClientes = new ArrayList<>();
    }

    public void addPratoAoCardap(Prato prato) {
        if (prato == null) {
            throw new IllegalArgumentException("\n[ERRO] O prato não pode ser nulo, tente novamente!\n");
        }
        listCardapio.add(prato);
    }

    public boolean removePratoDoCardap(int id) {
        Prato prato = getPratoById(id);
        if (prato != null) {
            return listCardapio.remove(prato);
        }
        return false;
    }

    public Prato getPratoById(int id) {
        for (Prato prato : listCardapio) {
            if (prato.getId() == id) {
                return prato;
            }
        }
        return null;
    }

    public Pedido getPedidoById(int id) {
        for (Pedido pedido : listPedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null; 
    }

    public void registPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("\n[ERRO] O pedido não pode ser nulo, tente novamente!\n");
        }
        listPedidos.add(pedido);
    }

    public void addCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("\n[ERRO] O cliente não pode ser nulo, tente novamente!\n");
        }
        listClientes.add(cliente);
    }

    public void listCardapio() {
        if (listCardapio.isEmpty()) {
            System.out.println("\n[ERRO] Nenhum prato descrito no cardápio, por favor adicione!\n");
        } else {
            System.out.println("\nCardápio:\n");
            for (Prato prato : listCardapio) {
                System.out.println(prato);
            }
        }
    }

    public void listPedidos() {
        if (listPedidos.isEmpty()) {
            System.out.println("\n[ERRO] Nenhum pedido existente, faça um pedido!\n");
        } else {
            System.out.println("\nPedidos:\n");
            for (Pedido pedido : listPedidos) {
                System.out.println(pedido);
            }
        }
    }

    public void listClientes() {
        if (listClientes.isEmpty()) {
            System.out.println("\n[ERRO] Nenhum cliente cadastrado, tente novamente!\n");
        } else {
            System.out.println("\nClientes:\n");
            for (Cliente cliente : listClientes) {
                System.out.println(cliente);
            }
        }
    }
}