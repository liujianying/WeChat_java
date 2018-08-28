package com.tencent.mm.plugin.ag;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a implements b, c {
    private static a mtL;

    private a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized a bqO() {
        a aVar;
        synchronized (a.class) {
            if (mtL == null) {
                mtL = new a();
            }
            aVar = mtL;
        }
        return aVar;
    }

    public static String bqP() {
        return g.Ei().dqp + "remark/";
    }
}
