package com.pls.q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/***
 * @author Piers
 * @date 2018/12/2 17:52
 **/
public class SearchManager {
    static List<Search> searchList = new ArrayList<>(8);

    static {
        ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);
        Iterator<Search> searchIterator = serviceLoader.iterator();

        while (searchIterator.hasNext()) {
            searchList.add(searchIterator.next());
        }
    }

    public static <T, R>List<R> searh(T condition) {
        if (searchList.isEmpty()) {
            return new ArrayList<>(1);
        }

        Search<T, R> search = searchList.get(0);
        return search.search(condition);
    }
}
