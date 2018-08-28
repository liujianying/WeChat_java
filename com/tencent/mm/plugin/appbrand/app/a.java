package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.a.d.b;
import com.tencent.mm.plugin.appbrand.appcache.a.d.e;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.launching.h;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

final class a {
    static final Map<a, String[]> fep = new HashMap();
    private static final Map<Class, Object> feq = new HashMap();

    private static void a(a aVar, String[] strArr) {
        fep.put(aVar, strArr);
    }

    static {
        a(new 1(), h.dzV);
        a(new 3(), w.dzV);
        a(new 4(), g.dzV);
        a(new 5(), e.dzV);
        a(new 6(), aa.dzV);
        a(new 7(), d.dzV);
        a(new 8(), com.tencent.mm.plugin.appbrand.appcache.a.d.h.dzV);
        a(new 9(), com.tencent.mm.plugin.appbrand.appcache.a.d.d.dzV);
        a(new a<y>() {
            public final /* synthetic */ Object b(com.tencent.mm.sdk.e.e eVar) {
                return new y(eVar);
            }
        }, y.dzV);
        a(new a<b>() {
            public final /* synthetic */ Object b(com.tencent.mm.sdk.e.e eVar) {
                return new b(eVar);
            }
        }, b.dzV);
    }

    static void a(com.tencent.mm.sdk.e.e eVar) {
        synchronized (feq) {
            feq.clear();
            for (a b : fep.keySet()) {
                Object b2 = b.b(eVar);
                feq.put(b2.getClass(), b2);
            }
        }
    }

    static void aaP() {
        synchronized (feq) {
            feq.clear();
        }
    }

    static <T> T x(Class<T> cls) {
        T t;
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (feq) {
            t = feq.get(cls);
        }
        return t;
    }
}
