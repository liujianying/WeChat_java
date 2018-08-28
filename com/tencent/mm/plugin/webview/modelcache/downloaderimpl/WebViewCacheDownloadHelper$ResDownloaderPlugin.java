package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.g;
import com.tencent.mm.pluginsdk.g.a.c.h;
import com.tencent.mm.pluginsdk.g.a.c.i;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class WebViewCacheDownloadHelper$ResDownloaderPlugin implements g {
    private final d pTD = new 1(this);

    public final void bUO() {
        a.ccH().a("WebViewCache", this.pTD);
    }

    public final void onAccountRelease() {
        c.clearCache();
        q ccH = a.ccH();
        String str = "WebViewCache";
        d dVar = this.pTD;
        if (ccH.fAQ) {
            i iVar = ccH.qDw;
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.qDa) {
                    List list = (List) iVar.qCZ.get(hashCode);
                    if (list == null) {
                        return;
                    }
                    list.remove(dVar);
                }
            }
        }
    }

    public final String aca() {
        return "WebViewCache";
    }

    public final n.a c(l lVar) {
        if (lVar != null && (lVar instanceof e)) {
            return new c((e) lVar);
        }
        x.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + lVar);
        return null;
    }

    public final h bUP() {
        return new d();
    }
}
