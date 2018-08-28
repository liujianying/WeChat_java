package com.tencent.mm.plugin.ext.provider;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class ExtControlProviderMsg$1 implements Runnable {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ b heb;
    final /* synthetic */ int iKd;
    final /* synthetic */ long iKe;
    final /* synthetic */ ExtControlProviderMsg iKf;

    ExtControlProviderMsg$1(ExtControlProviderMsg extControlProviderMsg, int i, long j, b bVar, String[] strArr) {
        this.iKf = extControlProviderMsg;
        this.iKd = i;
        this.iKe = j;
        this.heb = bVar;
        this.dhB = strArr;
    }

    public final void run() {
        if (this.iKd == 1) {
            com.tencent.mm.plugin.ext.b.aIJ();
            ab da = com.tencent.mm.plugin.ext.b.da(this.iKe);
            if (da == null || ((int) da.dhP) <= 0) {
                this.iKf.pr(3);
                this.heb.countDown();
                return;
            }
            fd fdVar = new fd();
            fdVar.bNn.op = 1;
            fdVar.bNn.username = da.field_username;
            if (a.sFg.m(fdVar)) {
                ExtControlProviderMsg.a(this.iKf, new MatrixCursor(ExtControlProviderMsg.aIZ()));
                if (da == null || ((int) da.dhP) <= 0 || !fdVar.bNo.bJm) {
                    ExtControlProviderMsg.a(this.iKf).addRow(new Object[]{this.dhB[1], Integer.valueOf(2), "0"});
                    this.iKf.pr(3);
                } else {
                    ExtControlProviderMsg.a(this.iKf).addRow(new Object[]{this.dhB[1], Integer.valueOf(1), "0"});
                    this.iKf.pr(0);
                }
                x.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[]{Boolean.valueOf(fdVar.bNo.bJm), fdVar.bNo.fileName});
            } else {
                this.iKf.pr(4);
                this.heb.countDown();
                return;
            }
        } else if (this.iKd == 2) {
            fd fdVar2 = new fd();
            fdVar2.bNn.op = 2;
            if (a.sFg.m(fdVar2)) {
                String str = fdVar2.bNo.fileName;
                ExtControlProviderMsg.a(this.iKf, new MatrixCursor(ExtControlProviderMsg.aIZ()));
                fj fjVar = new fj();
                fjVar.bNK.fileName = str;
                if (a.sFg.m(fjVar)) {
                    x.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[]{Long.valueOf(fjVar.bNL.bJC)});
                    if (fjVar.bNL.bJC > 0) {
                        try {
                            if (!fdVar2.bNo.bJm) {
                                ExtControlProviderMsg.a(this.iKf).addRow(new Object[]{this.dhB[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.dc(r2)});
                                this.iKf.pr(4);
                            } else if (ad.getContext() == null || !ao.isConnected(ad.getContext())) {
                                ExtControlProviderMsg.a(this.iKf).addRow(new Object[]{this.dhB[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.dc(r2)});
                                this.iKf.pr(4);
                            } else {
                                ExtControlProviderMsg.a(this.iKf).addRow(new Object[]{this.dhB[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.dc(r2)});
                                this.iKf.pr(0);
                            }
                        } catch (Throwable e) {
                            x.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            this.iKf.pr(4);
                        }
                    } else {
                        this.iKf.pr(3);
                    }
                } else {
                    this.iKf.pr(4);
                    ExtControlProviderMsg.a(this.iKf).close();
                    this.heb.countDown();
                    return;
                }
            }
            this.iKf.pr(4);
            this.heb.countDown();
            return;
        }
        this.heb.countDown();
    }
}
