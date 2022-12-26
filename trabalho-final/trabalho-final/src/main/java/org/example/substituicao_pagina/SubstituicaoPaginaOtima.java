package org.example.substituicao_pagina;

public class SubstituicaoPaginaOtima implements Runnable{

    int paginas[];
    int tamanho;
    int quadros;
    int falhasDePaginas;


    public SubstituicaoPaginaOtima(int[] paginas, int tamanho, int quadros) {
        this.paginas = paginas;
        this.tamanho = tamanho;
        this.quadros = quadros;
    }

    // Função para verificar se existe uma página
    // em um quadro ou não
    static boolean search(int key, int[] fr)
    {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }

    // Função para encontrar o quadro que não será utilizado
    // previamente no futuro após determinado índice em pg[0..pn-1]
    static int predict(int pg[], int[] fr, int pn,
                       int index)
    {
        // Armazena o índice das páginas que serão
        // usadas no futuro
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pn; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            // Se uma página nunca for referenciada no futuro,
            // devolver.
            if (j == pn)
                return i;
        }

        // Se todos os quadros não estiverem no futuro,
        // retorna qualquer um deles, retornamos 0. Caso contrário
        // retornamos res.
        return (res == -1) ? 0 : res;
    }

    void pageFaults()
    {
        // Cria um array para determinado número de
        // quadros e inicializa-o como vazio.
        int[] fr = new int[quadros];

        // Atravessa o array de referência da página
        // e verifica erros e acertos.
        int hit = 0;
        int index = 0;
        for (int i = 0; i < tamanho; i++) {

            // Page found in a frame : HIT
            if (search(paginas[i], fr)) {
                hit++;
                continue;
            }

            // Página não encontrada em um frame: FALHA

            // Se houver espaço disponível em quadros.
            if (index < quadros)
                fr[index++] = paginas[i];

                // Encontre a página a ser substituída.
            else {
                int j = predict(paginas, fr, tamanho, i + 1);
                fr[j] = paginas[i];
            }
        }
        falhasDePaginas = tamanho - hit;
    }

    @Override
    public void run() {
        pageFaults();
        System.out.println("| " + quadros + " QUADROS | SUBSTITUICAO OTIMA  | FALHAS DE PÁGINA: " + falhasDePaginas + " |");
    }
}
