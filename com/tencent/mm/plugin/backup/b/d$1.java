package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.HashMap;

class d$1 implements Runnable {
    final /* synthetic */ d gTg;

    d$1(d dVar) {
        this.gTg = dVar;
    }

    public final void run() {
        e.reset();
        e.arp();
        d.a(this.gTg).begin();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : d.b(this.gTg).keySet()) {
            d.arj();
            String str2 = g.wt(str) + str;
            if (b.chp()) {
                d.a(this.gTg, str2, hashMap, hashMap2);
                if (d.c(this.gTg)) {
                    x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", new Object[]{str, Integer.valueOf(d.d(this.gTg).size()), Integer.valueOf(d.e(this.gTg))});
                    d.ark();
                    d.a(this.gTg).end();
                    c.l(hashMap);
                    d.a(this.gTg, d.f(this.gTg), d.g(this.gTg));
                    return;
                }
            }
            try {
                d.a(this.gTg, str2, hashMap, hashMap2);
                if (d.c(this.gTg)) {
                    x.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferSessions size[%d], recovering session num[%d]", new Object[]{str, Integer.valueOf(d.d(this.gTg).size()), Integer.valueOf(d.e(this.gTg))});
                    d.ark();
                    d.a(this.gTg).end();
                    c.l(hashMap);
                    d.a(this.gTg, d.f(this.gTg), d.g(this.gTg));
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupRecoverMerger", e, "recoverFromSdcard MMThread.run():", new Object[0]);
            }
            d.d(this.gTg).add(d.b(this.gTg).get(str));
            d.h(this.gTg).aqP().D(26, d.d(this.gTg).size() > d.e(this.gTg) ? d.e(this.gTg) : d.d(this.gTg).size(), d.e(this.gTg));
            this.gTg.my(26);
            d.a(this.gTg).arn();
            d.ark();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e2) {
            }
            x.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferSessions size[%d]", new Object[]{str, Integer.valueOf(d.d(this.gTg).size())});
        }
        c.l(hashMap);
        x.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferSession:%s totalSession:%d", new Object[]{Integer.valueOf(d.d(this.gTg).size()), Integer.valueOf(d.e(this.gTg))});
        d.a(this.gTg).end();
        if (b.chp()) {
            d.h(this.gTg).aqP().gRD = d.d(this.gTg).size() > d.e(this.gTg) ? d.e(this.gTg) : d.d(this.gTg).size();
        } else {
            d.h(this.gTg).aqP().gRD = d.e(this.gTg);
        }
        d.h(this.gTg).aqP().gRE = d.e(this.gTg);
        x.chR();
        if (d.i(this.gTg) != d.arl()) {
            d.a(this.gTg, d.arl());
            d.ari();
            x.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
            if (d.j(this.gTg) == 1) {
                au.HU();
                com.tencent.mm.model.c.DT().a(a.sVa, Boolean.valueOf(false));
            } else if (d.j(this.gTg) == 2) {
                au.HU();
                com.tencent.mm.model.c.DT().a(a.sVd, Boolean.valueOf(false));
            }
            if (d.k(this.gTg) != null) {
                d.k(this.gTg).aqO();
            }
            au.HU().Gz().ckt();
            au.HU().GA().ckt();
            d.h(this.gTg).aqP().D(27, d.d(this.gTg).size() > d.e(this.gTg) ? d.e(this.gTg) : d.d(this.gTg).size(), d.e(this.gTg));
            this.gTg.my(27);
            d.a(this.gTg, d.arm());
            d.l(this.gTg);
            d.h(this.gTg).aqR();
        }
    }
}
