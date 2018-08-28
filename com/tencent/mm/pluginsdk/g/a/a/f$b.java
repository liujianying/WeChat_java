package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f$b {
    static void a(s sVar, boolean z, boolean z2) {
        if (sVar == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
            return;
        }
        String str = sVar.field_urlKey;
        String str2 = sVar.field_filePath;
        String str3 = sVar.field_md5;
        boolean z3 = sVar.field_fileCompress;
        boolean z4 = sVar.field_fileEncrypt;
        Object obj = sVar.field_eccSignature;
        int i = bi.getInt(sVar.field_fileVersion, 0);
        int i2 = sVar.field_keyVersion;
        String str4 = sVar.field_encryptKey;
        boolean z5 = sVar.field_deleted;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z5 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + sVar.field_originalMd5 + ", fileCompress = " + z3 + ", fileEncrypt = " + z4 + ", eccSignature = " + obj + ", fileVersion = " + i + ", (encrypt key == empty) = " + bi.oW(str4));
        x.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
        if (!z4) {
            if (z) {
                j.n(sVar.field_reportId, 53);
                j.n(sVar.field_reportId, 45);
            }
            if (!z3) {
                x.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                return;
            }
        }
        if (i2 != i && z4) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 >= 0) {
                j.n(sVar.field_reportId, 52);
                j.n(sVar.field_reportId, 45);
            }
        } else if (z5) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
            j.n(sVar.field_reportId, 51);
            j.n(sVar.field_reportId, 45);
        } else if (bi.oW(str4) && z4) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
            j.n(sVar.field_reportId, 54);
            j.n(sVar.field_reportId, 45);
        } else if (bi.oW(str3) || bi.oW(str2)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
        } else if (a.ccH().To(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
        } else if (!bi.oV(g.cu(str2)).equals(str3)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
            sVar.field_status = 3;
            a.ccH().g(sVar);
            j.n(sVar.field_reportId, 56);
            j.n(sVar.field_reportId, 45);
        } else if (!a.ccH().To(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", sVar.field_urlKey);
            c.ccr().f(sVar.field_resType, sVar.field_subType, 1, bi.oV(sVar.field_groupId2).equals("NewXml"));
            if (z2) {
                c.ccr();
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", sVar.field_urlKey);
                k.f(sVar);
                return;
            }
            c.ccr().b(sVar);
        }
    }
}
