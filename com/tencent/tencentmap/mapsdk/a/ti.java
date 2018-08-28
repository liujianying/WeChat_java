package com.tencent.tencentmap.mapsdk.a;

import java.util.Map;
import java.util.WeakHashMap;

public final class ti {
    private static Map<tc$a, rh> a = new WeakHashMap();

    public static rh a(sl slVar, tc$a tc_a) {
        int i = slVar.f().a() > 1 ? 2 : 1;
        rh rhVar = (rh) a.get(tc_a);
        if (rhVar != null) {
            return rhVar;
        }
        switch (1.a[tc_a.ordinal()]) {
            case 1:
                rhVar = new tk(i);
                break;
            case 2:
                rhVar = new tm(i);
                break;
            case 3:
                rhVar = new tj(i);
                break;
            case 4:
                rhVar = new tl(i);
                break;
            default:
                return null;
        }
        a.put(tc_a, rhVar);
        return rhVar;
    }
}
