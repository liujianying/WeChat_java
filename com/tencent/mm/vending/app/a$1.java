package com.tencent.mm.vending.app;

import com.tencent.mm.vending.base.a;

class a$1 extends a<Object> {
    final /* synthetic */ a uPO;

    a$1(a aVar) {
        this.uPO = aVar;
    }

    /* renamed from: R */
    protected final Object resolveAsynchronous(Class<?> cls) {
        a$a a_a = (a$a) this.uPO.uPH.get(cls);
        if (a_a != null) {
            a_a.uPQ = true;
            Object Wd = a_a.Wd();
            a_a.uPQ = false;
            if (!a_a.uPP) {
                return Wd;
            }
            a_a.uPR = defer(cls);
        }
        return null;
    }
}
