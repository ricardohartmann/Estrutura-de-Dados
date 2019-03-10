package com.catolica;

public class Main {

    public static void main(String[] args)
    {
        int[] listaNumeros = {43,15,12,32,51,30,19,2};
        int   transfer,
              tamanhoLista = listaNumeros.length,
              ultimoPai    = tamanhoLista/2 - 1;

        System.out.print("Array original:   ");
        exibeArray(listaNumeros);

        // fase 1: arruma triangulos
        for(int i=ultimoPai;i>=0;i--)
        {
            arrumaTriangulo(listaNumeros,tamanhoLista,i);
        }

        // fase 2: primeira posição para última, arruma; para penultima, arruma; para antepenúltima, arruma...
        for(int i=tamanhoLista-1;i>=0;i--)
        {
            transfer = listaNumeros[i];
            listaNumeros[i]=listaNumeros[0];
            listaNumeros[0] = transfer;

            arrumaTriangulo(listaNumeros,i,0);
        }

        System.out.print("Array modificada: ");
        exibeArray(listaNumeros);
    }

    public static void arrumaTriangulo(int[] listaNumeros, int tamanhoLista, int pai)
    {
        int posicaoComMaiorValor = pai; // inicialmente assumindo que o pai é maior
        int filho1 = 2 * pai + 1; // posição do filho 1
        int filho2 = 2 * pai + 2; // posicao do filho 2
        int transfer;

        if(filho1 < tamanhoLista && listaNumeros[filho1] > listaNumeros[posicaoComMaiorValor])
        {
            posicaoComMaiorValor = filho1;
        }

        if(filho2 < tamanhoLista && listaNumeros[filho2] > listaNumeros[posicaoComMaiorValor])
        {
            posicaoComMaiorValor = filho2;
        }

        if(posicaoComMaiorValor!=pai)
        {
            transfer = listaNumeros[pai];
            listaNumeros[pai] = listaNumeros[posicaoComMaiorValor];
            listaNumeros[posicaoComMaiorValor] = transfer;
            arrumaTriangulo(listaNumeros,tamanhoLista,posicaoComMaiorValor); // recursivamente, arrumar os triangulos abaixo, se existirem
        }
    }

    private static void exibeArray(int[] listaNumeros)
    {
        for(int i=0;i<listaNumeros.length;i++)
        {
            System.out.print(listaNumeros[i]);
            if(i!=listaNumeros.length-1){System.out.print(";");}
        }
        System.out.println();
    }
}