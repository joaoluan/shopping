public class Cosmetico extends Loja {
    private double taxaComercializacao;

    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, quantidadeMaximaProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    public Cosmetico(String nome, int quantidadeFuncionarios,  Endereco endereco, Data dataFundacao, int quantidadeMaximaProdutos, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, endereco, dataFundacao, quantidadeMaximaProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }


    public String toString() {
        return super.toString() + "Cosmetico: taxa de Comercialização = " + taxaComercializacao ;
    }

   
}