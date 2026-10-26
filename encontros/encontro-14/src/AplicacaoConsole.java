import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConsole {
    private static void imprimirRecibo(Cobravel c) {
        System.out.printf(Locale.ROOT,"Recibo %d | %s | %s | R$ %.2f%n",c.getNumero(),c.getPlaca(),c.getDescricao(),c.calcularValor());
    }
    private static void imprimirRecibo(Cobravel c,String observacao) {
        imprimirRecibo(c);System.out.println("Observacao: "+observacao);
    }
    // A preparacao fixa propaga falhas; cada operacao do usuario e tratada no laco.
    public static void main(String[] args) throws RegraNegocioException {
        Estacionamento est=new Estacionamento();
        est.cadastrarVeiculo(new Carro("ABC1D23","Hatch"));
        est.cadastrarVeiculo(new Moto("XYZ9K87","Urbana"));
        Scanner entrada=new Scanner(System.in);
        while(true) {
            System.out.println("1 Veiculos | 2 Entrada | 3 Abertas | 4 Saida | 5 Lavagem | 6 Historico | 7 Total | 8 Cadastrar | 9 Consultar | 10 Alterar | 11 Remover | 0 Sair");
            if(!entrada.hasNextLine()) break;
            try {
                int opcao=Integer.parseInt(entrada.nextLine().trim());
                if(opcao==0) break;
                if(opcao==1) {
                    for(Veiculo v:est.listarVeiculos())System.out.println(v);
                } else if(opcao==2) {
                    System.out.println("Placa:");int numero=est.registrarEntrada(entrada.nextLine());
                    System.out.println("Entrada registrada: "+numero);
                } else if(opcao==3) {
                    if(est.listarPermanenciasAtivas().isEmpty())System.out.println("Nenhuma permanencia aberta");
                    for(Permanencia p:est.listarPermanenciasAtivas())System.out.println(p);
                } else if(opcao==4) {
                    System.out.println("Placa:");String placa=entrada.nextLine();
                    System.out.println("Minutos positivos:");int minutos=Integer.parseInt(entrada.nextLine().trim());
                    imprimirRecibo(est.registrarSaida(placa,minutos));
                } else if(opcao==5) {
                    System.out.println("Placa:");imprimirRecibo(est.registrarLavagem(entrada.nextLine()),"Visita permanece aberta");
                } else if(opcao==6) {
                    if(est.listarCobrancas().isEmpty())System.out.println("Historico vazio");
                    for(Cobravel c:est.listarCobrancas())imprimirRecibo(c);
                } else if(opcao==7)System.out.printf(Locale.ROOT,"Total R$ %.2f%n",est.totalizarCobrancas());
                else if(opcao==8) {
                    System.out.println("Categoria (C/M):");String tipo=entrada.nextLine().trim().toUpperCase(Locale.ROOT);
                    System.out.println("Placa:");String placa=entrada.nextLine();
                    System.out.println("Modelo:");String modelo=entrada.nextLine();
                    Veiculo v;
                    if(tipo.equals("C"))v=new Carro(placa,modelo);
                    else if(tipo.equals("M"))v=new Moto(placa,modelo);
                    else throw new IllegalArgumentException("Categoria deve ser C ou M");
                    est.cadastrarVeiculo(v);System.out.println("Cadastro realizado");
                } else if(opcao==9) {
                    System.out.println("Placa:");System.out.println(est.consultarVeiculo(entrada.nextLine()));
                } else if(opcao==10) {
                    System.out.println("Placa:");String placa=entrada.nextLine();
                    System.out.println("Novo modelo:");est.atualizarModelo(placa,entrada.nextLine());System.out.println("Modelo atualizado");
                } else if(opcao==11) {
                    System.out.println("Placa:");est.removerVeiculo(entrada.nextLine());System.out.println("Cadastro removido");
                } else System.out.println("Opcao inexistente");
            // TODO 14.6: acrescente as capturas especificas antes do apoio abaixo.
            } catch (UnsupportedOperationException etapa) {
                System.out.println("ETAPA PENDENTE: " + etapa.getMessage());
            }
        }
        entrada.close();
    }
}
