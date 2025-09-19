import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        Loja loja = null;
        Produto produto = null;

        do {
            exibirMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine(); // Limpa o buffer
                exibirMenu();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após nextInt()

            switch (opcao) {
                case 1:
                    System.out.println("Criando uma nova loja:");
                    loja = novaLoja();
                    if (loja != null) {
                        System.out.println("Loja criada com sucesso:");
                        System.out.println(loja.toString());
                    }
                    break;
                case 2:
                    System.out.println("Criando um novo produto:");
                    produto = novoProduto();
                    if (produto != null) {
                        System.out.println(produto.toString());

                        if (produto.isVencido()) {
                            System.out.println("PRODUTO VENCIDO");
                        } else {
                            System.out.println("PRODUTO NÃO VENCIDO");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    public static void exibirMenu() {
        System.out.println("\n(1) Criar uma loja");
        System.out.println("(2) Criar um produto");
        System.out.println("(3) Sair");
        System.out.print("Digite a opção desejada: ");
    }

    public static Loja novaLoja() {
        Scanner scannerLoja = new Scanner(System.in);
        System.out.println("Digite o nome da loja: ");
        String nome = scannerLoja.nextLine();
        System.out.println("Digite a quantidade de funcionários: ");
        int quantidadeFuncionarios = scannerLoja.nextInt();
        scannerLoja.nextLine(); // Limpa o buffer após nextInt()
        System.out.println("Digite o salário base: ");
        double salarioBaseFuncionario = scannerLoja.nextDouble();
        scannerLoja.nextLine(); // Limpa o buffer após nextDouble()
        System.out.println("Digite a quantidade máxima de produtos: ");
        int quantMaxProdutos = scannerLoja.nextInt();
        scannerLoja.nextLine(); // Limpa o buffer após nextInt()

        Data dataFundacao = novaData("Digite a data de fundação da sua loja (dd/mm/aaaa): ");
        Endereco endereco = novoEndereco("Digite as informações referentes ao seu endereço: ");

        scannerLoja.close();

        return new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantMaxProdutos);
    }

    public static Produto novoProduto() {
        Scanner scannerProduto = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = scannerProduto.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = scannerProduto.nextDouble();
        scannerProduto.nextLine(); // Limpa o buffer após nextDouble()

        Data dataValidade = novaData("Digite a data de validade do produto (dd/mm/aaaa): ");

        scannerProduto.close();

        return new Produto(nome, preco, dataValidade);
    }

    private static Endereco novoEndereco(String mensagem) {
        Scanner scannerEndereco = new Scanner(System.in);
        System.out.println(mensagem);

        System.out.println("Digite o nome da rua: ");
        String nomeDaRua = scannerEndereco.nextLine();
        System.out.println("Digite o número:");
        String numero = scannerEndereco.nextLine();
        System.out.println("Digite a cidade:");
        String nomeDaCidade = scannerEndereco.nextLine();
        System.out.println("Digite o país:");
        String pais = scannerEndereco.nextLine();
        System.out.println("Digite o estado:");
        String estado = scannerEndereco.nextLine();
        System.out.println("Digite o CEP:");
        String cep = scannerEndereco.nextLine();
        System.out.println("Digite o complemento:");
        String complemento = scannerEndereco.nextLine();

        scannerEndereco.close();

        return new Endereco(nomeDaRua, nomeDaCidade, estado, pais, cep, numero, complemento);
    }

    private static Data novaData(String mensagemInicial) {
        Scanner scannerData = new Scanner(System.in);
        System.out.println(mensagemInicial);
        System.out.println("Digite o dia:");
        int dia = scannerData.nextInt();
        System.out.println("Digite o mês:");
        int mes = scannerData.nextInt();
        System.out.println("Digite o ano:");
        int ano = scannerData.nextInt();

        scannerData.close();

        return new Data(dia, mes, ano);
    }
}
