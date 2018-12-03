package com.pls.q.impl;

import com.pls.q.Search;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author Piers
 * @date 2018/12/2 17:37
 **/
public class FileSearch implements Search<String, String> {
    private final static List<String> TEXT_LIST = new ArrayList<>(16);

    static {
        TEXT_LIST.add("Apple");
        TEXT_LIST.add("Button");
        TEXT_LIST.add("Cycle");
        TEXT_LIST.add("Door");
        TEXT_LIST.add("Egg");
        TEXT_LIST.add("Fine");
        TEXT_LIST.add("Good");
    }

    @Override
    public List<String> search(String condition) {
        if (TEXT_LIST.isEmpty() || StringUtils.isBlank(condition)) {
            return new ArrayList<String>() {{
                add("no data found");
            }};
        }

        return TEXT_LIST.stream().filter(str ->
                StringUtils.indexOfIgnoreCase(str, condition) > -1
        ).collect(Collectors.toList());
    }
}
