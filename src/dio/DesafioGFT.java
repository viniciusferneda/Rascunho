package dio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioGFT {

    public static void main(String[] args) {
        /* Prova 1
        Scanner scan = new Scanner(System.in);
        double raio = Double.parseDouble(scan.next());
        double area = 3.14159 * (Math.pow(raio, 2));
        System.out.printf("A=%.4f\n", area);*/

        /* Prova 2
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        String[] cpf = new String[4];
        final String line = sc.nextLine();
        cpf = line.split("\\.|\\-");
        for (final String str: cpf) {
            System.out.printf("%s\n",str);
        }
        sc.close();*/

        /*Prova 3*/

        final Scanner sc = new Scanner(System.in);

        final List<String> lAlunos = new ArrayList<>();

        int qtdAlunos, vlAtualFicha, idxAtual, idxAlunoEliminado;

        qtdAlunos = Integer.parseInt(sc.nextLine());

        while (qtdAlunos > 0) {
            for (int i = 0; i < qtdAlunos; i++) {
                lAlunos.add(sc.nextLine());
            }

            idxAtual = 0;
            vlAtualFicha = Integer.parseInt(lAlunos.get(idxAtual).split(" ")[1]);

            for (int i = 0; i < qtdAlunos - 1; i++) {
                if (vlAtualFicha % 2 == 0) {
                    idxAlunoEliminado = (lAlunos.size() - (vlAtualFicha % lAlunos.size()) + idxAtual) % lAlunos.size();
                } else {
                    idxAlunoEliminado = (vlAtualFicha % lAlunos.size() + idxAtual) % lAlunos.size();
                }

                vlAtualFicha = Integer.parseInt(lAlunos.get(idxAlunoEliminado).split(" ")[1]);
                lAlunos.remove(idxAlunoEliminado);

                idxAtual = (vlAtualFicha % 2 == 0)
                        ? ((idxAlunoEliminado <= lAlunos.size() - 1) ? idxAlunoEliminado : 0)
                        : ((idxAlunoEliminado == 0) ? (lAlunos.size() - 1) : (idxAlunoEliminado - 1));

            }
            System.out.println("Vencedor(a): " + lAlunos.get(0).split(" ")[0]);

            lAlunos.clear();
            qtdAlunos = Integer.parseInt(sc.nextLine());
        }

        sc.close();
    }
}
