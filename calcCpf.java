import java.util.Scanner;
public class calcCpf{

        int cont = 0;
        int aux = 0;
        int soma = 0;
        int D1 = 0;
        int D2 = 0;
        String digito10 = "";
        String cpf = "";
        int tamanhoInicial = 0;
        String digito11 = "";
        String comparar = "";

        Scanner entrada = new Scanner(System.in);

    public void juntarNum(){
        System.out.print("Entre com o CPF: ");
        cpf = entrada.next();

        // Tirar tudo que for diferente de 0 a 9
        cpf = cpf.replaceAll("[^0-9]", "");
        tamanhoInicial = cpf.length();
        if (cpf.length() == 10) {
            digito10 = cpf.substring(9, 10);
        } else if (cpf.length() == 11) {
            digito11 = cpf.substring(9, 11);
        } else if (cpf.length() == 9){

        }
    }

    public void calcD1() {
        cpf =  cpf.substring(0,9);
        if (cpf.length() == 9 || cpf.length() == 10 || cpf.length() == 11) {
            cont = cpf.length() + 1;
            for (int i = 0; i < cpf.length(); i++) {

                // pegar string na posicao que quiser e realizar conta
                aux = Integer.parseInt(cpf.substring(i, i + 1)) * cont;

                // tirar um do cont para a proxima conta
                cont--;

                soma = soma + aux;
                //System.out.println(aux);//
            }
            //System.out.println(soma);//
            D1 = 11 - (soma % 11);
            if (D1 > 9) {
                D1 = 0;
            }
            if (tamanhoInicial == 10) {
                if (D1 != Integer.parseInt(digito10)) {
                    System.out.println("Seu cpf é inválido");
                    System.exit(0);
                }
            }
            }//System.out.println(D1);//
            cpf += String.valueOf(D1);
            //System.out.println(cpf);//
        }

        public void calcD2(){
            cont = cpf.length() +1;
            soma = 0;
            for (int i = 0; i < cpf.length(); i++){
                aux = Integer.parseInt(cpf.substring(i, i+1)) * cont;
                cont --;
                soma = soma+aux;
                //System.out.println(aux);//
            }
            //System.out.println(soma);//
            D2 = 11 - (soma%11);
            if (D2 > 9){
                D2 = 0;
            } //System.out.println(D2);//
            // concatenar os ultimos digito10 com os que ja estão no cpf
            cpf += String.valueOf(D2);

            comparar = cpf.substring(9,11);
            //System.out.println(comparar);//

            if (tamanhoInicial == 11) {
                if (!comparar.equals(digito11)) {
                    System.out.println("CPF Inválido");
                    System.exit(0);
                }
            }

            // separar cpf certinho
            System.out.println("CPF Válido!");
            System.out.println(cpf.substring(0,3)+"."+(cpf.substring(3,6)+"."+(cpf.substring(6,9)+"-"+(cpf.substring(9,11)))));
        }
    }