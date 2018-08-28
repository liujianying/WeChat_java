package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a {

    /* renamed from: com.tencent.mm.plugin.hp.a.a$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String kmu;
        final /* synthetic */ String kmv;
        final /* synthetic */ b kmw;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(String str, Context context, String str2, b bVar) {
            this.kmu = str;
            this.val$context = context;
            this.kmv = str2;
            this.kmw = bVar;
        }

        public final void run() {
            int i;
            if (e.cn(this.kmu)) {
                boolean i2 = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int b = b.b(i.eV(this.val$context), this.kmv, this.kmu, this.kmw.knk);
                SharePatchFileUtil.aj(new File(this.kmv));
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b)});
                i2 = b;
            }
            if (i2 == 0) {
                if (com.tencent.mm.c.a.cE(this.kmu)) {
                    String string;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[]{Boolean.valueOf(com.tencent.mm.c.a.cE(this.kmu))});
                    Context context = ad.getContext();
                    if (bi.oW(this.kmw.aWz())) {
                        string = context.getString(R.l.update_tip_recommended_down);
                    } else {
                        string = this.kmw.aWz();
                    }
                    bsx bsx = new bsx();
                    bsx.knj = this.kmw.knj;
                    bsx.title = context.getString(R.l.fmt_update);
                    bsx.sqq = context.getString(R.l.install_now);
                    bsx.kcL = context.getString(R.l.update_cancel);
                    bsx.knk = this.kmw.knk;
                    bsx.knl = this.kmw.knl;
                    bsx.gsu = this.kmw.fileSize;
                    bsx.knh = this.kmw.knh;
                    bsx.bxD = this.kmw.kni;
                    bsx.versionCode = this.kmw.versionCode;
                    bsx.sqp = this.kmu;
                    bsx.bIr = string;
                    i.a(bsx);
                    if (this.kmw.knf.intValue() == 3) {
                        h.mEJ.a(614, 58, 1, false);
                    }
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
                } else {
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                }
            } else {
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
            }
            switch (i2) {
                case -2:
                    h.mEJ.a(614, 53, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
                    return;
                case -1:
                    h.mEJ.a(614, 52, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
                    return;
                default:
                    return;
            }
        }
    }
}
