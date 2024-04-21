
package com.mycompany.trabalhoecd;
import java.util.Scanner;

public class TrabalhoECD {
public static Scanner scan = new Scanner(System.in);
private static boolean SairMenuGeral = false;
private static boolean SairOrdenacaoInsercao = false;
private static boolean SairOrdenacaoSelecao = false;
private static boolean SairOrdenacaoBolha = false;

    public static void main(String[]args){
    MenuGeral();
    }

    public static void MenuGeral() {
        SairMenuGeral = false;
        System.out.println("O que deseja fazer?");
        System.out.println("0-Ordenação por Inserção \n1-Ordenação por Seleção "
                + "\n2-Ordenação Bolha\n3-Sair do Menu");
        int recebevalor = scan.nextInt();
        Boolean escolheusair = false; 
    while(!escolheusair){
        switch (recebevalor)
        {
        case 0:
            OrdenacaoInsercao();
            escolheusair = true;
            break;
        case 1:
            OrdenacaoSelecao();
            escolheusair = true;
            break;
        case 2:
            OrdenacaoBolha();
            escolheusair = true;
            break;
        case 3:
            escolheusair = true;
            System.out.println("Você escolheu sair, até mais!");
            System.out.close();
            break;
        default:
            System.out.println("Digitou um número inválido");
            break;
            }
        }
    }
    
    
//1   
    public static void OrdenacaoInsercao(){
        SairOrdenacaoInsercao = false;
        System.out.println("Você escolheu o método Ordenação por Inserção!");
        
        System.out.println("Digite o tamanho do Vetor");
        int vetorTamanho = scan.nextInt();
        
        int vetor[] = new int[vetorTamanho];
        
        
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < vetorTamanho; i++) {
            System.out.print("Digite SOMENTE número(s) INTEIRO(s) para a posição "
                    + " " + i + ": ");
           
            vetor[i] = scan.nextInt();
        }    
        
        int chave;
        int j;
        
        for(int i = 1; i < vetor.length; i++){
            chave = vetor[i];
            
            for(j = i - 1; 
                    (j >= 0 && vetor[j] > chave); j--){
                
                vetor[j+1] = vetor[j];
            }
            vetor[j+1] = chave;
        }
        String msg = "";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - "; 
        } 
        
        long fim = System.currentTimeMillis();
        long tempExec = fim - inicio;
            
        System.out.println("VETOR ORDENADO: "+msg);
        System.out.println("Tempo de execução: "+tempExec);
}   
    
//2    
    public static void OrdenacaoSelecao(){
        SairOrdenacaoSelecao = false;
        System.out.println("Você escolheu o método Ordenação por Seleção!");
        
        System.out.println("Digite o tamanho do Vetor");
        int vetorTamanho = scan.nextInt();
        
        int vetor[] = new int[vetorTamanho];
        

        for (int i = 0; i < vetorTamanho; i++) {
            System.out.print("Digite SOMENTE número(s) INTEIRO(s) para a posição "
                    + i + ": ");
            vetor[i] = scan.nextInt();
        }  
        
        long inicio = System.currentTimeMillis();
        
         for(int i = 0; i < vetor.length-1; i++){
            int menorNum = i;
            
            for(int j = i+1; j < vetor.length; j++){
                if(vetor[j] < vetor[menorNum]){
                    menorNum = j;
                }
            }
            
            if(menorNum != i){
                int aux = vetor[i];
                vetor[i] = vetor[menorNum];
                vetor[menorNum] = aux;
            }
        }
        
        
        for(int i = 0; i < vetor.length; i++){
            System.out.println("posicao ["+i+"] = "+vetor[i]);
        }
        
        long fim = System.currentTimeMillis();
        long tempExec = fim - inicio;
        System.out.println("Tempo de execução: "+tempExec);
        
   } 
    
//3 
   public static void OrdenacaoBolha(){
       SairOrdenacaoBolha = false;
       System.out.println("Você escolheu o método Ordenação por Bolha!");
       
       System.out.println("Digite o tamanho do Vetor");
       int vetorTamanho = scan.nextInt();
       
       long inicio = System.currentTimeMillis();
       int vetor[] = new int[vetorTamanho];
       

        for (int i = 0; i < vetorTamanho; i++) {
            System.out.print("Digite SOMENTE número(s) INTEIRO(s) para a posição "
                    + i + ": ");
            vetor[i] = scan.nextInt();
        }   
        
       boolean troca = true;
        
        while(troca){
            troca = false;
            
            for(int i = 0; i < vetor.length - 1; i++){
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }
        
        
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("posicao ["+i+"] = "+vetor[i]);
            
        }
       long fim = System.currentTimeMillis();
       long tempExec = fim - inicio;
       System.out.println("Tempo de execução: "+tempExec);
   }
}

