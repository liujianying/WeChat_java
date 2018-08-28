package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper.ResDownloaderPlugin;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.d.a;

class WebViewCacheDownloadHelper$ResDownloaderPlugin$1 implements d {
    final /* synthetic */ ResDownloaderPlugin pTE;

    WebViewCacheDownloadHelper$ResDownloaderPlugin$1(ResDownloaderPlugin resDownloaderPlugin) {
        this.pTE = resDownloaderPlugin;
    }

    public final void a(String str, m mVar) {
        b.c(str, mVar);
    }

    public final void b(String str, m mVar) {
        QJ(str);
        b.c(str, mVar);
    }

    public final void QI(String str) {
        QJ(str);
    }

    public final String aca() {
        return "WebViewCache";
    }

    private static void QJ(String str) {
        s Tn = q$a.qDx.Tn(str);
        if (Tn != null) {
            a.Tr(Tn.field_filePath);
        }
    }
}
