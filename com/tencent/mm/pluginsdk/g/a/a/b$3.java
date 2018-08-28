package com.tencent.mm.pluginsdk.g.a.a;

import android.os.Looper;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.pluginsdk.g.a.a.j.a;
import com.tencent.mm.pluginsdk.g.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements d {
    final /* synthetic */ b qBO;

    b$3(b bVar) {
        this.qBO = bVar;
    }

    public final void a(String str, m mVar) {
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + str);
        s Tn = q$a.qDx.Tn(str);
        if (Tn != null) {
            j.n(Tn.field_reportId, 10);
            j.n(Tn.field_reportId, 15);
            if ((!Tn.field_fileCompress || Tn.field_fileEncrypt) && Tn.field_fileUpdated) {
                j.a(Tn.field_resType, Tn.field_subType, Tn.field_url, bi.getInt(Tn.field_fileVersion, 0), Tn.field_maxRetryTimes > Tn.field_retryTimes ? a.qCz : a.qCx, true, bi.oV(Tn.field_groupId2).equals("NewXml"), false, Tn.field_sampleId);
            }
            if (Tn.field_fileCompress || Tn.field_fileEncrypt) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                this.qBO.b(Tn);
                return;
            }
            bc bcVar = new bc();
            bcVar.bIB.filePath = Tn.field_filePath;
            bcVar.bIB.bIF = Tn.field_fileUpdated;
            bcVar.bIB.bIE = bi.getInt(Tn.field_fileVersion, 0);
            bcVar.bIB.bIC = Tn.field_resType;
            bcVar.bIB.bID = Tn.field_subType;
            com.tencent.mm.sdk.b.a.sFg.a(bcVar, Looper.getMainLooper());
            Tn.field_fileUpdated = false;
            q$a.qDx.g(Tn);
        }
    }

    public final void b(String str, m mVar) {
        i.Tj(str);
        s Tn = q$a.qDx.Tn(str);
        if (Tn != null) {
            boolean z = true;
            if (!(mVar == null || mVar.qDk == null)) {
                if (mVar.qDk instanceof com.tencent.mm.pluginsdk.g.a.b.a) {
                    j.n(Tn.field_reportId, 7);
                    z = false;
                } else if (mVar.qDk instanceof c) {
                    j.n(Tn.field_reportId, 16);
                    z = false;
                }
            }
            if (z) {
                j.n(Tn.field_reportId, 11);
            }
            j.n(Tn.field_reportId, 44);
            j.a(Tn.field_resType, Tn.field_subType, Tn.field_url, bi.getInt(Tn.field_fileVersion, 0), a.qCy, false, "NewXml".equalsIgnoreCase(Tn.field_groupId2), false, Tn.field_sampleId);
        }
    }

    public final void QI(String str) {
        q ccH = q$a.qDx;
        if (!(ccH.fAQ ? ccH.qDv.isDownloading(str) : false)) {
            i.Tj(str);
        }
    }

    public final String aca() {
        return "CheckResUpdate";
    }
}
