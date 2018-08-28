package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.sdk.platformtools.x;

class g$78 implements a {
    final /* synthetic */ g qiK;

    g$78(g gVar) {
        this.qiK = gVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.MsgHandler", "doUxSearchOpLog rsp errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        return 0;
    }
}
