import java.util.Scanner;

public class Produtos {

    public static void main(String[] args) {
        char continua;
        String produto,produtoCaro="",produtoBarato="";
        double valorCompra,quantidade,desconto,novoValor,totalCompra,valorDesconto,maior=0,menor=999999999,somatoria=0,media;
        int codProduto,i = 0,j=0;
        Scanner input= new Scanner(System.in);
        do {
                i++;
                System.out.print("Digite o nome do produto: ");
                produto = input.nextLine();
                System.out.print("Digite o preço do produto: ");
                valorCompra = input.nextDouble();
                valorDesconto = valorCompra;
                if (valorCompra > maior){
                    maior = valorCompra;
                    produtoCaro = produto;
                }
                if (valorCompra < menor){
                    menor = valorCompra;
                    produtoBarato = produto;
                }
                System.out.print("Digite o código do produto: ");
                codProduto = input.nextInt();
                if ((codProduto == 1 || codProduto == 3 || codProduto == 5) && (valorCompra >= 1000)){
                    desconto = 1.50;
                    valorDesconto = (valorCompra*desconto)/100; // x=1000*15/100
                    System.out.println("Desconto de "+desconto+"% aplicado! Ficou R$: "+valorDesconto);
                    novoValor = (valorCompra-valorDesconto); //1000-15=985
                    j++;
                } else {
                    novoValor = valorCompra;
                }
                System.out.print("Digite a quantidade comprada: ");
                quantidade = input.nextDouble(); //5
                totalCompra = novoValor*quantidade; // 985 x 5 = 4250
                System.out.println("O total da compra ficou: R$"+totalCompra);
                somatoria+=totalCompra; // 4250
                System.out.print("Deseja Continuar? S/N: ");
                continua = input.next().toUpperCase().charAt(0);
                input.nextLine();
        }while(continua != 'N');
            System.out.println("O produto mais barato é: "+produtoBarato+" que custa: "+menor);
            System.out.println("O produto mais caro é: "+produtoCaro+" que custa: "+maior);
            System.out.println("O total da compra foi: R$"+somatoria);
            if (somatoria > 2000 && somatoria <= 4000){
                desconto = 3;
                novoValor = (somatoria*desconto)/100;
                System.out.println("Teve um desconto de:"+desconto+"%. O novo valor é: R$"+novoValor);
            } else if (somatoria > 4000){
                desconto = 5;
                novoValor = (somatoria*desconto)/100;
                System.out.println("Teve um desconto de:"+desconto+"%. O novo valor é: R$"+novoValor);
            }
            System.out.println("O numero de descontos especiais foi: "+j);
            media=somatoria/i;
            System.out.println("A media total das vendas foi: R$"+media);

    }
}