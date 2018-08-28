package com.tencent.mm.plugin.m;

import com.tencent.mm.ar.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a iaY;

    private a() {
        super(r.class);
    }

    public static synchronized a aCO() {
        a aVar;
        synchronized (a.class) {
            if (iaY == null) {
                iaY = new a();
            }
            aVar = iaY;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        return linkedList;
    }

    public static String Gj() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("package/").toString();
    }
}
