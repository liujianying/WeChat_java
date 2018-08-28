package com.tencent.mm.model;

import com.tencent.mm.compatible.util.k;

@Deprecated
public class bs {
    static {
        k.b("txmapengine", bs.class.getClassLoader());
    }

    public final synchronized boolean a(String str, ar arVar) {
        p gP = p.gP(str);
        if (gP == null) {
            gP = p.a(str, new p(arVar.getClass()));
        }
        gP.a(arVar);
        return true;
    }

    public static ar iK(String str) {
        p gP = p.gP(str);
        if (gP == null) {
            return null;
        }
        return gP.GC();
    }
}
