package com.tencent.mm.plugin;

import com.tencent.mm.model.p;
import com.tencent.mm.modelstat.q;

public final class a extends p {
    private static a ezm;

    public static synchronized a VO() {
        a aVar;
        synchronized (a.class) {
            if (ezm == null) {
                ezm = new a();
            }
            aVar = ezm;
        }
        return aVar;
    }

    private a() {
        super(q.class);
    }
}
