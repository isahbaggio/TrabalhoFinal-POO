import java.util.InputMismatchException;
import java.util.Scanner;

public class SistRest {
    private static Rest restaurante = new Rest();
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerOpcao();
            tratarOpcao(opcao);
        } while (opcao != 8);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nSistema de Gerenciamento do Restaurante:\n");
        System.out.println("1. Listar cardápio");
        System.out.println("2. Fazer pedido");
        System.out.println("3. Consulta total de um pedido");
        System.out.println("4. Adicionar prato ao cardápio");
        System.out.println("5. Remover prato do cardápio");
        System.out.println("6. Listar pedidos");
        System.out.println("7. Listar clientes");
        System.out.println("8. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static int lerOpcao() {
        int opcao = -1;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] Opção inválida! Por favor, insira um número.\n");
        } finally {
            scanner.nextLine();
        }
        return opcao;
    }

    private static void tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                restaurante.listCardapio();
                break;
            case 2:
                doPedido();
                break;
            case 3:
                consultarPedido();
                break;
            case 4:
                addPratoCard();
                break;
            case 5:
                removePrato();
                break;
            case 6:
                restaurante.listPedidos();
                break;
            case 7:
                restaurante.listClientes();
                break;
            case 8:
                System.out.println("\nSaindo...\n");
                break;
            default:
                System.out.println("\n[ERRO] Opção inválida, tente novamente!\n");
                break;
        }
    }

    private static void addPratoCard() {
        System.out.println("\nDigite os dados do prato:");
        System.out.print("\nNome:");
        String nome = scanner.nextLine();
        System.out.print("\nDescrição: ");
        String descricao = scanner.nextLine();
        System.out.print("\nPreço: ");
        double preco = 0.0;
        try {
            preco = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] Preço inválido! Por favor, insira um número.\n");
            return;
        } finally {
            scanner.nextLine();
        }
        Prato prato = new Prato(nome, descricao, preco);
        restaurante.addPratoAoCardap(prato);
        System.out.println("\nPrato adicionado com sucesso!\n");
    }

    private static void doPedido() {
        System.out.println("\nDigite os dados do pedido:");
        System.out.print("\nNome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        restaurante.addCliente(cliente);
        Pedido pedido = new Pedido();
        int idPrato, quantidade;
        while (true) {
            System.out.print("\nDigite o ID do prato (ou 0 para finalizar o pedido): ");
            try {
                idPrato = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] ID inválido! Por favor, insira um número.\n");
                scanner.nextLine();
                continue;
            }
            if (idPrato == 0) {
                break;
            }
            System.out.print("\nDigite a quantidade: ");
            try {
                quantidade = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Quantidade inválida! Por favor, insira um número.\n");
                scanner.nextLine();
                continue;
            }
            Prato pratoPedido = restaurante.getPratoById(idPrato);
            if (pratoPedido != null) {
                pedido.addPrato(pratoPedido, quantidade);
            } else {
                System.out.println("\n[ERRO] Prato não encontrado, tente novamente!\n");
            }
        }
        cliente.fazerPedido(pedido);
        restaurante.registPedido(pedido);
        System.out.println("\nPedido realizado com sucesso!\n");
    }

    private static void consultarPedido() {
        System.out.println("\nDigite o ID do pedido:");
        int idPedido;
        try {
            idPedido = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] ID inválido! Por favor, insira um número.\n");
            scanner.nextLine();
            return;
        }
        Pedido pedido = restaurante.getPedidoById(idPedido);
        if (pedido != null) {
            System.out.println(pedido);
        } else {
            System.out.println("\n[ERRO] Pedido não encontrado!\n");
        }
    }

    private static void removePrato() {
        System.out.println("\nDigite o ID do prato a ser removido:");
        int idPrato;
        try {
            idPrato = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] ID inválido! Por favor, insira um número.\n");
            scanner.nextLine();
            return;
        }
        boolean sucesso = restaurante.removePratoDoCardap(idPrato);
        if (sucesso) {
            System.out.println("\nPrato removido com sucesso!\n");
        } else {
            System.out.println("\n[ERRO] Prato não encontrado, tente novamente!\n");
        }
    }
}