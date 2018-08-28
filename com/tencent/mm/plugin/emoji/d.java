package com.tencent.mm.plugin.emoji;

import com.tencent.mm.aj.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends p implements b {
    private static d icO;

    private d() {
        super(a.class);
    }

    public static synchronized d aDh() {
        d dVar;
        synchronized (d.class) {
            if (icO == null) {
                icO = new d();
            }
            dVar = icO;
        }
        return dVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"emoji/"});
        return linkedList;
    }

    public static String aDi() {
        return g.Ei().dqp + "emoji/";
    }
}
