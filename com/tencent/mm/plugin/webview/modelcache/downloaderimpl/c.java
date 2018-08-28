package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<e> {
    private static final ConcurrentHashMap<String, Boolean> pTF = new ConcurrentHashMap();

    public c(e eVar) {
        super(eVar);
    }

    public final boolean acb() {
        return true;
    }

    public final boolean acc() {
        return false;
    }

    public final boolean acd() {
        return true;
    }

    public final boolean acf() {
        return false;
    }

    public final String aca() {
        return "WebViewCache";
    }

    public final boolean bM(long j) {
        if (super.bM(j) && j < 5242880) {
            return true;
        }
        return false;
    }

    protected final m a(j jVar) {
        if (pTF.putIfAbsent(((e) ach()).getFilePath(), Boolean.TRUE) != null) {
            x.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", ((e) ach()).qBy);
            return null;
        }
        m a = super.a(jVar);
        pTF.remove(((e) ach()).getFilePath());
        return a;
    }

    public static void clearCache() {
        pTF.clear();
    }
}
