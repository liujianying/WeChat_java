package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import java.util.Arrays;
import java.util.List;

class d$4 implements Runnable {
    final /* synthetic */ String dhm;
    final /* synthetic */ b iaa;
    final /* synthetic */ d iam;
    final /* synthetic */ b iar;

    d$4(d dVar, b bVar, String str, b bVar2) {
        this.iam = dVar;
        this.iar = bVar;
        this.dhm = str;
        this.iaa = bVar2;
    }

    public final void run() {
        int i;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        au.HU();
        String Gp = c.Gp();
        String str = Gp + this.iar.getName().replace(".db", "temp.db");
        x.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[]{str});
        this.iar.a(new b(str));
        String str2 = Gp + "sqlTemp.sql";
        List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
        int[] iArr = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        boolean a = c.FO().a(str, this.dhm, str2, asList, new 1(this, iArr));
        if (a) {
            au.HU();
            c.FT().bdd();
            au.HU();
            c.FW().clB();
            au.HU();
            c.FT().bdf();
            au.HU();
            c.FT().bde();
            i = 12;
        } else {
            i = 15;
        }
        h.mEJ.a(181, (long) i, 1, true);
        x.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[]{Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(a ? 1 : 0);
        objArr[1] = iArr;
        objArr[2] = Long.valueOf(r2);
        hVar.h(11224, objArr);
        au.Em().cik();
        if (this.iaa != null) {
            this.iaa.ov(a ? 0 : -1);
        }
    }
}
