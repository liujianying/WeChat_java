package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.mm.modelappbrand.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<a>> dmH = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> fvH = new ConcurrentHashMap();

    public static DebuggerInfo sD(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (DebuggerInfo) fvH.get(str);
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        if (str != null && str.length() != 0) {
            fvH.put(str, debuggerInfo);
        }
    }

    public static boolean c(String str, a aVar) {
        if (bi.oW(str) || aVar == null) {
            return false;
        }
        List list = (List) dmH.get(str);
        if (list == null) {
            list = new LinkedList();
            dmH.put(str, list);
        } else if (list.contains(aVar)) {
            return true;
        }
        return list.add(aVar);
    }

    public static boolean d(String str, a aVar) {
        if (bi.oW(str) || aVar == null) {
            return false;
        }
        List list = (List) dmH.get(str);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            dmH.remove(str);
        }
        return remove;
    }

    public static void C(String str, int i) {
        if (!bi.oW(str)) {
            List list = (List) dmH.get(str);
            if (list != null) {
                for (a hp : new LinkedList(list)) {
                    hp.hp(i);
                }
            }
        }
    }
}
