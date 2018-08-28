package com.tencent.mm.plugin.g;

import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a gRi;

    private a() {
        super(q.class);
    }

    public static synchronized a aqH() {
        a aVar;
        synchronized (a.class) {
            if (gRi == null) {
                gRi = new a();
            }
            aVar = gRi;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        return linkedList;
    }

    public static String aqI() {
        return g.Ei().cachePath + "avatar/";
    }
}
