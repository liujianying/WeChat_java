package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.c;
import java.util.Comparator;

class n$c$1 implements Comparator<Runnable> {
    n$c$1() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int random;
        Runnable runnable = (Runnable) obj;
        Runnable runnable2 = (Runnable) obj2;
        if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).qCX instanceof l) && (((c) runnable2).qCX instanceof l)) {
            l lVar = (l) ((c) runnable).qCX;
            l lVar2 = (l) ((c) runnable2).qCX;
            int i = lVar.priority - lVar2.priority;
            random = (lVar.ccs() && lVar2.ccs()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
        } else {
            random = 0;
        }
        return 0 - random;
    }
}
