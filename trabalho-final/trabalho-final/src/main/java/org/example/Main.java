package org.example;

import org.example.page_replacement.FifoPageReplacement;
import org.example.page_replacement.LRUPageReplacement;
import org.example.page_replacement.OptimalPageReplacement;

public class Main {


    public static void main(String[] args) {

        int pages[] = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 6};

        int capacity = 7;

        System.out.println(FifoPageReplacement.pageFaults(pages, pages.length, capacity));
        System.out.println(LRUPageReplacement.pageFaults(pages, pages.length, capacity));
        System.out.println(OptimalPageReplacement.pageFaults(pages, pages.length, capacity));
    }
}