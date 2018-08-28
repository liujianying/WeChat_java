package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class e {
    private static Map<String, a> fbV = new HashMap();
    private static Map<String, c> fbW = new HashMap();
    private static Map<String, Set<b>> fbX = new ConcurrentHashMap();

    public static void a(String str, b bVar) {
        if (str != null && bVar != null) {
            if (!fbX.containsKey(str)) {
                fbX.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
            }
            ((Set) fbX.get(str)).add(bVar);
        }
    }

    private static Iterator<b> qf(String str) {
        Object str2;
        Map map = fbX;
        if (str2 == null) {
            str2 = "";
        }
        Set set = (Set) map.get(str2);
        if (set == null) {
            set = new HashSet();
        }
        return set.iterator();
    }

    public static void qg(String str) {
        Iterator qf = qf(str);
        while (qf.hasNext()) {
            ((b) qf.next()).onCreate();
        }
    }

    public static void qh(String str) {
        Iterator qf = qf(str);
        while (qf.hasNext()) {
            ((b) qf.next()).onDestroy();
        }
    }

    public static void qi(String str) {
        Iterator qf = qf(str);
        while (qf.hasNext()) {
            ((b) qf.next()).a(qn(str));
        }
    }

    public static void qj(String str) {
        Iterator qf = qf(str);
        while (qf.hasNext()) {
            ((b) qf.next()).onResume();
        }
    }

    public static void qk(String str) {
        Iterator qf = qf(str);
        while (qf.hasNext()) {
            qf.next();
        }
    }

    public static void b(String str, b bVar) {
        if (bVar != null) {
            Set set = (Set) fbX.get(str);
            if (set != null && !set.isEmpty()) {
                set.remove(bVar);
            }
        }
    }

    public static void ql(String str) {
        fbX.remove(str);
    }

    public static void qm(String str) {
        a(str, c.fch);
    }

    public static c qn(String str) {
        c cVar = (c) fbW.get(str);
        if (cVar == null) {
            return c.fch;
        }
        return cVar;
    }

    public static void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            fbW.put(str, cVar);
        }
    }

    public static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            fbV.put(str, aVar);
        }
    }

    public static a qo(String str) {
        a aVar = (a) fbV.get(str);
        if (aVar == null) {
            return a.fbY;
        }
        return aVar;
    }
}
