package org.example.substituicao_pagina;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SubstituicaoPaginaFIFO implements Runnable {

    int paginas[];
    int tamanho;
    int quadros;
    int falhasDePaginas;

    public SubstituicaoPaginaFIFO(int paginas[], int tamanho, int quadros) {
        this.paginas = paginas;
        this.tamanho = tamanho;
        this.quadros = quadros;
    }

    void pageFaults()
    {
        // Para representar o conjunto de páginas atuais. Nós usamos
        // um set não ordenado para que possamos verificar rapidamente
        // se uma página está presente no conjunto ou não
        HashSet<Integer> s = new HashSet<>(quadros);

        // Para armazenar as páginas numa fila (FIFO)
        Queue<Integer> indexes = new LinkedList<>() ;

        // Comece da página inicial
        falhasDePaginas = 0;
        for (int i=0; i<tamanho; i++)
        {
            // Verifica se o conjunto pode conter mais páginas
            if (s.size() < quadros)
            {
                // Insere-o no conjunto se não estiver presente
                // já que representa falha de página
                if (!s.contains(paginas[i]))
                {
                    s.add(paginas[i]);

                    // incrementa falha de página
                    falhasDePaginas++;

                    // Coloca a página atual na fila
                    indexes.add(paginas[i]);
                }
            }

            // Se o conjunto estiver cheio então precisa executar FIFO
            // ou seja, remove a primeira página da fila de
            // define e enfileira ambos e insere a página atual
            else
            {
                // Verifica se a página atual ainda não está
                // presente no conjunto
                if (!s.contains(paginas[i]))
                {
                    //Abre a primeira página da fila
                    int val = indexes.peek();

                    indexes.poll();

                    // Remove a página de índices
                    s.remove(val);

                    // insere a página atual
                    s.add(paginas[i]);

                    // empurra a página atual para dentro
                    // a fila
                    indexes.add(paginas[i]);

                    // Incrementa as falhas da página
                    falhasDePaginas++;
                }
            }
        }
    }

    @Override
    public void run() {
        pageFaults();
        System.out.println("| " + quadros + " QUADROS | SUBSTITUICAO FIFO   | FALHAS DE PÁGINA: " + falhasDePaginas + " |");
    }
}
