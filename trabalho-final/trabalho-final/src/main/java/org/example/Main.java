package org.example;

import org.example.substituicao_pagina.SubstituicaoPaginaFIFO;
import org.example.substituicao_pagina.SubstituicaoPaginaLRU;
import org.example.substituicao_pagina.SubstituicaoPaginaOtima;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int paginas[] = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 6};


//      SUBSTITUICAO COM 3 QUADROS
        int quadros = 3;
        System.out.println("-------------------------------------------------------------------------------");
        Thread threadFIFOSubstituicao3Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao3Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadOtima3Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threadFIFOSubstituicao3Quadros.start();
        threadLRUSubstituicao3Quadros.start();
        threadOtima3Quadros.start();

        // ESPERA AS THREADS TERMINAREM A TAREFA
        try {
            threadFIFOSubstituicao3Quadros.join();
            threadLRUSubstituicao3Quadros.join();
            threadOtima3Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");


//      SUBSTITUICAO COM 4 QUADROS
        quadros = 4;
        Thread threadFIFOSubstituicao4Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao4Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadOtima4Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threadFIFOSubstituicao4Quadros.start();
        threadLRUSubstituicao4Quadros.start();
        threadOtima4Quadros.start();

        // ESPERA AS THREADS TERMINAREM A TAREFA
        try {
            threadFIFOSubstituicao4Quadros.join();
            threadLRUSubstituicao4Quadros.join();
            threadOtima4Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 5 QUADROS
        quadros = 5;
        Thread threadFIFOSubstituicao5Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao5Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadOtima5Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threadFIFOSubstituicao5Quadros.start();
        threadLRUSubstituicao5Quadros.start();
        threadOtima5Quadros.start();

        // ESPERA AS THREADS TERMINAREM A TAREFA
        try {
            threadFIFOSubstituicao5Quadros.join();
            threadLRUSubstituicao5Quadros.join();
            threadOtima5Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 6 QUADROS
        quadros = 6;
        Thread threadFIFOSubstituicao6Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao6Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadOtima6Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threadFIFOSubstituicao6Quadros.start();
        threadLRUSubstituicao6Quadros.start();
        threadOtima6Quadros.start();

        // ESPERA AS THREADS TERMINAREM A TAREFA
        try {
            threadFIFOSubstituicao6Quadros.join();
            threadLRUSubstituicao6Quadros.join();
            threadOtima6Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 7 QUADROS
        quadros = 7;
        Thread threadFIFOSubstituicao7Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao7Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadOtima7Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threadFIFOSubstituicao7Quadros.start();
        threadLRUSubstituicao7Quadros.start();
        threadOtima7Quadros.start();

        // ESPERA AS THREADS TERMINAREM A TAREFA
        try {
            threadFIFOSubstituicao7Quadros.join();
            threadLRUSubstituicao7Quadros.join();
            threadOtima7Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

    }
}