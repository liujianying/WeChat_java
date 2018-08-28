package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ int fiF;
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;
    final /* synthetic */ int qBM;
    final /* synthetic */ b qBO;
    final /* synthetic */ boolean qBQ;
    final /* synthetic */ String qBR;
    final /* synthetic */ String qBS;

    b$4(b bVar, String str, int i, int i2, int i3, int i4, String str2, boolean z) {
        this.qBO = bVar;
        this.qBR = str;
        this.kPA = i;
        this.kPB = i2;
        this.qBM = i3;
        this.fiF = i4;
        this.qBS = str2;
        this.qBQ = z;
    }

    public final void run() {
        s Tn = q$a.qDx.Tn(this.qBR);
        int i = this.kPA;
        int i2 = this.kPB;
        int i3 = this.qBM;
        int i4 = this.fiF;
        String str = this.qBS;
        boolean z = this.qBQ;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + Tn);
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[]{Integer.valueOf(i3)});
        boolean z2 = false;
        if (Tn == null) {
            j.n((long) i4, 47);
            j.n((long) i4, 22);
            z2 = true;
        } else if (bi.getInt(Tn.field_fileVersion, 0) <= i3) {
            z2 = true;
        } else {
            j.n(Tn.field_reportId, 47);
            j.n(Tn.field_reportId, 22);
        }
        String ex = i.ex(i, i2);
        String Ti = i.Ti(ex);
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[]{Boolean.valueOf(z2), Ti});
        if (z2) {
            q$a.qDx.Tp(ex);
            b$c.qCd.f(i, i2, 2, z);
            if ((((a.Tr(Ti) & 1) & a.Tr(Ti + ".decompressed")) & a.Tr(Ti + ".decrypted")) != 0) {
                if (Tn != null) {
                    j.n(Tn.field_reportId, 21);
                    j.a(Tn.field_resType, Tn.field_subType, i3, z, Tn.field_sampleId);
                }
            } else if (Tn != null) {
                j.n(Tn.field_reportId, 22);
                j.n(Tn.field_reportId, 47);
            }
            if (Tn == null) {
                s sVar = new s();
                sVar.field_urlKey = ex;
                sVar.field_resType = i;
                sVar.field_subType = i2;
                sVar.field_deleted = true;
                sVar.field_fileVersion = String.valueOf(i3);
                sVar.field_reportId = (long) i4;
                sVar.field_sampleId = str;
                q$a.qDx.g(sVar);
                return;
            }
            Tn.field_deleted = true;
            Tn.field_fileVersion = String.valueOf(i3);
            q$a.qDx.g(Tn);
        }
    }
}
