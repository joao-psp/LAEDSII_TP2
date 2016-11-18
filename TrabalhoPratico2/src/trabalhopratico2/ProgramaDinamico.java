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
import java.util.*;

public class ProgramaDinamico {

    public ProgramaDinamico() {
    }
    
    

    void LinhaMontageDinamica(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2) {
        
        int n=a1.length;
        
        int  f, l, k;
        int[] f1, f2, l1, l2;
        f1 = new int[n];
        f2 = new int[n];
        l1 = new int[n];
        l2 = new int[n];
        f1[0] = e1 + a1[0]; //No primeiro momento é pego os primeiros elementos
        f2[0] = e2 + a2[0]; //e somar nas variaveis
        System.out.println("Tempos na Estação 1");
        System.out.print("Estação\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print("\nTempo\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a1[i]);
        }
        System.out.println("\n\nTempos na Estação 2");
        System.out.print("Estação\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print("\nTempo\t\t:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a2[i]);
        }
        // A programação dinamica leva em conta os caminhos anteriores
        // logo, os caminhos anteriores importam, logo não é parecido
        // com o guloso.

        for (int j = 1; j < n; j++) {// Parte iterativa da progDinmica que armazena em F11 e F2 os caminhos possiveis
            if ((f1[j - 1] + a1[j]) <= (f2[j - 1] + t2[j - 1] + a1[j])) {
                f1[j] = f1[j - 1] + a1[j];
                l1[j] = 1;
            } else {
                f1[j] = f2[j - 1] + t2[j - 1] + a1[j];
                l1[j] = 2;
            }
            if ((f2[j - 1] + a2[j]) <= (f1[j - 1] + t1[j - 1] + a2[j])) {
                f2[j] = f2[j - 1] + a2[j];
                l2[j] = 2;
            } else {
                f2[j] = f1[j - 1] + t1[j - 1] + a2[j];
                l2[j] = 1;
            }
        }

        if (f1[n-1] + x1 < f2[n-1] + x2) { // aqui compara ql o menor caminho possivel, F1 ou F2
            f = f1[n-1] + x1;
            l = 1;
        } else {
            f = f2[n-1] + x2;
            l = 2;
        }
        System.out.println();
        System.out.println("Tempos de Entrada e1=" + e1 + " and e2=" + e2);
        System.out.println("Tempos de Saida x1=" + x1 + " and x2=" + x2);
        System.out.println();
        System.out.println("Tempo Ótimo: " + f);

        System.out.println("\n\nCaminho Ótimo\n");
        k = l;
        System.out.println("Linha " + l + " Estação " + n);
        for (int j = n-1; j >= 1; j--) {

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
    
    /*
    EXEMPLO DE RECURSIVO
        int[] t1 = {0,2,3,1,3,4};
        int[] t2 = {0,2,1,2,2,1};
        int[] a1 = {7,9,3,4,8,4};
        int[] a2 = {8,5,6,4,5,7};
        int x1, x2, e1, e2;
        x1 = 3; x2 = 2; e1 = 2; e2 = 4; 
    
        
    */
    
    public static int LinhaMontagem(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2){
        int n = a1.length-1;
        return Math.min(LinhaMontagemRec(a1,a2,t1,t2, e1,e2, x1,x2, n, 0) + x1, 
                                LinhaMontagemRec(a1,a2,t1,t2, e1,e2, x1,x2, n, 1) + x2);
    }

    public static int LinhaMontagemRec(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2, int n, int line){  
    if(n == 0){
        if(line==0){
           return e1 + a1[0];  
        }else if(line==1){
            return e2 + a2[0];
        }
         
    }  

    int T0 = Integer.MAX_VALUE;  
    int T1 = Integer.MAX_VALUE;  
    if(line == 0){      
        T0 = Math.min(LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 0) + a1[n],             
                            LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 1) + t2[n] + a1[n]);    
    }else if(line == 1){       
        T1 = Math.min(LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 1) + a2[n],             
                             LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 0) + t1[n] + a2[n]);   
    }  

    return Math.min(T0, T1);  
} 
}
