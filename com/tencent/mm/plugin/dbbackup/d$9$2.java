package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.dbbackup.d.9;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;

class d$9$2 implements Runnable {
    final /* synthetic */ boolean hZs;
    final /* synthetic */ b iaa;
    final /* synthetic */ 9 iay;

    d$9$2(9 9, boolean z, b bVar) {
        this.iay = 9;
        this.hZs = z;
        this.iaa = bVar;
    }

    public final void run() {
        d.a(this.iay.iam, null);
        au.HU();
        long length = new b(c.DR()).length();
        long cja = bi.cja();
        if (length == 0) {
            x.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
        } else if (length > d.f(this.iay.iam) || length > cja) {
            x.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
            h hVar = h.mEJ;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(10008);
            objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(cja)});
            hVar.h(11098, objArr);
        } else {
            d.d(this.iay.iam, this.iay.iam.a(this.hZs, this.iaa));
            if (d.o(this.iay.iam)) {
                x.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
            }
        }
    }
}
