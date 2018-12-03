package com.b.pls.q.impl;

import com.pls.q.Search;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * @author Piers
 * @date 2018/12/3 20:26
 **/
public class DbSearch implements Search<String, String> {
    @Override
    public List<String> search(String condition) {
        if (StringUtils.isBlank(condition)) {
            return new ArrayList<>(1);
        }

        return new ArrayList<String>(1) {{
            add("Hello " + condition);
        }};
    }
}
