package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class k$3 implements a {
    final /* synthetic */ k dZT;
    private int dZV = 0;
    private long dZW = 0;
    private int dZX = 0;

    k$3(k kVar) {
        this.dZT = kVar;
    }

    public final boolean vD() {
        c cVar = new c();
        if (!g.Eg().Dx()) {
            x.e(k.b(this.dZT), "syncRespHandler acc is not ready STOP :%s", new Object[]{k.c(this.dZT)});
            k.d(this.dZT);
            return false;
        } else if (k.e(this.dZT)) {
            cVar.bF(this.dZT);
            k.d(this.dZT);
            return false;
        } else if (k.c(this.dZT) == null || k.c(this.dZT).qWX.rnB == null || k.c(this.dZT).qWX.rnB.hbG == null) {
            x.e(k.b(this.dZT), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[]{k.c(this.dZT)});
            cVar.bF(this.dZT);
            k.d(this.dZT);
            return false;
        } else {
            LinkedList linkedList = k.c(this.dZT).qWX.rnB.hbG;
            cVar.bD(this.dZT);
            this.dZX++;
            long VF = bi.VF();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 5) {
                    if (this.dZV < linkedList.size()) {
                        x.v(k.b(this.dZT), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.dZV), Integer.valueOf(linkedList.size()), Integer.valueOf(((pm) linkedList.get(this.dZV)).rtM), Integer.valueOf(((pm) linkedList.get(this.dZV)).rtN.siI)});
                        linkedList.size();
                        if (!cVar.a((pm) linkedList.get(this.dZV), false)) {
                            x.w(k.b(this.dZT), "DoCmd Failed index:%d", new Object[]{Integer.valueOf(this.dZV)});
                        }
                        this.dZV++;
                    }
                    if (this.dZV >= linkedList.size()) {
                        this.dZW += bi.bH(VF);
                        x.i(k.b(this.dZT), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[]{Integer.valueOf(this.dZV), Integer.valueOf(linkedList.size()), Long.valueOf(bi.bH(k.f(this.dZT))), Long.valueOf(this.dZW), Integer.valueOf(this.dZX), k.c(this.dZT)});
                        this.dZT.a(k.c(this.dZT));
                        cVar.bE(this.dZT);
                        f.mDy.a(99, (long) bi.f((Integer) f.a((int) this.dZW, new int[]{100, h.CTRL_INDEX, 1000, 3000}, new Integer[]{Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(bc.CTRL_BYTE), Integer.valueOf(237), Integer.valueOf(236)})), 1, false);
                        f.mDy.a(99, (long) bi.f((Integer) f.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(aq.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243)})), 1, false);
                        f.mDy.a(99, b.foreground ? 241 : 242, 1, false);
                        f.mDy.a(99, (long) k.g(this.dZT), 1, false);
                        f.mDy.a(99, 0, 1, false);
                        f fVar = f.mDy;
                        Object[] objArr = new Object[8];
                        objArr[0] = Integer.valueOf(linkedList.size());
                        objArr[1] = Long.valueOf(r10);
                        objArr[2] = Integer.valueOf(k.g(this.dZT));
                        objArr[3] = Integer.valueOf(k.c(this.dZT).qWX.rlm);
                        objArr[4] = Long.valueOf(this.dZW);
                        objArr[5] = Integer.valueOf(this.dZX);
                        objArr[6] = k.h(this.dZT);
                        objArr[7] = Integer.valueOf(b.foreground ? 1 : 2);
                        fVar.h(12063, objArr);
                        k.d(this.dZT);
                        return false;
                    }
                    if (bi.bH(VF) > 500) {
                        x.d(k.b(this.dZT), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(i2), Integer.valueOf(this.dZV), k.c(this.dZT)});
                        this.dZW += bi.bH(VF);
                        return true;
                    }
                    i = i2 + 1;
                } else {
                    this.dZW += bi.bH(VF);
                    return true;
                }
            }
        }
    }
}
