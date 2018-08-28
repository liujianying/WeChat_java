package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bg {
    private static Map<bb, bd> a = new ConcurrentHashMap();

    public static bd a(bb bbVar) {
        bd bdVar = (bd) a.get(bbVar);
        if (bdVar != null) {
            return bdVar;
        }
        bdVar = new bd();
        a.put(bbVar, bdVar);
        return bdVar;
    }

    public static boolean a(bb bbVar, be beVar) {
        boolean z = true;
        bd a = a(bbVar);
        if (!a.a()) {
            if (a.b() + ((long) (beVar.c().taf_try_time_interval() * 1000)) < Millis100TimeProvider.INSTANCE.currentTimeMillis()) {
                a.a(Millis100TimeProvider.INSTANCE.currentTimeMillis());
            } else {
                z = false;
            }
            beVar.c();
        }
        return z;
    }

    public static void a(be beVar, bb bbVar, int i) {
        a(bbVar).a(beVar, bbVar, i);
    }
}
