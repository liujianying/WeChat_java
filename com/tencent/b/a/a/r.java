package com.tencent.b.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    private static r bvR = null;
    private Map<Integer, q> bvP;
    private int bvQ;

    private r(Context context) {
        this.bvP = null;
        this.bvQ = 0;
        this.bvP = new HashMap(3);
        this.bvP.put(Integer.valueOf(1), new o(context));
        this.bvP.put(Integer.valueOf(2), new d(context));
        this.bvP.put(Integer.valueOf(4), new k(context));
    }

    static synchronized r aH(Context context) {
        r rVar;
        synchronized (r.class) {
            if (bvR == null) {
                bvR = new r(context);
            }
            rVar = bvR;
        }
        return rVar;
    }

    final g tT() {
        return z(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    final g z(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = (q) this.bvP.get(num);
                if (qVar != null) {
                    g tT = qVar.tT();
                    if (tT != null && s.cj(tT.bvx)) {
                        return tT;
                    }
                }
            }
        }
        return new g();
    }

    final a tU() {
        return A(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    private a A(List<Integer> list) {
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = (q) this.bvP.get(num);
                if (qVar != null) {
                    a tU = qVar.tU();
                    if (tU != null) {
                        return tU;
                    }
                }
            }
        }
        return new a();
    }

    final void b(a aVar) {
        for (Entry value : this.bvP.entrySet()) {
            ((q) value.getValue()).b(aVar);
        }
    }

    final void b(g gVar) {
        for (Entry value : this.bvP.entrySet()) {
            ((q) value.getValue()).b(gVar);
        }
    }
}
