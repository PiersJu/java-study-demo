package com.pls.q;

import java.util.List;

/***
 * @author Piers
 * @date 2018/12/2 17:34
 **/
public interface Search<T, R> {
    List<R> search(T condition);
}
