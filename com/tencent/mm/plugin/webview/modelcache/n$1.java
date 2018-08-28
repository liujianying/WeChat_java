package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements a {
    final /* synthetic */ n pTf;

    n$1(n nVar) {
        this.pTf = nVar;
    }

    public final void a(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar.rcl != null && !bi.oW(ab.a(byVar.rcl))) {
            x.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
        }
    }
}
