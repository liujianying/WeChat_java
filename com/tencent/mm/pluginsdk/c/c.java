package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class c<T extends b> extends com.tencent.mm.sdk.b.c<T> implements e {
    private static HashMap<b, c<? extends b>> dRX = new HashMap();
    private static HashMap<l, b> qyx = new HashMap();
    private int qyw = 0;

    public abstract b a(int i, l lVar, T t);

    public abstract int aAu();

    public abstract l b(T t);

    public final void a(int i, int i2, String str, l lVar) {
        if (aAu() == lVar.getType()) {
            b bVar = (b) qyx.remove(lVar);
            if (bVar != null) {
                kb kbVar = new kb();
                kbVar.bUq.bUr = a(i2, lVar, bVar);
                kbVar.bUq.errType = i;
                kbVar.bUq.errCode = i2;
                kbVar.bUq.Yy = str;
                a.sFg.m(kbVar);
            }
        }
    }

    public static void k(b bVar) {
        l lVar;
        for (Entry entry : qyx.entrySet()) {
            if (entry.getValue() == bVar) {
                lVar = (l) entry.getKey();
                break;
            }
        }
        lVar = null;
        if (lVar != null) {
            g.DF().c(lVar);
            qyx.remove(lVar);
        }
    }

    public final void cbp() {
        if (this.qyw == 0) {
            g.DF().a(aAu(), this);
        }
        this.qyw++;
    }

    public final void aYG() {
        if (this.qyw != 0) {
            this.qyw--;
            if (this.qyw == 0) {
                g.DF().b(aAu(), this);
            }
        }
    }

    public final void l(T t) {
        l b = b(t);
        g.DF().a(b, 0);
        qyx.put(b, t);
    }
}
