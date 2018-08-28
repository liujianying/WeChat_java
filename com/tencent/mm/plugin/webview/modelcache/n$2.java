package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.g.a.tv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class n$2 extends c<tv> {
    final /* synthetic */ n pTf;

    n$2(n nVar) {
        this.pTf = nVar;
        this.sFo = tv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tv tvVar = (tv) bVar;
        if (!(tvVar == null || !(tvVar instanceof tv) || bi.oW(tvVar.cfB.bVv))) {
            x.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
        }
        return false;
    }
}
