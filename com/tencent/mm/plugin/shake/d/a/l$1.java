package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.a.a;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class l$1 implements a {
    final /* synthetic */ l mYW;

    l$1(l lVar) {
        this.mYW = lVar;
    }

    public final void b(bhp bhp, long j, boolean z) {
        long currentTimeMillis;
        x.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", new Object[]{Boolean.valueOf(z)});
        if (j > l.a(this.mYW)) {
            currentTimeMillis = System.currentTimeMillis() - j;
        } else {
            currentTimeMillis = System.currentTimeMillis() - l.a(this.mYW);
        }
        if (bhp != null && !bi.oW(((bms) bhp).rjF)) {
            boolean a;
            bms bms = (bms) bhp;
            x.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(bms.hcE), bms.rjF});
            String str = null;
            String str2 = null;
            if (bms.rjF != null) {
                bms.rjF = bms.rjF.trim();
                int indexOf = bms.rjF.indexOf("<tvinfo>");
                if (indexOf > 0) {
                    str = bms.rjF.substring(0, indexOf);
                    str2 = bms.rjF.substring(indexOf);
                } else if (indexOf == 0) {
                    str2 = bms.rjF;
                } else {
                    str = bms.rjF;
                }
            }
            l.Lc(str2);
            switch (bms.hcE) {
                case 0:
                    a = l.a(this.mYW, str);
                    break;
                case 1:
                    a = l.b(this.mYW, str);
                    break;
                case 2:
                    a = l.c(this.mYW, str);
                    break;
                case 3:
                    a = l.d(this.mYW, str);
                    break;
                case 4:
                    a = l.e(this.mYW, str);
                    break;
                case 5:
                    a = l.f(this.mYW, str);
                    break;
                case 6:
                    a = l.g(this.mYW, str);
                    break;
                default:
                    x.w("Micromsg.ShakeTVService", "parse unknown type:" + bms.hcE);
                    l.a(this.mYW, new ArrayList());
                    a = false;
                    break;
            }
            if (a) {
                h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - l.a(this.mYW)))});
                h.mEJ.e(835, 0, 1);
            } else {
                h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                h.mEJ.e(835, 4, 1);
            }
        } else if (z) {
            l.a(this.mYW, new ArrayList());
            h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
            h.mEJ.e(835, 3, 1);
        } else {
            l.a(this.mYW, new ArrayList());
            h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
            h.mEJ.e(835, 2, 1);
        }
        l.bvh();
    }
}
