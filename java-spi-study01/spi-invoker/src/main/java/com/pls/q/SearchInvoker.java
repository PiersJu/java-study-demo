package com.pls.q;

import java.util.List;

/***
 * @author Piers
 * @date 2018/12/2 18:04
 **/
public class SearchInvoker {
    public static void main(String[] args) {
        List<String> result = SearchManager.searh("a");
        if (result == null || result.isEmpty()) {
            System.out.println("no data found");
        }

        result.forEach(System.out::println);
    }
}
