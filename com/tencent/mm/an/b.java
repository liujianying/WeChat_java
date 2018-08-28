package com.tencent.mm.an;

import com.tencent.mm.g.a.js;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public final class b {

    /* renamed from: com.tencent.mm.an.b$7 */
    static class AnonymousClass7 implements Runnable {
        final /* synthetic */ List ebc;
        final /* synthetic */ int ebd;

        public AnonymousClass7(List list, int i) {
            this.ebc = list;
            this.ebd = i;
        }

        public final void run() {
            js jsVar = new js();
            jsVar.bTw.action = 0;
            jsVar.bTw.bPa = this.ebc;
            jsVar.bTw.bTz = this.ebd;
            a.sFg.m(jsVar);
        }
    }

    public static final void yL() {
        ah.A(new 1());
    }

    public static final void yM() {
        ah.A(new 2());
    }

    public static final void PW() {
        ah.A(new 3());
    }

    public static final void PX() {
        ah.A(new 4());
    }

    public static final void a(avq avq) {
        ah.A(new 5(avq));
    }

    public static boolean PY() {
        js jsVar = new js();
        jsVar.bTw.action = -3;
        a.sFg.m(jsVar);
        return jsVar.bTx.bGZ;
    }

    public static boolean PZ() {
        js jsVar = new js();
        jsVar.bTw.action = 9;
        a.sFg.m(jsVar);
        return jsVar.bTx.bGZ;
    }

    public static avq Qa() {
        js jsVar = new js();
        jsVar.bTw.action = -2;
        a.sFg.m(jsVar);
        return jsVar.bTx.bTy;
    }

    public static void b(avq avq) {
        ah.A(new 6(avq));
    }

    public static void c(avq avq) {
        ah.A(new 8(avq));
    }

    public static boolean d(avq avq) {
        if (avq == null) {
            return false;
        }
        switch (avq.rYj) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean if(int i) {
        js jsVar = new js();
        jsVar.bTw.action = 7;
        jsVar.bTw.position = i;
        a.sFg.m(jsVar);
        return jsVar.bTx.bGZ;
    }

    public static d Qb() {
        js jsVar = new js();
        jsVar.bTw.action = 8;
        a.sFg.m(jsVar);
        return jsVar.bTx.bTC;
    }
}
