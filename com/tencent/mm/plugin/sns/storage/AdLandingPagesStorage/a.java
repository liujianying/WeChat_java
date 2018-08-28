package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public ConcurrentHashMap<Long, WeakReference<a>> nzL;
    public ConcurrentHashMap<String, b> nzM;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.nzL = new ConcurrentHashMap();
        this.nzM = new ConcurrentHashMap();
        d.aCU();
        b.a(new 1(this));
    }

    public static void stopTask(long j) {
        d.aCU().cl(j);
    }

    public static long queryIdByAppid(String str) {
        FileDownloadTaskInfo yO = d.aCU().yO(str);
        return yO != null ? yO.id : Long.MAX_VALUE;
    }

    public final void I(int i, long j) {
        com.tencent.mm.plugin.downloader.c.a cz = ((c) g.l(c.class)).FX().cz(j);
        if (cz != null) {
            String str = cz.field_appId;
            cz = ((c) g.l(c.class)).FX().yK(str);
            if (cz == null) {
                x.i("MicroMsg.AdDownloadApkMgr", "downloadinfo not found");
                return;
            }
            String str2 = cz.field_packageName;
            String str3 = cz.field_md5;
            d(i, str, str2, cz.field_downloadUrl);
        }
    }

    private static String q(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(System.currentTimeMillis() / 1000);
        return stringBuilder.toString();
    }

    public final void d(int i, String str, String str2, String str3) {
        System.currentTimeMillis();
        b bVar = (b) this.nzM.get(str);
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replaceAll("\\.", "_");
        }
        x.i("MicroMsg.AdDownloadApkMgr", "reporting %d  %s", new Object[]{Integer.valueOf(14542), q(str, Integer.valueOf(i), str3, bVar == null ? "" : bVar.nyk + "." + bVar.fxE + "." + str2 + ".0.20.0")});
        x.d("MicroMsg.AdDownloadApkMgr", "14542  extinfo : " + r0);
        h.mEJ.a(14542, r1, true, false);
    }
}
