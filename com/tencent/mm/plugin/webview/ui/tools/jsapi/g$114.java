package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.a;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.f;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class g$114 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ String qkb;

    g$114(g gVar, String str) {
        this.qiK = gVar;
        this.qkb = str;
    }

    public final void run() {
        List list = null;
        a.pTz;
        String str = this.qkb;
        if (!bi.oW(str)) {
            k bUI = k.bUI();
            if (bUI.fAQ && !bi.oW(str)) {
                list = bUI.n(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), new String[]{str});
            }
            if (!bi.cX(list)) {
                for (f fVar : list) {
                    a Qz = a.Qz(fVar.field_appId);
                    if (Qz != null) {
                        String str2 = fVar.field_localPath;
                        if (!bi.oW(str2)) {
                            long mI = str2.startsWith(Qz.path) ? FileOp.mI(str2) : 0;
                            if (FileOp.deleteFile(str2) && str2.startsWith(Qz.path)) {
                                b bVar = Qz.pSM;
                                String str3 = Qz.appId;
                                if (bVar.fAQ) {
                                    a.a aVar = new a.a((byte) 0);
                                    aVar.field_appId = str3;
                                    if (bVar.b(aVar, new String[0])) {
                                        aVar.field_occupation = Math.max(0, aVar.field_occupation - mI);
                                        bVar.c(aVar, new String[0]);
                                    }
                                }
                            }
                        }
                    }
                }
                k bUI2 = k.bUI();
                if (bUI2.fAQ && !bi.oW(str)) {
                    f fVar2 = new f();
                    fVar2.field_domain = str;
                    bUI2.a(fVar2, new String[]{"domain"});
                }
            }
        }
        WebViewCacheDownloadHelper.bUN();
    }
}
