package com.mycompany.rainhas;

public class AlgoLimpo {

    public static void main(String[] args) {

        int n = 8;
        int[] posicao = new int[n];
        
        for(int i=0; i<n;i++){
            posicao[i] = -1;
        }
        
        for(int solucao=1;solucao <= n;solucao++){
            
            posicao[0] = solucao-1;
        
            for (int linha = 1; linha < n; linha++) {
                for (int coluna = 0; coluna <= n; coluna++) {
                    while(coluna==n){
                        linha--;
                        if(linha<0){
                            printarSemSolucao(solucao,n);
                            return;
                        }
                        coluna = posicao[linha]+1;
                    }
                    if(posicao[linha]!=coluna && verificarRestricoes(posicao, n, linha, coluna)) {// aceitar essa posição
                        posicao[linha]=coluna;
                        break;
                    }
                }
            }
            if(posicao[0]==solucao-1){
                printarSolucao(solucao,posicao,n);
            }else{
                printarSemSolucao(solucao,n);
            }
        }
    }
    
    public static boolean verificarRestricoes(int[] posicao, int n, int linha, int coluna) {
        for (int i = 0; i < linha; i++) { // vertical
            if (posicao[i] == coluna) {
                return false;
            }
        }

        if(linha!=0){// diagnonal esquerda
            int j = coluna;
            for(int i = linha-1; i>=0; i--){
                j--;
                if(j<0){break;}
                if(posicao[i]==j){// tenho uma rainha nesta posicao
                    return false;
                }
            }
            
            j = coluna;
            for(int i = linha-1; i>=0; i--){
                j++;
                if(j==n){break;}
                if(posicao[i]==j){// tenho uma rainha nesta posicao
                    return false;
                }
            }
        }
        return true;
    }

    public static void printarSolucao(int solucao, int[] posicao, int n){
        System.out.println("\n\n\n\n\n");
        System.out.println("##############################################################");
        System.out.println("");
        System.out.println("          SOLUÇÃO "+solucao+" PARA N = "+n+" (posições 0 -> "+(n-1)+")");
        System.out.println("");
        
        for(int i=0;i<n;i++){
            System.out.print(" Linha "+i+", coluna "+posicao[i]+"\t |");
            for(int c=0; c<n;c++){
                if(posicao[i]!=c){
                    System.out.print(" ");
                }else{
                    System.out.print("#");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("##############################################################");
        System.out.println("");
        System.out.println("");
    }
    
    public static void printarSemSolucao(int solucao,int n){
        System.out.println("##############################################################");
        System.out.println("");
        System.out.println("Sem solução para N = "+n+", quando incia-se na posicao(0,"+solucao+").");
        System.out.println("");
        System.out.println("##############################################################");
    }

    
    
}
