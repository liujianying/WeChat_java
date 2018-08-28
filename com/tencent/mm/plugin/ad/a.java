package com.tencent.mm.plugin.ad;

import com.tencent.mm.model.p;
import com.tencent.mm.modelcontrol.c;

public final class a extends p {
    private static a lQG;

    public static synchronized a bmE() {
        a aVar;
        synchronized (a.class) {
            if (lQG == null) {
                lQG = new a();
            }
            aVar = lQG;
        }
        return aVar;
    }

    private a() {
        super(c.class);
    }
}
