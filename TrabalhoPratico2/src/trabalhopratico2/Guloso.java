/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico2;

/**
 *
 * @author JoãoPedro
 */
public class Guloso {

    public Guloso() {
    }

    void LinhaMontagemGuloso(int[] a1, int[] a2, int[] t1, int[] t2, int e1, int e2, int x1, int x2) {

        int n = a1.length;

        int f, l, k;
        int[] f1, f2, l1, l2;
        f1 = new int[n];
        f2 = new int[n];
        l1 = new int[n];
        l2 = new int[n];
        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];
        System.out.println("Tempos na Estação 1");
        System.out.print("Station\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print("\nAssembly Time\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a1[i]);
        }
        System.out.println("\n\nTempos na Estação 2");
        System.out.print("Station\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print("\nAssembly Time\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a2[i]);
        }

        for (int j = 1; j < n; j++) {
            if (a1[j] <= t2[j - 1] + a1[j]) {
                f1[j] = a1[j];
                l1[j] = 1;
            } else {
                f1[j] = t2[j - 1] + a1[j];
                l1[j] = 2;
            }
            if (a2[j] <= t1[j - 1] + a2[j]) {
                f2[j] = a2[j];
                l2[j] = 2;
            } else {
                f2[j] = t1[j - 1] + a2[j];
                l2[j] = 1;
            }
        }

        if (f1[n - 1] + x1 < f2[n - 1] + x2) {
            f = f1[n - 1] + x1;
            l = 1;
        } else {
            f = f2[n - 1] + x2;
            l = 2;
        }
        System.out.println();
        System.out.println("Tempos de Entrada e1=" + e1 + " and e2=" + e2);
        System.out.println("Tempos de Saida x1=" + x1 + " and x2=" + x2);
        System.out.println();
        System.out.println("Optimal Time is: " + f);

        System.out.println("\n\nCaminho Ótimo\n");
        k = l;
        System.out.println("Linha " + l + " Estação " + n);
        for (int j = n - 1; j >= 1; j--) {

            if (k == 1) {
                k = l1[j];
                System.out.println("Linha " + k + " Estação " + (j) + " ");
            } else {
                k = l2[j];
                System.out.println("linha " + k + " Estação " + (j) + " ");
            }
        }
        System.out.println();

    }

}
