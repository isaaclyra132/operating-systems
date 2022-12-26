package org.example.substituicao_pagina;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SubstituicaoPaginaLRU implements Runnable{

    int paginas[];
    int tamanho;
    int quadros;
    int falhasDePaginas;


    public SubstituicaoPaginaLRU(int paginas[], int tamanho, int quadros) {
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

        // Para armazenar índices menos usados recentemente
        // de páginas.
        HashMap<Integer, Integer> indexes = new HashMap<>();

        // Começa da página inicial
        falhasDePaginas = 0;
        for (int i=0; i<tamanho; i++)
        {
            // Verifica se o conjunto pode conter mais páginas
            if (s.size() < quadros)
            {
                // Insere-o no conjunto se não estiver presente
                // já que representa falta de página
                if (!s.contains(paginas[i]))
                {
                    s.add(paginas[i]);

                    // incrementa falha de página
                    falhasDePaginas++;
                }

                // Armazena o índice usado recentemente de
                // cada página
                indexes.put(paginas[i], i);
            }

            // Se o conjunto estiver cheio, será necessário executar lru
            // ou seja, remove a página menos usada recentemente
            // e insere a página atual
            else
            {
                // Verifica se a página atual ainda não está
                // presente no conjunto
                if (!s.contains(paginas[i]))
                {
                    // Encontra as páginas usadas menos recentemente
                    // que está presente no conjunto
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE;

                    Iterator<Integer> itr = s.iterator();

                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru)
                        {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }

                    // Remove a página de índices
                    s.remove(val);
                    //remove lru do hashmap
                    indexes.remove(val);
                    // insere a página atual
                    s.add(paginas[i]);

                    // Incrementa as falhas da página
                    falhasDePaginas++;
                }

                // Atualiza o índice da página atual
                indexes.put(paginas[i], i);
            }
        }
    }

    @Override
    public void run() {
        pageFaults();
        System.out.println("| " + quadros + " QUADROS | SUBSTITUICAO LRU    | FALHAS DE PÁGINA: " + falhasDePaginas + " |");
    }
}
