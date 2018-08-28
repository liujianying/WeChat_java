package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class g$b implements Runnable {
    private int kGn;
    private int kGo;
    final /* synthetic */ g qSF;
    private String[] qSO;
    private String qSP;
    private String url;

    private g$b(g gVar) {
        this.qSF = gVar;
    }

    /* synthetic */ g$b(g gVar, byte b) {
        this(gVar);
    }

    private Bitmap Ub(String str) {
        if (str == null) {
            return null;
        }
        if (this.kGo <= 0 || this.kGn <= 0) {
            return y.oQ(str);
        }
        String str2 = str + "_" + this.kGn + "_" + this.kGo;
        Bitmap o = y.o(str2, this.kGn, this.kGo);
        if (o != null) {
            return o;
        }
        int VX = ExifHelper.VX(str);
        if (90 == VX || 270 == VX) {
            o = c.e(str, this.kGn, this.kGo, true);
        } else {
            o = c.e(str, this.kGo, this.kGn, true);
        }
        if (o == null) {
            return o;
        }
        o = c.b(o, (float) VX);
        try {
            c.a(o, 100, CompressFormat.PNG, str2, false);
            return o;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
            return o;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r6 = this;
        r2 = 0;
        r0 = r6.qSF;
        r0 = r0.qSu;
        if (r0 == 0) goto L_0x0011;
    L_0x0007:
        r0 = "MicroMsg.ImageEngine";
        r1 = "on load image jog, isQuit, return";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r6.qSF;
        r1 = r0.dsN;
        monitor-enter(r1);
        r0 = r6.qSF;	 Catch:{ all -> 0x0035 }
        r0 = r0.qSx;	 Catch:{ all -> 0x0035 }
        r3 = r6.qSP;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0038;
    L_0x0022:
        r0 = "MicroMsg.ImageEngine";
        r2 = "check before decode, no match wait to render view, renderKey is %s, return";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0035 }
        r4 = 0;
        r5 = r6.qSP;	 Catch:{ all -> 0x0035 }
        r3[r4] = r5;	 Catch:{ all -> 0x0035 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r2, r3);	 Catch:{ all -> 0x0035 }
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        r1 = r6.qSO;
        if (r1 == 0) goto L_0x0059;
    L_0x003e:
        r1 = r2;
    L_0x003f:
        r3 = r6.qSO;
        r3 = r3.length;
        if (r1 >= r3) goto L_0x0059;
    L_0x0044:
        if (r1 != 0) goto L_0x00c5;
    L_0x0046:
        r0 = r6.qSO;
        r0 = r0[r2];
        r0 = r6.Ub(r0);
        if (r0 == 0) goto L_0x00f2;
    L_0x0050:
        r1 = r6.qSF;
        r1 = r1.qSz;
        r2 = r6.qSP;
        r1.put(r2, r0);
    L_0x0059:
        if (r0 != 0) goto L_0x0080;
    L_0x005b:
        r1 = r6.url;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0080;
    L_0x0063:
        r0 = r6.qSF;
        r1 = r6.qSP;
        r2 = r6.url;
        r3 = r6.kGn;
        r4 = r6.kGo;
        r0 = r0.h(r1, r2, r3, r4);
        r0 = com.tencent.mm.platformtools.y.a(r0);
        if (r0 == 0) goto L_0x0080;
    L_0x0077:
        r1 = r6.qSF;
        r1 = r1.qSz;
        r2 = r6.qSP;
        r1.put(r2, r0);
    L_0x0080:
        r2 = r0;
        if (r2 == 0) goto L_0x00bc;
    L_0x0083:
        r0 = r6.qSF;
        r3 = r0.dsN;
        monitor-enter(r3);
        r0 = r6.qSF;	 Catch:{ all -> 0x00f6 }
        r0 = r0.qSx;	 Catch:{ all -> 0x00f6 }
        r1 = r6.qSP;	 Catch:{ all -> 0x00f6 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x00f6 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x00f6 }
        if (r0 == 0) goto L_0x00b2;
    L_0x0096:
        r1 = r6.qSF;	 Catch:{ all -> 0x00f6 }
        r1 = r1.qSy;	 Catch:{ all -> 0x00f6 }
        r1.remove(r0);	 Catch:{ all -> 0x00f6 }
        r1 = r6.qSF;	 Catch:{ all -> 0x00f6 }
        r1 = r1.qSB;	 Catch:{ all -> 0x00f6 }
        r1 = r1.cfq();	 Catch:{ all -> 0x00f6 }
        r1 = (com.tencent.mm.pluginsdk.ui.tools.g.e) r1;	 Catch:{ all -> 0x00f6 }
        r1.bOA = r0;	 Catch:{ all -> 0x00f6 }
        r1.jDx = r2;	 Catch:{ all -> 0x00f6 }
        r0 = r6.qSF;	 Catch:{ all -> 0x00f6 }
        r0 = r0.dvh;	 Catch:{ all -> 0x00f6 }
        r0.post(r1);	 Catch:{ all -> 0x00f6 }
    L_0x00b2:
        r0 = r6.qSF;	 Catch:{ all -> 0x00f6 }
        r0 = r0.qSx;	 Catch:{ all -> 0x00f6 }
        r1 = r6.qSP;	 Catch:{ all -> 0x00f6 }
        r0.remove(r1);	 Catch:{ all -> 0x00f6 }
        monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
    L_0x00bc:
        r0 = r6.qSF;
        r0 = r0.qSC;
        r0.C(r6);
        goto L_0x0010;
    L_0x00c5:
        r0 = r6.qSO;
        r0 = r0[r1];
        r3 = r6.url;
        r4 = r6.kGn;
        r5 = r6.kGo;
        r3 = com.tencent.mm.pluginsdk.ui.tools.g.n(r0, r3, r4, r5);
        r0 = r6.qSF;
        r0 = r0.qSz;
        r0 = r0.get(r3);
        r0 = (android.graphics.Bitmap) r0;
        if (r0 != 0) goto L_0x00e7;
    L_0x00df:
        r0 = r6.qSO;
        r0 = r0[r1];
        r0 = r6.Ub(r0);
    L_0x00e7:
        if (r0 == 0) goto L_0x00f2;
    L_0x00e9:
        r1 = r6.qSF;
        r1 = r1.qSz;
        r1.put(r3, r0);
        goto L_0x0059;
    L_0x00f2:
        r1 = r1 + 1;
        goto L_0x003f;
    L_0x00f6:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.g$b.run():void");
    }
}
