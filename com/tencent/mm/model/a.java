package com.tencent.mm.model;

import com.tencent.mm.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public byte[] dzX;
    public long dzY = -1;

    public final int FI() {
        return this.dzX == null ? -1 : this.dzX.length;
    }

    public a() {
        if (FJ()) {
            ah.i(new Runnable() {
                public final void run() {
                    try {
                        if (a.FJ()) {
                            f.mDy.a(226, 1, 1, false);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", bi.i(e));
                    }
                }
            }, 5000);
        }
    }

    public static boolean FJ() {
        if (com.tencent.mm.kernel.a.Dr() || !g.Eg().Dx()) {
            return false;
        }
        int i = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("AndroidUseWorkerAuthCache"), 0);
        g.Ek();
        g.Eg();
        int aM = h.aM(com.tencent.mm.kernel.a.Df(), 100);
        boolean chp = b.chp();
        r7 = new Object[5];
        g.Ek();
        g.Eg();
        r7[2] = Integer.valueOf(com.tencent.mm.kernel.a.Df());
        r7[3] = Integer.valueOf(aM);
        r7[4] = Boolean.valueOf(g.Eg().Dx());
        x.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (chp) {
            return true;
        }
        if (i > aM) {
            return true;
        }
        return false;
    }

    public static void FK() {
        if (FJ()) {
            try {
                g.Ek();
                a aVar = g.Eg().dps;
                g.Ek();
                c Lr = g.Eh().dpP.dJs.Lr();
                long VF = bi.VF();
                if (Lr == null) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    f.mDy.a(226, 2, 1, false);
                    return;
                }
                x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(Lr.Ln()), Integer.valueOf(aVar.FI()));
                if (Lr.Ln()) {
                    aVar.dzX = Lr.Lq();
                    f.mDy.a(226, aVar.FI() > 0 ? 4 : 5, 1, false);
                    x.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(bi.bH(VF)), Integer.valueOf(aVar.FI()), Long.valueOf(aVar.dzY));
                    if (aVar.FI() > 0) {
                        f.mDy.a(226, 31 - (aVar.dzY > 5 ? 5 : aVar.dzY), 1, false);
                        f.mDy.h(11098, Integer.valueOf(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.dzY));
                        aVar.dzY = -1;
                        return;
                    }
                    return;
                }
                f.mDy.a(226, 3, 1, false);
                x.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
            } catch (Throwable th) {
                x.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bi.i(th));
            }
        }
    }
}
