package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ui.chatting.b.a.a;
import java.util.LinkedList;
import java.util.List;

public final class g {
    private static Class[] tOL = new Class[]{s.class, q.class, c.class, al.class, f.class, ak.class, aa.class, ai.class, o.class, e.class, ag.class, y.class, ao.class, j.class, t.class, r.class, k.class, an.class, ad.class, x.class, aj.class, b.class, ae.class, w.class, m.class, ab.class, af.class, n.class, ah.class, am.class, ac.class, z.class, p.class, d.class};
    private static List<a> tOM;

    public static List<a> cuN() {
        if (tOM == null) {
            tOM = new LinkedList();
            for (Class cls : tOL) {
                if (cls.isAnnotationPresent(a.class)) {
                    a aVar = (a) cls.getAnnotation(a.class);
                    if (aVar.cwo() == a.a.class) {
                        tOM.add(new a(cls, cls));
                    } else {
                        tOM.add(new a(aVar.cwo(), cls));
                    }
                } else {
                    tOM.add(new a(cls, cls));
                }
            }
        }
        return tOM;
    }
}
