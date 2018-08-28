package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.a.f.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;

class b$6 implements Runnable {
    final /* synthetic */ int fiF;
    final /* synthetic */ b qBO;
    final /* synthetic */ String qBR;
    final /* synthetic */ String qBS;
    final /* synthetic */ String qBU;
    final /* synthetic */ String qBV;
    final /* synthetic */ int qBW;
    final /* synthetic */ boolean qBX;

    b$6(b bVar, String str, String str2, String str3, int i, int i2, String str4, boolean z) {
        this.qBO = bVar;
        this.qBR = str;
        this.qBU = str2;
        this.qBV = str3;
        this.qBW = i;
        this.fiF = i2;
        this.qBS = str4;
        this.qBX = z;
    }

    public final void run() {
        s Tn = q$a.qDx.Tn(this.qBR);
        String str = this.qBU;
        String str2 = this.qBV;
        int i = this.qBW;
        int i2 = this.fiF;
        String str3 = this.qBS;
        boolean z = this.qBX;
        if (Tn == null) {
            Tn = new s();
            Tn.field_keyVersion = i;
            Tn.field_encryptKey = str2;
            Tn.field_reportId = (long) i2;
            Tn.field_sampleId = str3;
            Tn.field_originalMd5 = str;
            q$a.qDx.g(Tn);
            j.n((long) i2, 51);
            j.n((long) i2, 45);
        } else if (Tn.field_keyVersion < i) {
            Tn.field_keyVersion = i;
            Tn.field_encryptKey = str2;
            Tn.field_reportId = (long) i2;
            Tn.field_sampleId = str3;
            if (bi.oW(Tn.field_originalMd5)) {
                Tn.field_originalMd5 = str;
            }
            q$a.qDx.g(Tn);
            b.a(Tn, true, z);
        } else if (z && Tn.field_keyVersion == i) {
            b.a(Tn, true, true);
        }
    }
}
