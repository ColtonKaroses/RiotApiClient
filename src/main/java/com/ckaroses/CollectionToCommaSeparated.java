package com.ckaroses;

import feign.Param;

import java.util.Collection;
import java.util.List;

/**
 * Created by Colton on 3/15/2015.
 */
public class CollectionToCommaSeparated implements Param.Expander {
    @Override
    public String expand(Object value) {
        if (!(value instanceof Collection)) {
            throw new RuntimeException("Type of Object passed in is not List.");
        }

        List list = (List) value;
        StringBuilder builder = new StringBuilder();
        for (Object o : list) {
            builder.append(o.toString()).append(",");
        }

        return builder.toString();
    }
}
