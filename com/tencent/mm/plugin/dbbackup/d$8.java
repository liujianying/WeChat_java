package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.a.h;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.k.e;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class d$8 extends c<lw> {
    final /* synthetic */ d iam;

    d$8(d dVar) {
        this.iam = dVar;
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e AT = g.AT();
        if (com.tencent.mm.sdk.a.b.chp()) {
            d.a(this.iam, true);
            d.a(this.iam, Long.MAX_VALUE);
        } else {
            int i = AT.getInt("AndroidDBBackupPercentage", 0);
            au.HU();
            d.a(this.iam, h.aM(com.tencent.mm.model.c.Df(), 100) < i);
            d.a(this.iam, (long) AT.getInt("AndroidDBBackupMaxDBSizeMB", 0));
            d.a(this.iam, d.f(this.iam) * 1048576);
        }
        d.b(this.iam, (long) AT.getInt("AndroidDBBackupWaitSeconds", 600));
        d.b(this.iam, d.g(this.iam) * 1000);
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(d.h(this.iam));
        objArr[1] = d.f(this.iam) == Long.MAX_VALUE ? "not limited" : Long.valueOf(d.f(this.iam));
        objArr[2] = Boolean.valueOf(com.tencent.mm.sdk.a.b.chp());
        x.d(str, str2, objArr);
        d.a(this.iam, false);
        return true;
    }
}
