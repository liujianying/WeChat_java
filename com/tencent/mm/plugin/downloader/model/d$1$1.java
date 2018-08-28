package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.c.c;
import com.tencent.mm.plugin.downloader.model.d.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class d$1$1 implements e {
    final /* synthetic */ 1 ibY;

    d$1$1(1 1) {
        this.ibY = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        lVar.dJc = true;
        h hVar;
        Object[] objArr;
        if (i == 0 && i2 == 0) {
            String string = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "yyb_pkg_sig_prefs", 4).getString(this.ibY.ibG.field_packageName, "");
            x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[]{string});
            if (bi.oW(string)) {
                h.mEJ.a(322, 26, 1, false);
                hVar = h.mEJ;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4026);
                objArr[1] = String.format("%s,%s", new Object[]{this.ibY.ibG.field_packageName, this.ibY.ibG.field_filePath});
                hVar.h(11098, objArr);
            } else {
                h hVar2;
                Object[] objArr2;
                try {
                    c.c(new File(this.ibY.ibG.field_filePath), string);
                    x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                    h.mEJ.a(322, 25, 1, false);
                    hVar2 = h.mEJ;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(4025);
                    objArr2[1] = String.format("%s,%s,%s", new Object[]{this.ibY.ibG.field_packageName, this.ibY.ibG.field_filePath, string});
                    hVar2.h(11098, objArr2);
                } catch (Exception e) {
                    x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                    h.mEJ.a(322, 27, 1, false);
                    hVar2 = h.mEJ;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(4027);
                    objArr2[1] = String.format("%s,%s,%s", new Object[]{this.ibY.ibG.field_packageName, this.ibY.ibG.field_filePath, e.getMessage()});
                    hVar2.h(11098, objArr2);
                }
            }
        } else {
            x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
            h.mEJ.a(322, 28, 1, false);
            hVar = h.mEJ;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4028);
            objArr[1] = String.format("%s,%s,%d,%d", new Object[]{this.ibY.ibG.field_packageName, this.ibY.ibG.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
            hVar.h(11098, objArr);
        }
        ah.A(new 1(this));
    }
}
