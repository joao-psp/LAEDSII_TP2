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
public class trabalhopratico2 {
    
    public static void main(String[] args) {
        int[] t1 = {0,0,3,5,4,2,7,5,8,1};
        int[] t2 = {0,0,5,3,7,5,6,2,5,2};
        int[] a1 = {5,7,10,5,9,11,9,5,2};
        int[] a2 = {6,3,9,11,4,9,3,12,4};
        int x1, x2, e1, e2;
        x1 = 6; x2 = 5; e1 = 3; e2 = 2; 
        
        System.out.println("-----------------PROBLEMA 1----------");

        ProgramaDinamico Linha1 = new ProgramaDinamico();
        Linha1.LinhaMontageDinamica(a1,a2,t1,t2,e1,e2,x1,x2);
        
        System.out.println("");
        System.out.println("-----------------PROBLEMA 2----------");
        System.out.println("");
        int[] t3 = {0,0,3,5,4,2,7,5,8,1};
        int[] t4 = {0,0,5,3,7,5,6,2,5,2};
        int[] a3 = {10,6,3,8,5,3,7,12};
        int[] a4 = {3,5,3,7,6,4,9,10};
        x1 = 8; x2 = 9; e1 = 5; e2 = 7;
        
        ProgramaDinamico Linha2 = new ProgramaDinamico();
        Linha2.LinhaMontageDinamica(a3,a4,t3,t4,e1,e2,x1,x2);
    
    
    
    }
    
}
