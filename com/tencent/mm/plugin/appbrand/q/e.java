package com.tencent.mm.plugin.appbrand.q;

import java.util.List;

public final class e {
    public static <L extends List<T>, T> L d(L l, List<T> list) {
        if (list != null) {
            l.addAll(list);
        }
        return l;
    }
}
