package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.base.a;
import java.util.HashSet;
import java.util.Set;

public final class s {
    private static final Set<b> fgr = new HashSet();

    public interface b {
        a a(a aVar);
    }

    public static void a(b bVar) {
        synchronized (fgr) {
            fgr.add(bVar);
        }
    }

    static a a(a aVar) {
        synchronized (fgr) {
        }
        for (Object obj : fgr.toArray()) {
            a a = ((b) obj).a(aVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
