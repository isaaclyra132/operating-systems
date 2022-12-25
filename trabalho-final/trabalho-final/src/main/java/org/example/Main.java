package org.example;

import org.example.substituicao_pagina.SubstituicaoPaginaFIFO;
import org.example.substituicao_pagina.SubstituicaoPaginaLRU;
import org.example.substituicao_pagina.SubstituicaoPaginaOtima;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        int paginas[] = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 6};

        System.out.println("-------------------------------------------------------------------------------");


//      SUBSTITUICAO COM 3 QUADROS
        int quadros = 3;
        Thread threasFIFOSubstituicao3Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao3Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadLRUOtima3Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threasFIFOSubstituicao3Quadros.start();
        threadLRUSubstituicao3Quadros.start();
        threadLRUOtima3Quadros.start();

        try {
            threasFIFOSubstituicao3Quadros.join();
            threadLRUSubstituicao3Quadros.join();
            threadLRUOtima3Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");


//      SUBSTITUICAO COM 4 QUADROS
        quadros = 4;
        Thread threasFIFOSubstituicao4Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao4Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadLRUOtima4Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threasFIFOSubstituicao4Quadros.start();
        threadLRUSubstituicao4Quadros.start();
        threadLRUOtima4Quadros.start();

        try {
            threasFIFOSubstituicao4Quadros.join();
            threadLRUSubstituicao4Quadros.join();
            threadLRUOtima4Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 5 QUADROS
        quadros = 5;
        Thread threasFIFOSubstituicao5Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao5Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadLRUOtima5Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threasFIFOSubstituicao5Quadros.start();
        threadLRUSubstituicao5Quadros.start();
        threadLRUOtima5Quadros.start();

        try {
            threasFIFOSubstituicao5Quadros.join();
            threadLRUSubstituicao5Quadros.join();
            threadLRUOtima5Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 6 QUADROS
        quadros = 6;
        Thread threasFIFOSubstituicao6Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao6Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadLRUOtima6Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threasFIFOSubstituicao6Quadros.start();
        threadLRUSubstituicao6Quadros.start();
        threadLRUOtima6Quadros.start();

        try {
            threasFIFOSubstituicao6Quadros.join();
            threadLRUSubstituicao6Quadros.join();
            threadLRUOtima6Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

//      SUBSTITUICAO COM 7 QUADROS
        quadros = 7;
        Thread threasFIFOSubstituicao7Quadros = new Thread(new SubstituicaoPaginaFIFO(paginas, paginas.length, quadros));
        Thread threadLRUSubstituicao7Quadros =  new Thread(new SubstituicaoPaginaLRU(paginas, paginas.length, quadros));
        Thread threadLRUOtima7Quadros =  new Thread(new SubstituicaoPaginaOtima(paginas, paginas.length, quadros));

        threasFIFOSubstituicao7Quadros.start();
        threadLRUSubstituicao7Quadros.start();
        threadLRUOtima7Quadros.start();

        try {
            threasFIFOSubstituicao7Quadros.join();
            threadLRUSubstituicao7Quadros.join();
            threadLRUOtima7Quadros.join();
        } catch (InterruptedException error) {
            error.getStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");

    }
}